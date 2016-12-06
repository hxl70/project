package com.hxl.wx.service.impl;

import com.hxl.wx.handler.ResultHandler;
import com.hxl.wx.service.HttpsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Random;

/**
 * Created by hxl on 2016/11/21.
 */
@Service
public class HttpsServiceImpl implements HttpsService {

    public String get(String url) {
        return new Executor() {
            @Override
            public String callback(HttpURLConnection connection) throws IOException {
                connection.setDoInput(true);
                connection.setRequestMethod("GET");
                return getResponse(connection);
            }
        }.execute(url);
    }

    public String post(String url, String requestBody) {
        return new Executor() {
            @Override
            public String callback(HttpURLConnection connection) throws IOException {
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.setRequestMethod("POST");
                writeRequestBody(connection, requestBody);
                return getResponse(connection);
            }
        }.execute(url);
    }

    public String upload(String url, File file, Map<String, String> param) {
        return new Executor() {
            @Override
            public String callback(HttpURLConnection connection) throws IOException {
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.setRequestMethod("POST");
                String random = String.valueOf(new Random().nextLong());
                connection.setRequestProperty("Content-type", "multipart/form-data");
                connection.setRequestProperty("Connection", "Keep-Alive");
                
                final StringBuffer sb = new StringBuffer(256);

                //send param
                if (param != null) {
                    param.entrySet().stream().forEach((entry) -> {
                        sb.append(newLine)
                                .append("-----------------------------")
                                .append(random)
                                .append(newLine)
                                .append("Content-Disposition: form-data; name=\"")
                                .append(entry.getKey())
                                .append(newLine)
                                .append(newLine)
                                .append(entry.getValue());
                    });
                }

                //upload file
                String fileName = file.getName();
                sb.append("-----------------------------");
                sb.append(random);
                sb.append(newLine);
                sb.append("Content-Disposition: form-data; name=\"media\"; content-type=\"")
                        .append(fileName.substring(fileName.length() - 3))
                        .append("\"; filelength=\"")
                        .append(file.length())
                        .append("\"; filename=\"")
                        .append(fileName)
                        .append("\" ");
                sb.append(newLine);
                sb.append(newLine);

                DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
                dos.write(sb.toString().getBytes());
                DataInputStream dis = new DataInputStream(new FileInputStream(file));
                int bytes;
                byte[] bufferOut = new byte[1024];
                while ((bytes = dis.read(bufferOut)) != -1) {
                    dos.write(bufferOut, 0, bytes);
                }

                StringBuffer end = new StringBuffer(64);
                end.append(newLine);
                end.append("-----------------------------");
                end.append(random);
                end.append("--");
                end.append(newLine);
                dos.write(end.toString().getBytes());
                dos.flush();
                dos.close();
                dis.close();
                
                return getResponse(connection);
            }
        }.execute(url);
    }

    @Override
    public void download(String url, String filePath) {
        ((Executor) connection -> {
            connection.setDoInput(true);
            connection.setRequestMethod("GET");
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath));
            DataInputStream dis = new DataInputStream(connection.getInputStream());
            int bytes;
            byte[] bufferOut = new byte[1024];
            while ((bytes = dis.read(bufferOut)) != -1) {
                dos.write(bufferOut, 0, bytes);
            }
            dos.flush();
            dos.close();
            dis.close();
            return null;
        }).execute(url);
    }

}

interface Executor {
    Logger logger = LoggerFactory.getLogger(Executor.class);
    String newLine = "\r\n";

    /**
     * 处理日志和异常
     * @param url 请求的链接
     * @return 执行结果
     */
    default String execute(String url) {
        try {
            logger.debug(url);
            URL u = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) u.openConnection();
            connection.setRequestProperty("charset", "utf-8");
            String result = callback(connection);
            logger.debug(result);
            ResultHandler.handler(result);
            return result;
        } catch (IOException e) {
            logger.error("execute error ", e);
        } catch (Exception e) {
            logger.error("handler result error ", e);
        }
        return null;
    }

    /**
     * 
     * @param connection http请求链接
     * @return 链接结果
     * @throws IOException 读取出错时抛出异常
     */
    default String getResponse(HttpURLConnection connection) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append(newLine);
        }
        br.close();
        return sb.toString();
    }

    /**
     * 提交请求数据
     * @param connection http请求链接
     * @param requestBody 请求数据
     * @throws IOException 写入出错时抛出异常
     */
    default void writeRequestBody(HttpURLConnection connection, String requestBody) throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
        pw.write(requestBody);
        pw.flush();
        pw.close();
    }

    /**
     * 业务实现接口
     * @param connection http请求链接
     * @return 执行结果
     * @throws IOException 抛出异常
     */
    String callback(HttpURLConnection connection) throws IOException;
}

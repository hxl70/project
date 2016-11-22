package com.hxl.wx.service.impl;

import com.hxl.wx.handler.ResultHandler;
import com.hxl.wx.service.HttpsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hxl on 2016/11/21.
 */
@Service
public class HttpsServiceImpl implements HttpsService {

    private Logger logger = LoggerFactory.getLogger(HttpsService.class);

    public String get(String url) {
        logger.info("get url: {}", url);
        try {
            URL u = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) u.openConnection();
            connection.setDoInput(true);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("charset", "utf-8");

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            String result = sb.toString();

            logger.info("get success: {}", result);
            ResultHandler.handler(result);

            return result;

        } catch (IOException e) {
            logger.error("get error", e);
        }
        return null;
    }

    public String post(String url, String requestBody) {
        try {
            logger.info("get url: {}, requestBody: {}", url, requestBody);
            URL u = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) u.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("charset", "utf-8");

            PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
            pw.write(requestBody);
            pw.flush();
            pw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            String result = sb.toString();
            logger.info("post success: {}", result);
            ResultHandler.handler(result);

            return result;

        } catch (IOException e) {
            logger.error("post error", e);
        }
        return null;
    }
}

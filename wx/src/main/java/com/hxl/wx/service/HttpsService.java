package com.hxl.wx.service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hxl on 2016/11/18.
 * HTTPS 请求服务
 */
public class HttpsService {

    public static String get(String url) {
        try {
            URL u = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) u.openConnection();
            connection.setDoInput(true);
//            connection.setDoOutput(true);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("charset", "utf-8");

//            PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
//            pw.write("");
//            pw.flush();
//            pw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String post(String url, String param) {
        try {
            URL u = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) u.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("charset", "utf-8");

            PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
            pw.write(param);
            pw.flush();
            pw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

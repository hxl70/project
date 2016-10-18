package com.hxl;

import com.alibaba.fastjson.JSONReader;
import com.alibaba.fastjson.parser.JSONToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by hxl on 2016/9/27.
 */
public class BigFileTest {

    private static File file = new File("F:/citylots.json");

    public static void main(String[] args) throws IOException {
//        testJackson();
//        testFastJson();
//        JSONObject jo = new JSONObject(file);
    }

    private static void testJackson() throws IOException {
        long l = System.currentTimeMillis();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.readValue(file, Object.class);
        System.out.println(System.currentTimeMillis() - l);

        //17514 15947 16722 15861
    }

    private static void testFastJson() throws FileNotFoundException {
        long l = System.currentTimeMillis();
        JSONReader jsonReader = new JSONReader(new FileReader(file));
        jsonReader.startObject();
        while (jsonReader.hasNext()) {
            jsonReader.readObject();
        }
        jsonReader.endObject();
        jsonReader.close();
        System.out.println(System.currentTimeMillis() - l);
        //
    }
}

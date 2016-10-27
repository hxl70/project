package com.hxl;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hxl on 2016/9/27.
 */
public class Main {

    private static String json = "[{\"identity\":\"TV_POS_1\",\"type\":\"类型，广告、推荐等\",\"sourceData\":[{\"name\":\"名称\",\"src\":\"地址\",\"img\":\"海报\",\"content\":\"简介\"}]},{\"identity\":\"TV_POS_2\",\"type\":\"类型，广告、推荐等\",\"sourceData\":[{\"name\":\"名称\",\"src\":\"地址\",\"img\":\"海报\",\"content\":\"简介\"}]}]";

    public static void main(String[] args) throws IOException {
//        testFastJson();
//        System.gc();
//        testJackson();
        new Child("jack");
    }

    private static void testFastJson() {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            JSON.parseArray(json, EntityObject.class);
        }
        System.out.println(System.currentTimeMillis() - l);
    }

    private static void testJackson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        long l = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            objectMapper.readValue(json, typeFactory.constructCollectionType(List.class, EntityObject.class));
        }
        System.out.println(System.currentTimeMillis() - l);
    }
}

class People {
    String name;

    public People() {
        System.out.print(1);
        new Child();
    }

    public People(String name) {
        System.out.print(2);
        this.name = name;
    }
}

class Child extends People {
    People father;

    public Child(String name) {
        System.out.print(3);
        this.name = name;
        father = new People(name + ":F");
    }

    public Child() {
        System.out.print(4);
    }

}
package com.hxl;

/**
 * Created by hxl on 2016/10/27.
 */
public class TestClass extends AbstractClass {

    private String testService = "";

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        testClass.testUpdate();
    }

    @Override
    String setup() {
        testService.contains("save object return id");
        return "id";
    }

    //    @org.junit.Test
    public void testUpdate() {
        String id = getId();
        System.out.println(id);
    }

}

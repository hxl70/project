package com.hxl.singleton;

/**
 * Created by hxl on 2016/10/18.
 */
public class Singleton {

    private Singleton() {

    }

    private static class SingletonInstance {
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonInstance.instance;
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
    }

}

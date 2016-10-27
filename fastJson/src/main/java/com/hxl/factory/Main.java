package com.hxl.factory;

/**
 * Created by hxl on 2016/10/18.
 */
public class Main {

    public static void main(String[] args) {
        Factory factory = new IOSFactory();
        factory.getInterface().display();
        factory.getOperation().move();
    }
}

package com.deep.practise;

/**
 * Created by Administrator on 2017/8/17 0017.
 */
public class Singleton1 {

    private static  Singleton1 singleton1 = null;

    private Singleton1() {

    }

    public static synchronized Singleton1 getSingleton1() {
        if (singleton1 == null) {
            singleton1 = new Singleton1();
        }
        return singleton1;
    }
}

package com.deep.practise;

/**
 * Created by Administrator on 2017/8/17 0017.
 */
public class Singleton {

    private static final Singleton singleton = new Singleton();

    private Singleton () {

    }

    public static Singleton getSingleton() {
        return singleton;
    }
}

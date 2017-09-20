package com.deep.concurrent;

import com.google.common.collect.MapMaker;
import org.springframework.util.Assert;

import java.util.concurrent.ConcurrentMap;

/**
 * Created by Administrator on 2017/8/27 0027.
 */
public class WeakReferenceTest {


    public static void main(String[] args) throws InterruptedException {
        WeakReferenceTest tt = new WeakReferenceTest();
        tt.test();
    }

    public void test() {
        ConcurrentMap<Object, Object> concurrentMap = new MapMaker().weakKeys().makeMap();
        System.out.println(concurrentMap.isEmpty());
        String key1 = "aa";
        Object value1 = "vvv";
        concurrentMap.put(key1, value1);
        System.out.println(concurrentMap.get(key1));
        System.out.println("before:" + concurrentMap.size());

        key1 = null;
        System.gc();
        System.out.println("after:" + concurrentMap.size());
        System.out.println(concurrentMap.get("aa"));
        value1 = null;
        System.gc();
        System.out.println(concurrentMap.isEmpty());
        System.out.println("last:" + concurrentMap.size());
    }
}

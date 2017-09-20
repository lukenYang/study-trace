package com.deep.proxy.demo;

import com.deep.proxy.demo.impl.StudentDaoImpl;

/**
 * Created by Administrator on 2017/8/17 0017.
 */
public class StudentDemo {

    public static void main(String[] args) {
        StudentDao sd=new StudentDaoImpl();
        sd.login();
        sd.regist();
        System.out.println("----------");

        MyInvocationHandler handler=new MyInvocationHandler();
        StudentDao proxy=(StudentDao) handler.bind(sd);
        proxy.login();
        proxy.regist();
    }
}

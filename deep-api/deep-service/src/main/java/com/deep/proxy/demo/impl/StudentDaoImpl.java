package com.deep.proxy.demo.impl;

import com.deep.proxy.demo.StudentDao;

/**
 * Created by Administrator on 2017/8/17 0017.
 */
public class StudentDaoImpl implements StudentDao {

    @Override
    public void login() {
        System.out.println("登录");
    }

    @Override
    public void regist() {
        System.out.println("注册");
    }
}

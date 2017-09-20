package com.deep.proxy.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/8/17 0017.
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;
    public Object bind(Object target){
        //绑定一个委托对象，其实就是接口实现对象
        this.target=target;
        //返回一个代理对象
        return Proxy.newProxyInstance
                (target.getClass().getClassLoader(),
                        target.getClass().getInterfaces(), this);
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("权限检查");
        Object result= method.invoke(target, args);
        System.out.println("日志记录");
        return result;
    }
}

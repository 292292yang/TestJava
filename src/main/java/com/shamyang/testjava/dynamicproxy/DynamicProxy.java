package com.shamyang.testjava.dynamicproxy;

import com.shamyang.testjava.Echo;
import com.shamyang.testjava.EchoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by PC on 2017/7/7.
 */
public class DynamicProxy implements InvocationHandler{

    private Object target;

    /**
     * 绑定委托对象并返回一个代理类
     * @param target
     * @return
     */
    public Object bind(Object target) {
        this.target = target;
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);   //要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)
    }

    /**
     * 调用方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        System.out.println("事物开始");
        //执行方法
        result=method.invoke(target, args);
        System.out.println("事物结束");
        return result;
    }

    public static void main(String[] args) {
        DynamicProxy dp=new DynamicProxy();
        Echo echo= (Echo) dp.bind(new EchoImpl());
        echo.say("hello");
    }
}

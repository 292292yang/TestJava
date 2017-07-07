package com.shamyang.testjava;

/**
 * Created by shamyang on 2017/7/7.
 */
public class EchoImpl implements Echo {

    @Override
    public String say(String name) {
        System.out.println("hello,"+name);
        return name;
    }
}

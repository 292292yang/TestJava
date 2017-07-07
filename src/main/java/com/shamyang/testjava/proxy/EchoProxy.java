package com.shamyang.testjava.proxy;

import com.shamyang.testjava.Echo;
import com.shamyang.testjava.EchoImpl;

/**
 * Created by shamyang on 2017/7/7.
 */
public class EchoProxy implements Echo {

    private EchoImpl echo;

    @Override
    public String say(String name) {
        return echo.say(name);
    }
}

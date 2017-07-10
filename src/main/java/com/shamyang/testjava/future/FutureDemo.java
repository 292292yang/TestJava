package com.shamyang.testjava.future;

import java.util.concurrent.*;

/**
 * Created by PC on 2017/7/10.
 */
public class FutureDemo {

    private static class T implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "hello future";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es= Executors.newFixedThreadPool(1);
        FutureTask<String> futureTask=new FutureTask<>(new T());
        es.execute(futureTask);
        System.out.println(futureTask.get());
        es.shutdown();
    }
}

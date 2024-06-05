package com.implementCallable;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        创建线程
        IC ic1 = new IC();
        IC ic2 = new IC();
        IC ic3 = new IC();
//        创建开启服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
//        提交线程
        Future<Boolean> r1 = ser.submit(ic1);
        Future<Boolean> r2 = ser.submit(ic2);
        Future<Boolean> r3 = ser.submit(ic3);
//        获取结果
        boolean result1 = r1.get();
        boolean result2 = r1.get();
        boolean result3 = r1.get();
//        关闭服务
        ser.shutdown();
        System.out.println(result1+""+result2+""+result3);
    }
}

class IC implements Callable<Boolean>{
    @Override
    public Boolean call() throws Exception {
        return true;
    }
}

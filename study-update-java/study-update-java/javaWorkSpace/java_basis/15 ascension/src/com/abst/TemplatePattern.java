package com.abst;

public class TemplatePattern {
    public static void main(String[] args) {
        Job1 job1 = new Job1();
        Job2 job2 = new Job2();
        System.out.println(job1.time());
        System.out.println(job2.time());
    }
}

abstract class statisticalTime{
    public abstract void job();
    public long time(){
        long lStart = System.currentTimeMillis();
        job();
        long lEnd = System.currentTimeMillis();
        return lEnd -lStart;
    }
}

class Job1 extends statisticalTime{
    @Override
    public void job() {
        String s = "";
        for (int i = 0; i < 10000; i++) {
            s += i + "";
        }
    }
}

class Job2 extends statisticalTime{
    @Override
    public void job() {
        String s = "";
        for (int i = 0; i < 10000; i++) {
            s += i + "";
        }
    }
}

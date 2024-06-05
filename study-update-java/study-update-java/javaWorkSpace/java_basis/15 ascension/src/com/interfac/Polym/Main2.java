package com.interfac.Polym;

public class Main2 {
    public static void main(String[] args) {
        test(new AA[]{new BB(), new CC(), new CC(), new BB()});
    }

    public static void test(AA[] aa){
        for (int i = 0; i < aa.length; i++) {
            aa[i].say();
            if(aa[i] instanceof CC){
                // 转型
                ((CC)aa[i]).special();
            }
        }
    }
}

interface AA {
    void say();
}

class BB implements AA {

    @Override
    public void say() {
        System.out.println(1);
    }
}

class CC implements AA {
    @Override
    public void say() {
        System.out.println(2);
    }

    public static void special(){
        System.out.println("特别的");
    }
}
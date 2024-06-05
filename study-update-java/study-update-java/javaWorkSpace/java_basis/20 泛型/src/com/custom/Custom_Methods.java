package com.custom;

public class Custom_Methods {

    public static void main(String[] args) {
        TC<String,Double> tc = new TC<>();
        tc.say("msg");
        tc.speck(1d);
    }
}

class TC<T,D>{
//    泛型方法
    public <U> void say(U str){
        System.out.println(str);
    }

//    只是使用了泛型，并不是泛型方法
    public void speck(D d){
        System.out.println(d);
    }
}

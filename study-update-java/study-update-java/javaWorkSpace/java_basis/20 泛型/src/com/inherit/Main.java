package com.inherit;

public class Main {
    public static void say(Pe<?> msg){
        System.out.println(msg);
    }

    public static void speck(Pe<? extends Pe> msg){
        System.out.println(msg);
    }

    public static void taik(Pe<? super Pe> msg){
        System.out.println(msg);
    }

    public static void main(String[] args) {
        say(new Pe<String>());
        speck(new Pe<Pee>());
        taik(new Pe<P>());
    }
}
class P {

}
class Pe<T> extends P{

}

class Pee extends Pe{

}
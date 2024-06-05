package com.innerClass;

public class Main3 {
    public static void main(String[] args) {
        Son son = new Son();
        son.way();
    }
}

 class Father {
     public static void say(IFS ifs) {

     }
 }

class Son {
    public void way(){
        Father father = new Father(){
            public void say() {
                System.out.println("hi");
            }
        };
        Father father1 = new Father();
        father.say(new IFS() {
            @Override
            public void way() {
            }
        });
        System.out.println(father.getClass());
        System.out.println(father1.getClass());
    }
}

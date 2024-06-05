package com.innerClass;

public class Main6 {
    public static void main(String[] args) {
        Father6.Father6Inner father6Inner = new Father6.Father6Inner();
        father6Inner.print();
    }
}

class Father6 {
    private static int a = 0;
    static class Father6Inner{
        private int a = 1;
        public void print(){
            System.out.println(a);
            System.out.println(Father6.a);
        }
    }
}

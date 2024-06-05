package com.innerClass;

public class Main5 {
    public static void main(String[] args) {
        Father5 father5 = new Father5();
        Father5.Father5Inner f = father5.rFather5Inner();
        f.print();
    }
}

class Father5 {
    private int a = 0;
    class Father5Inner{
        private int a = 1;
        public void print(){
            System.out.println(a);
            System.out.println(Father5.this.a);
        }
    }

    public Father5Inner rFather5Inner(){
        return new Father5Inner();
    }
}
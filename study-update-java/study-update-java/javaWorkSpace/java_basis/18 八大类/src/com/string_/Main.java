package com.string_;

public class Main {
    public static String str = new String("hsp");
    final char[] ch = {'j','a','v','a'};
    public void change(String str, char[] ch){
        str = "java";
        ch[0] = 'h';
    }
    public static void main(String[] args) {
        Main ma = new Main();
        ma.change(ma.str,ma.ch);
        System.out.println(ma.str+"and"); //hspand
        System.out.println(ma.ch); // hava
    }
}


package com.interfac.Polym;

public class Main3 {
    public static void main(String[] args) {
        AAA aaa = new CCC();
        BBB bbb = new CCC();
    }
}

interface AAA extends BBB{

}

interface BBB {

}

class CCC implements AAA {

}
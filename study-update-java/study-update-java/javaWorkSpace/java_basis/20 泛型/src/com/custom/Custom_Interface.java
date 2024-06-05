package com.custom;

public class Custom_Interface {
    public static void main(String[] args) {

    }
}

interface IA<T,D> {

}

interface IB extends IA<String,Double>{

}

class IC implements IA<String,Double>{

}

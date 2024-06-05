package com.super_;

public class Son extends Father {
    public double money;
    public Son(double money){
        this.money = money + super.money;
    }
}
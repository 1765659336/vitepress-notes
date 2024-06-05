package com.polymorphism;

public class Master2 {
    private String name;

    public Master2(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*喂狗食物*/
    public void feed(Animal animal, Food food){
        System.out.println(this.name + "给" + animal.getName()+"喂"+food.getName());
    }
}

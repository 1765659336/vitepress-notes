/**
 * author: Jie
 * date: 2022/3/14 11:39
 * description: 描述
 */

package com.throwsException;

public class Main {
    public static void main(String[] args) {
        calculate(1,0);
    }

    // 多异常列表
    public static void calculate(int num1,int num2) throws ArithmeticException,ClassCastException{
        System.out.println(num1 / num2);
    }
}

class A{

    /*public void hhh(){
        // 直接调用抛出编译异常（编译异常必须要处理）的方法，但是没有处理，会报错
        say();
    }*/

    public void hhh(){
        try {
            say();
        }catch(Exception e){

        }
    }

    public void say() throws Exception{

    }
}

class B extends A {
    // 子类重写父类的方法，遵循异常的继承规则（它或者它的子类）
    @Override
    public void say() throws NullPointerException {

    }
}

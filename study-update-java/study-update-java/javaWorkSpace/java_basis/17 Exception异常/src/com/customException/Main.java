/**
 * author: Jie
 * date: 2022/3/14 12:02
 * description: 描述
 */

package com.customException;

public class Main {
    public static void main(String[] args) {
        check(130);
    }

    public static void check(int age){
        if(age < 0 || age > 120){
            throw new AgeException("年龄不在0到120之间");
        }
        System.out.println("年龄正确");
    }
}

class AgeException extends RuntimeException{
    public AgeException(String message) {
        super(message);
    }
}

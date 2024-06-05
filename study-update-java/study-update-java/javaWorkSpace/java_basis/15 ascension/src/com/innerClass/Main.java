package com.innerClass;

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.say();
    }
}

class Outer {
    private int a = 0;

    public void say() {
        System.out.println("nihao");
        way();
    }

    public void run(){
        System.out.println("run");
    }

    public void way() {
        // 2.它的地位就是一个局部变量，因此可以用final修饰，被final修饰之后不能被继承
        final class Inner {
            // 4.作用域：仅仅在定义它的方法或代码块中
            {
                // 1.可以直接访问外部的所有成员，包括私有的
                System.out.println(a);
                // 7.如果外部类和局部内部类的成员重名时，遵循就近原则，如果要访问外部类的成员则可以使用外部类名.this.成员名
                run();
                Outer.this.run();
                // 此时这个this就是这个局部内部类
                System.out.println(this);
            }

            public void print() {
                System.out.println("print");
            }

            public void run() {
                System.out.println("内部类");
            }
        }

        // 3.本质上还是一个类，如果没有被final修饰就可以被继承
        class Father {

        }

        class Son extends Father {

        }

        // 5.外部类访问局部类的成员方式，先创建对象,必须在作用域中
        Inner inner = new Inner();
        inner.print();
    }
}

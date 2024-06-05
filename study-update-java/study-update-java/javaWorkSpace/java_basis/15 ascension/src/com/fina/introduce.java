package com.fina;

public class introduce {
    public static void main(String[] args) {
        // Father.name = "hhh";

    }
}

class Father {
    //    类的属性不想被修改
    public static final String name = null;

    //方法不想被重写
    public final void say() {
//        局部变量不想被修改
        final int a = 0;
        System.out.println("父hi");
//        a = 1;
    }
}

//类不想被继承
final class Son extends Father {
//    public void say() {
//        System.out.println("子hi");
//    }
}

//class SonSon extends Son {
//
//}

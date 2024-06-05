package com.List_;

import java.util.ArrayList;
import java.util.List;

public class Methods_ {
    public static void main(String[] args) {
        /*
8、subList(int fromIndex, int toIndex)返回从fromIndex到toIndex位置的子集合*/
        List list = new ArrayList();
        List list2 = new ArrayList();
        list2.add("f");
        list2.add("g");
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("a");
        list.addAll(list2);
        list.remove(2);
        list.set(1,"h");
        System.out.println(list.get(1));
        System.out.println(list.indexOf("a"));
        System.out.println(list.lastIndexOf("a"));
        System.out.println(list.subList(0,3));
        System.out.println(list);
    }
}

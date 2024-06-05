package com.Collection_;

import java.util.ArrayList;

public class Collection_ {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("jack");
        System.out.println(list.contains("jack"));
        list.remove("jack");
        System.out.println(list.isEmpty());
        ArrayList list2 = new ArrayList();
        list2.add("marin");
        list2.add("jay");
        list.addAll(list2);
        System.out.println(list.containsAll(list2));
        list.removeAll(list2);
        System.out.println(list.size());
        System.out.println(list);
    }
}

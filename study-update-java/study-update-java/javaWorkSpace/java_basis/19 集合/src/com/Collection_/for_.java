package com.Collection_;

import java.util.ArrayList;

public class for_ {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new People("zhangsan", 18.5, "nan"));
        arrayList.add(new People("zhangsan", 20, "nan"));
        arrayList.add(new People("zhangsan", 21.5, "nan"));
        for (Object o :arrayList) {
            System.out.println(o);
        }

        for (int i = 0; i < arrayList.size(); i++) {
            Object o = arrayList.get(i);
            System.out.println(o);
        }
    }
}

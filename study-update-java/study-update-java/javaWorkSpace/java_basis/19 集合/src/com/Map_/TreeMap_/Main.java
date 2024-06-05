package com.Map_.TreeMap_;

import java.util.Comparator;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
//        1、使用无参构造器，是无序的
        TreeMap treeMap = new TreeMap();
        treeMap.put("ad","ad");
        treeMap.put("abc","abc");
        treeMap.put("zxmn","zxmn");
        System.out.println(treeMap);
//        2、传入比较器
        TreeMap treeMap2 = new TreeMap(new Comparator() {
//            按照key字符串的长度排序
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        treeMap2.put("ad","ad");
        treeMap2.put("abc","abc");
        treeMap2.put("zxmn","zxmn");
        System.out.println(treeMap2);
    }
}

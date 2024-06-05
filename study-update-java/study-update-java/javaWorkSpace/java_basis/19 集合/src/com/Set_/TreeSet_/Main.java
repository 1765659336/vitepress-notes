package com.Set_.TreeSet_;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
//        无参构造器，是无序的
        TreeSet treeSet = new TreeSet();
        treeSet.add("dddd");
        treeSet.add("a");
        treeSet.add("ccc");
        System.out.println(treeSet);
//        传入一个比较器匿名内部类
        TreeSet treeSet2 = new TreeSet(new Comparator(){
//          比较两个字符串第一个字母的哈希值大小
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).compareTo((String) o2);
            }
        });
        treeSet2.add("d");
        treeSet2.add("ada");
        treeSet2.add("c");
        System.out.println(treeSet2);
    }
}

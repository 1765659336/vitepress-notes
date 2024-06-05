package com.Collections_;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List list = new LinkedList();
        list.add("abc");
        list.add("sadsd");
        list.add("ddqda");
        list.add("abcsda");
        System.out.println(list);// [abc, sadsd, ddqda, abcsda]
        Collections.reverse(list);
        System.out.println(list);// [abcsda, ddqda, sadsd, abc]
        Collections.shuffle(list);
        System.out.println(list);// [ddqda, abcsda, sadsd, abc] 某一次随机的结果
        Collections.sort(list);
        System.out.println(list);// [abc, abcsda, ddqda, sadsd]
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        System.out.println(list);// [abc, ddqda, sadsd, abcsda]
        Collections.swap(list,0,3);
        System.out.println(list);// [abcsda, ddqda, sadsd, abc]
        System.out.println(Collections.max(list)); //sadsd
        System.out.println(Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        }));// abcsda
        System.out.println(Collections.min(list));// abc
        System.out.println(Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o2).length() - ((String) o1).length();
            }
        }));// abc
        System.out.println(Collections.frequency(list,"abc"));// 1
        List list2 = new LinkedList();
        list2.add("mmmmm");
        list2.add("nnnnn");
        Collections.copy(list,list2);
        System.out.println(list);// [mmmmm, nnnnn, sadsd, abc]
        Collections.replaceAll(list,"abc","cba");
        System.out.println(list);// [mmmmm, nnnnn, sadsd, cba]
    }
}

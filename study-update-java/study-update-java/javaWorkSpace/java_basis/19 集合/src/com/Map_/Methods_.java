package com.Map_;

import java.util.*;

public class Methods_ {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("b","aa");
        map.put("a","aa");
        map.put(null,"null");
        map.put("c",null);
//        1、先拿到key
//        1.1、增强for
        Set keyset = map.keySet();
        for (Object o :keyset) {
            System.out.println(o+"-"+map.get(o));
        }
//        1.2、迭代器
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next+"-"+map.get(next));
        }
//        2、直接拿到所有的values
        Collection values = map.values();
        for (Object o :values) {
            System.out.println("key-"+o);
        }
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            Object next = iterator1.next();
            System.out.println("key-"+next);
        }
//        3、通过EntrySet来获取k-v
        Set entrySet = map.entrySet();
        for (Object o :entrySet) {
            Map.Entry m = (Map.Entry) o;
            System.out.println(m.getKey()+"-"+m.getValue());
        }
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()) {
            Map.Entry next = (Map.Entry) iterator2.next();
            System.out.println(next.getKey()+"-"+next.getValue());
        }
    }
}

package com.stringbuffer_;

public class Main {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("abcd");
        System.out.println(stringBuffer); // abcd
        stringBuffer.delete(0,2);
        System.out.println(stringBuffer);
        stringBuffer.replace(0,1,"e"); // cd
        System.out.println(stringBuffer.indexOf("e")); // 0
        stringBuffer.insert(1,"f");
        System.out.println(stringBuffer); // efd
        System.out.println(stringBuffer.length()); // 3
    }
}

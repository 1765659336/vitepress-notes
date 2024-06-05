package com.stringbuffer_;

public class Conversion {
    public static void main(String[] args) {
        /*String --> StringBuffer
        1、使用构造器StringBuffer(String str)
        2、使用append方法
        StringBuffer --> String
        1、StringBuffer对象的toString()
        2、使用构造器String(StringBuffer buffer)*/
        String str = "abc";
        StringBuffer stringBuffer = new StringBuffer(str);
        StringBuffer stringBuffer2 = new StringBuffer().append(str);
        System.out.println(stringBuffer);
        System.out.println(stringBuffer2);
//        --------------------------------
        String str2 = stringBuffer.toString();
        String str3 = new String(stringBuffer);
        System.out.println(str2+str3);

    }
}

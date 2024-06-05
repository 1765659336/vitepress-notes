package com.date_;

import java.text.SimpleDateFormat;
import java.util.Date;

public class First {
    public static void main(String[] args) {
//        获取系统当前时间
        Date date = new Date();
        System.out.println(date);
//        根据传递的long毫秒来生成时间
        Date date2 = new Date(123123123123l);
        System.out.println(date2);
//        创建SimpleDateFormat对象，可以指定相应的格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String format = simpleDateFormat.format(new Date());
        System.out.println(format);
//      转换String字符串来生成时间
        String s = "20200220";
        try{
            Date parse = simpleDateFormat.parse(s);
            System.out.println(parse);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

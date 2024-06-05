package com.date_;

import java.util.Calendar;

public class Second {
    public static void main(String[] args) {
//        Calendar是抽象的，不能直接被实例化
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println("年"+calendar.get(Calendar.YEAR));
        System.out.println("月"+(calendar.get(Calendar.MONTH)+1));
        System.out.println("日"+calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("时"+calendar.get(Calendar.HOUR));
        System.out.println("时24小时制"+calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("分"+calendar.get(Calendar.MINUTE));
        System.out.println("秒"+calendar.get(Calendar.SECOND));
//        Calender 没有专门的格式化方法，需要自己组合显示
    }
}

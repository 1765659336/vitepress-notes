package com.date_;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Third {
    public static void main(String[] args) {
//        获取当前时间
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = localDate.atTime(LocalTime.now());
        System.out.println(localDateTime); // 2022-03-21
        System.out.println("年"+localDateTime.getYear());
        System.out.println("月"+localDateTime.getMonth());
        System.out.println("月"+localDateTime.getMonthValue());
        System.out.println("日"+localDateTime.getDayOfMonth());
        System.out.println("时"+localDateTime.getHour());
        System.out.println("分"+localDateTime.getMinute());
        System.out.println("秒"+localDateTime.getSecond());
//        格式化format
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String str = localDate.format(dateTimeFormatter);
        System.out.println(str);
    }
}

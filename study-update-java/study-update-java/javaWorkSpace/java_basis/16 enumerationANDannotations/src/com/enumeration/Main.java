package com.enumeration;

public class Main {
    public static void main(String[] args) {
        Season a = Season.Spring;
        System.out.println(a.getSeason());
        System.out.println(a.getSpecialty());
    }
}

class Season {
    /**
     * @season 季节
     * @specialty 特点
     */
    private String season;
    private String specialty;

    public static final Season Spring = new Season("春天", "多雨");
    public static final Season Summer = new Season("夏天", "炎热");
    public static final Season Autumn = new Season("秋天", "凉爽");
    public static final Season Winter = new Season("冬天", "暴雪");

    private Season(String season, String specialty) {
        this.season = season;
        this.specialty = specialty;
    }

    public String getSeason() {
        return season;
    }

    public String getSpecialty() {
        return specialty;
    }
}

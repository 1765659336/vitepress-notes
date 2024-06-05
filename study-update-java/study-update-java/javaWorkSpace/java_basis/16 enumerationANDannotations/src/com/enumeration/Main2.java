/**
 * author: Jie
 * date: 2022/3/13 12:53
 * description: 描述
 */

package com.enumeration;

public class Main2 {
    public static void main(String[] args) {
        Season2 s2 = Season2.Spring;
        /*
        1.name() 返回的是这个枚举的常量名
        * 源码
        * public final String name() {
            return name;
          }
        * */
        System.out.println(s2.name()); // Spring
        /*
        * 2.toString() 返回当前枚举的常量名
        * 源码
        * public String toString() {
            return name;
          }
        * */
        System.out.println(s2.toString()); // Spring
        /*
        * 3.ordinal() 返回当前枚举在枚举类中定义的顺序默认从0开始
        * 源码
        * public final int ordinal() {
            return ordinal;
        }
        * */
        System.out.println(s2.ordinal()); // 0
        /*
        * 4.values() 返回数组，定义的所有的枚举
        * ！！在Enum源码中看不见，但是通过javap可以看见
        * */
        Season2[] values = Season2.values();
        for(Season2 season2:values){
            System.out.println(season2);
        }
        /*
        * 5.valueOf() 将字符串转换成枚举变量，前提是字符串必须是已经有的枚举常量，否则报异常
        * 源码
        * public static <T extends Enum<T>> T valueOf(Class<T> enumType,String name) {
            T result = enumType.enumConstantDirectory().get(name);
            if (result != null)
                return result;
            if (name == null)
                throw new NullPointerException("Name is null");
                throw new IllegalArgumentException("No enum constant " + enumType.getCanonicalName() + "." + name);
          }
        * */
        System.out.println(Season2.valueOf("Autumn").getSeason());
        /*
        * 6. compareTo() 查看两个枚举定义的顺序相差多少
        * 源码
        * public final int compareTo(E o) {
            Enum<?> other = (Enum<?>)o;
            Enum<E> self = this;
            if (self.getClass() != other.getClass() && // optimization
                self.getDeclaringClass() != other.getDeclaringClass())
                throw new ClassCastException();
            return self.ordinal - other.ordinal;
          }
        * */
        System.out.println(Season2.Spring.compareTo(Season2.Autumn));
    }
}

enum Season2{
    Spring("春天", "多雨"),
    Summer("夏天", "炎热"),
    Autumn("秋天", "凉爽"),
    Winter("冬天", "暴雪"),
    A;
    /**
     * @season 季节
     * @specialty 特点
     */
    private String season;
    private String specialty;

    private Season2(String season, String specialty) {
        this.season = season;
        this.specialty = specialty;
    }

    //    无参构造器
    private Season2() {

    }

    public String getSeason() {
        return season;
    }

    public String getSpecialty() {
        return specialty;
    }
}

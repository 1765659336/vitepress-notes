public class AllVariable {
    public static void main(String[] args){
        /* 
            整型：int
            double
            char
            String
        */
        /* 
            1.变量必须先声明再使用
            2.变量 = 数据类型 + 变量名 + 变量值
        */
        String name = "zhangsan";
        int age = 18;
        char gender = '男'; //为什么不能用"" 而是用''
        double score = 88.8;
        System.out.println(name); // zhangsan
        System.out.println(age); // 18
        System.out.println(gender); // 男
        System.out.println(score); // 88.8
    }
}

public class overloading {
    public static void main(String[] args){
        test((int)1);
        test((double)1);
    }

    public static void test(int i){
        System.out.println(i+"方法1");
    }

    public static void test(double db){
        System.out.println(db+"方法2");
    }
}

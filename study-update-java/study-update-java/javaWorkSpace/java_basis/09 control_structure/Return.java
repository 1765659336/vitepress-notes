public class Return {
    public static void main(String[] args) {
        System.out.println("1");
        for (int i = 0; i < 2; i++) {
            return;
        }
        // 不会执行输出"2"
        System.out.println("2");
    }
}

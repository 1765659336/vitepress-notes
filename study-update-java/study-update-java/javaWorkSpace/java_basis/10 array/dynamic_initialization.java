import java.util.Scanner;

public class dynamic_initialization {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        double[] arr = new double[5];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个值");
            arr[i] = myScanner.nextDouble();
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println("你输入的第" + (i + 1) + "个值是" + arr[i]);
        }
    }
}

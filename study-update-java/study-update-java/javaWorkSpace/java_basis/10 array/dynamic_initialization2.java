import java.util.Scanner;

public class dynamic_initialization2 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        double[] arr;
        // 满足某种条件的时候再分配空间
        if(true){
            arr = new double[5];
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个值");
            arr[i] = myScanner.nextDouble();
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println("你输入的第" + (i + 1) + "个值是" + arr[i]);
        }
    }
}

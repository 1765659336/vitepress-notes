import java.util.Scanner;

public class yang_hui_triangle {
    public static void main(String[] args) {
        System.out.println("请输入一个数字，表示你要打印一个多少行的杨辉三角");
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[i+1];
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 0 || j == arr[i].length - 1) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
            System.out.println("\t");
        }
    }
}

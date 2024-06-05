import java.util.Scanner;
/* 
    思路：1、copy原数组长度加1的一个同类型数组
        2、copy的数组添加新元素
        3、将copy的数组赋值给原数组
*/
public class array_capacity {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入y/n选择是否对数组进行扩容");
            char isChoose = scanner.next().charAt(0);
            if (isChoose == 'y') {
                System.out.println("请输入你要扩容的值");
                int addValue = scanner.nextInt();
                int[] arrCopy = new int[arr.length + 1];
                for (int i = 0; i < arr.length; i++) {
                    arrCopy[i] = arr[i];
                }
                arrCopy[arrCopy.length - 1] = addValue;
                arr = arrCopy;
            } else {
                for (int i = 0; i < arr.length; i++) {
                    System.out.println(arr[i]);
                }
                break;
            }
        }
    }
}

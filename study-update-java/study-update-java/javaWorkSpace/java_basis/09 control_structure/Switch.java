import java.util.Scanner;

public class Switch {
    public static void main(String[] args){
        System.out.println("请输入a,b,c,d,e,f,g");
        Scanner myScanner = new Scanner(System.in);
        // 将字符串第一位转换为一个字符
        char c1 = myScanner.next().charAt(0);
        switch(c1){
            // char型用''表示，而不是""
            case 'a':
            System.out.println("星期一");
            break;
            case 'b':
            System.out.println("星期二");
            break;
            case 'c':
            System.out.println("星期三");
            break;
            case 'd':
            System.out.println("星期四");
            break;
            case 'e':
            System.out.println("星期五");
            break;
            case 'f':
            System.out.println("星期六");
            break;
            default:
            System.out.println("星期日");
        }
    }
}

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* 系统的锁 */
        boolean lock = true;
        Scanner scanner = new Scanner(System.in);
        String choose;
        PiggyBank piggyBank = new PiggyBank();
        do {
            System.out.println("零钱通系统\n1.零钱通明细\n2.收益入账\n3.消费或存钱\n4.退出\n请输入数字选择");
            choose = scanner.next();
            switch(choose){
                case "1":
                    System.out.println("零钱通明细");
                    for (int i = 0; i < piggyBank.allMoneyArray.length; i++) {
                        if(piggyBank.allMoneyArray[i] != null){
                            System.out.println(piggyBank.allMoneyArray[i].date + "\t"+ piggyBank.allMoneyArray[i].amountOfQuantity+ "\t"+ piggyBank.allMoneyArray[i].describe+"\n");
                        }
                    }
                    break;
                case "2":
                    System.out.println("收益入账明细");
                    for (int i = 0; i < piggyBank.depositMoneyArray.length; i++) {
                        if(piggyBank.depositMoneyArray[i] != null){
                            System.out.println(piggyBank.depositMoneyArray[i].date + "\t"+ piggyBank.depositMoneyArray[i].amountOfQuantity+ "\t"+ piggyBank.depositMoneyArray[i].describe+"\n");
                        }
                    }
                    break;
                case "3":
                    System.out.println("消费/存入");
                    System.out.println("请输入金额大小");
                    double moneySize = scanner.nextDouble();
                    Money money = null;
                    if(moneySize > 0){
                        // 存入
                        money = new Money(new Date(),moneySize);
                    }else if(moneySize < 0){
                        // 消费
                        System.out.println("这笔钱用作什么？请描述");
                        String describe = scanner.next().toString();
                        money = new Money(new Date(),moneySize,describe);
                    }
                    piggyBank.addMoney(money);
                    break;
                case "4":
                    lock = false;
                    break;
                default:
                    System.out.println("您的输入有误，请重新输入数字进行选择");
            }
        }while(lock);
        System.out.println("退出零钱通系统");
    }
}

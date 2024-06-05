public class methods {
    public static void main(String[] args){
        People person = new People();
        person.run();
        int sum = person.getSum(1,2);
        System.out.println(sum);
    }
}

class People {
    String name;
    String age;
    public void run(){
        System.out.println("奔跑");
    };
    public int getSum(int num1,int num2){
        return num1 + num2;
    }
}
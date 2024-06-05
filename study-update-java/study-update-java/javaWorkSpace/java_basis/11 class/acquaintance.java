public class acquaintance {
    public static void main(String[] args){
        Cat cat1 = new Cat();
        cat1.name = "小花";
        cat1.age = 4.5;
        cat1.color = "花色";
        System.out.println(cat1.color);
    }   
}

class Cat {
    String name;
    double age;
    String race = "哺乳动物";
    String color;
    String [] hobby;
}

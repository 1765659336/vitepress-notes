public class constructor {
    public static void main(String[] args){
        Dog cat = new Dog("小花",5.0);
        System.out.println(cat.name);
    }
}

class Dog{
    String name;
    double age;
    Dog(String nameA, double ageA){
        name = nameA;
        age = ageA;
    }
}

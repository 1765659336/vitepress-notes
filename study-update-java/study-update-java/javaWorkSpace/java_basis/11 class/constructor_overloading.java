public class constructor_overloading{
    public static void main(String[] args){
        Fish fish1 = new Fish("草鱼");
        Fish fish2 = new Fish("鲫鱼","黑色");
    }
}

class Fish{
    String name;
    String hobby;
    String color;
    Fish(String nameA){
        System.out.println("1");
        name = nameA;
    }
    Fish(String nameA,String colorA){
        System.out.println("2");
        name = nameA;
        color = colorA;
    }
}
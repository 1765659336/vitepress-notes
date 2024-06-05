public class _this{
    public static void main(String[] args){
        Bear bear = new Bear("北极熊");
        System.out.println(bear.name);
    }
}

class Bear{
    String name;
    String hobby;
    String color;
    Bear(String name){
        this.name = name;
    }
}
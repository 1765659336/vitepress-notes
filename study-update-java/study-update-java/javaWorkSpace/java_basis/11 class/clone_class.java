public class clone_class {
    public static void main(String[] args){
        Obj obj = new Obj();
        obj.name = "zhangsan";
        obj.age = 18.5;
        Obj objCopy = Copy(obj);
        System.out.println(objCopy.name);
        objCopy.name = "lisi";
        System.out.println(objCopy.name);
        System.out.println(obj.name);
    }

    public static Obj Copy(Obj obj){
        Obj objCopy = new Obj();
        objCopy.name = obj.name;
        objCopy.age = obj.age;
        return objCopy;
    }
}

class Obj {
    String name;
    double age;
}
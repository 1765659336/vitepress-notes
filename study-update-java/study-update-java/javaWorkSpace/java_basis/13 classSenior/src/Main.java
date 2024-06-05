import com.xiaoqiang.Dog;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        /*这个dog类带上了包名，就是为了区分*/
        com.xiaoming.Dog dog2 = new com.xiaoming.Dog();
    }
}

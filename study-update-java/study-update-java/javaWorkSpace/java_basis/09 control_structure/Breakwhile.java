public class Breakwhile {
    public static void main(String[] args) {
        while(true){
            int result = (int)(Math.random() * 100);
            if( result == 99){
                System.out.println(result);
                break;
            }else {
                System.out.println(result);
            }
        }
    }
}

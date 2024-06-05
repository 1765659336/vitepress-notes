public class Loopnesting {
    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            for (int j = 0; j < 2 * i - 1; j++) {
                if(j==0 || j== 2 * i - 2 || i == 4){
                    System.out.println("*");
                }else {
                    System.out.println("0");
                }
            }
            System.out.println("\n");
        }
    }
}

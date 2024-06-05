public class Breakforfor {
    public static void main(String[] args){
        label1:for (int i = 0; i < 3; i++){
            System.out.println("i"+i);
            label2:for (int j = 0; j < 3; j++){
                System.out.println("j"+j);
                for (int k = 0; k < 3; k++){
                    if(k == 1){
                        break label2;
                    }
                    System.out.println("k"+k);
                }
            }
        }
    }
}

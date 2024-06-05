public class Continue {
    public static void main(String[] args) {
        for (int i = 0; i <3 ;i++){
            for (int j = 0; j < 3 ; j++){
                if(i == 0){
                    continue;
                }
                // 不可能输出0
                System.out.println(i);
            }
        }
    }   
}

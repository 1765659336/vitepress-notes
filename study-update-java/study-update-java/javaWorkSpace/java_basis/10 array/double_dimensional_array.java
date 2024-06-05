public class double_dimensional_array {
    public static void main(String[] args) {
        /* 
            1 2 3 
            4 5 6
            7 8 9
        */
        int [][] arr = {{1,2,3},{4,5,6},{7,8,9}};

        // 遍历
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.println(arr[i][j]);
            }
        }
    }
}
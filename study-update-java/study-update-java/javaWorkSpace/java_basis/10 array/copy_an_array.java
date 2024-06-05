public class copy_an_array {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++){
            arr2[i] = arr1[i];
        }
        arr2[4] = 10;
        System.out.println(arr1[4]+"--"+arr2[4]); // 5--10
    }
}

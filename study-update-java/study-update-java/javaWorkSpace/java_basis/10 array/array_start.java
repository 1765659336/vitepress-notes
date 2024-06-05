public class array_start {
    public static void main(String[] args) {
        double[] arr = { 1, 2, 3, 4, 5 };
        double total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        System.out.println(total);
    }
}

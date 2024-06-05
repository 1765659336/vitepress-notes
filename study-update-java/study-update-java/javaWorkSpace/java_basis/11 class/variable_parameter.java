public class variable_parameter {
    public static void main(String[] args) {
        Add(1,2,3,4,5);
    }

    public static void Add(int... nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}

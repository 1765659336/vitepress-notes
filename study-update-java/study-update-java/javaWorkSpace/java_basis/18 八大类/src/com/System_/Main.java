package com.System_;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        int[] arr = {1,2,3};
        int[] arr2 = new int[3];
//     参数   Object array1, int start1, Object array2, int start2, int length
        System.arraycopy(arr, 0,arr2,0,3);
        System.out.println(Arrays.toString(arr2));
        System.out.println(System.currentTimeMillis());
        System.gc();
        System.exit(0);
    }
}

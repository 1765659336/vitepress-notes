package com.Arrays_;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 5, 4};
//        排序会改变原数组
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr)); //[1, 2, 3, 4, 5]
//        二分查找指定值的下标
        System.out.println(Arrays.binarySearch(arr, 3)); // 2
//        复制数组
        int[] arr2 = Arrays.copyOf(arr, 3);// [1, 2, 3]
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = Arrays.copyOfRange(arr, 2, 4);// [3, 4]
        System.out.println(Arrays.toString(arr3));
//        数组元素的填充,用给与的值去替换数组中所有的值
        Integer[] arr4 = new Integer[]{9, 3, 2};
        Arrays.fill(arr4, 10);
        System.out.println(Arrays.toString(arr4)); // [10, 10, 10]
//        比较两个数组中的元素是否完全相同
        int[] arr5 = {1, 2};
        int[] arr6 = {2, 1};
        System.out.println(Arrays.equals(arr5, arr6));// false
//        将一组值转换为list
        List<Integer> asList = Arrays.asList(2,3,5,6);
        System.out.println(asList); // [2, 3, 5, 6]
    }
}

### 数组的基本使用
```java
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
```

### 数组初始化的方式
#### 动态初始化1
```
1、double[] arr 等价 double arr[]
2、int[] a = new int[5],开辟一块内存为5的空间
```
```java
import java.util.Scanner;

public class dynamic_initialization {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        double[] arr = new double[5];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个值");
            arr[i] = myScanner.nextDouble();
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println("你输入的第" + (i + 1) + "个值是" + arr[i]);
        }
    }
}

```
#### 动态初始化2
```
先声明，再分配空间
```
```java
import java.util.Scanner;

public class dynamic_initialization2 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        double[] arr;
        // 满足某种条件的时候再分配空间
        if(true){
            arr = new double[5];
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个值");
            arr[i] = myScanner.nextDouble();
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println("你输入的第" + (i + 1) + "个值是" + arr[i]);
        }
    }
}

```
#### 静态初始化
```
如果知道数组的元素的值，可以直接在声明的时候，直接初始化值
```
```java
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
```

### 数组使用的细节
```
1、数组是多个相同类型数据的组合，满足隐式转换的也可以
int[] arr = {1,2,3,"hello"};
double[] arr = {1.1,2.2,10};
2、数组中的元素可以是基本数据类型也可以是引用数据类型，但是不能混用
3、数组创建后，如果没有赋值，那么都是有默认值的，int,short,byte,long 0 ; float 0.0; double 0.0; char \u0000; boolean false; String null;
4、数组的下标必须在指定的范围之内，否则就是越界 （与JavaScript不同，JavaScript会自动给数组扩容，并且值是undefined）
5、数组属于引用数据类型
```

### 数组的赋值
```
和JavaScript的引用数据类型赋值一样，赋值的是引用关系。共用一块儿内存
```

### 数组拷贝
```java
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
```

### 数组翻转
```java
public class array_reverse {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5};
        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++){
            arr2[arr2.length - i - 1] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++){
            System.out.println(arr2[i]);
        }
    }
}
```

### 数组扩容
```java
import java.util.Scanner;
/* 
    思路：1、copy原数组长度加1的一个同类型数组
        2、copy的数组添加新元素
        3、将copy的数组赋值给原数组
*/
public class array_capacity {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入y/n选择是否对数组进行扩容");
            char isChoose = scanner.next().charAt(0);
            if (isChoose == 'y') {
                System.out.println("请输入你要扩容的值");
                int addValue = scanner.nextInt();
                int[] arrCopy = new int[arr.length + 1];
                for (int i = 0; i < arr.length; i++) {
                    arrCopy[i] = arr[i];
                }
                arrCopy[arrCopy.length - 1] = addValue;
                arr = arrCopy;
            } else {
                for (int i = 0; i < arr.length; i++) {
                    System.out.println(arr[i]);
                }
                break;
            }
        }
    }
}
```

### 二维数组
### 二维数组初始化的方式
#### 动态初始化1（一步到位）
```java
int [][] arr = new int[3][3];
```
#### 动态初始化2（先声明再开辟空间）
```java
int [][]arr;
arr = new int[][];
```
#### 动态初始化3（列数不确定）
```java
int [][]arr = new int[3][];
for(int i=0; i<arr.length; i++){
    arr[i] = new int[i+1];
}
```
#### 静态初始化
```java
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
```

### 杨辉三角
```java
import java.util.Scanner;

public class yang_hui_triangle {
    public static void main(String[] args) {
        System.out.println("请输入一个数字，表示你要打印一个多少行的杨辉三角");
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[i+1];
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 0 || j == arr[i].length - 1) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
            System.out.println("\t");
        }
    }
}
```
### 二维数组使用的细节
#### 

```java
// 二维数组声明的三种方式
int [][] arr = new int[][];
int[] arr[] = new int[][];
int arr[][] = new int[][];
```
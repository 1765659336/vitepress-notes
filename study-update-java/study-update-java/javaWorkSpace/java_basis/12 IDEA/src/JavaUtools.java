public class JavaUtools {
//    冒泡排序方法
    public int[] sort(int [] array){
        for(int i = 0; i < array.length; i++){
            for(int j=0; j< array.length -i -1; j++){
                if(array[i] > array[i+1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
        return array;
    }
}

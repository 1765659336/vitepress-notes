public class recursive {
    public static void main(String[] args){
        RecursiveWay rw = new RecursiveWay();
        System.out.println(rw.Sum(3));
        System.out.println(rw.Sum(-1));
    }
}

class RecursiveWay {
    // 求1+到某个数的值
    public int Sum(int i){
        if(i > 0){
            return i + Sum(i - 1);
        }
        return i;
    }
}

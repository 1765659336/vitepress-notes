public class Main {
    public static void main(String[] args) {
        int [] array = {1,3,2,4};
        JavaUtools ju = new JavaUtools();
        int [] arrayCopy = ju.sort(array);
        for (int i = 0; i< arrayCopy.length; i++){
            System.out.println(arrayCopy[i]);
        }
    }
}

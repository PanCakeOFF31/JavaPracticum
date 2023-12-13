package helpers;

public class OneDimensionalArray {
    public static void printOneDimensionalArray(int[] a){
        if (a.length == 0) {
            System.out.println("array is empty");
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println("["+ i + "] = " + a[i]);
        }
    }
    public static void printOneDimensionalArray(float[] a){
        if (a.length == 0) {
            System.out.println("array is empty");
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println("array["+ i + "] = " + a[i]);
        }
    }
    public static void printOneDimensionalArray(boolean[] a){
        if (a.length == 0) {
            System.out.println("array is empty");
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println("array["+ i + "] = " + a[i]);
        }
    }

    /*public static void printOneDimensionalArray(String a[]){
        if (a.length == 0) {
            System.out.println("array is empty");
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println("array["+ i + "] = " + a[i]);
        }
    }*/

    public static void printOneDimensionalArray(Object[] a) {
        if (a.length == 0) {
            System.out.println("array is empty");
            return;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println("array["+ i + "] = " + a[i]);
        }
    }

    public static void printOneDimensionalArray(String[] a) {
        if (a.length == 0) {
            System.out.println("array is empty");
            return;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println("array["+ i + "] = " + a[i]);
        }
    }
}

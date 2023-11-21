package gerbertShieldBook.chapter_14.auxiliaryClasses;

public class GenericMethod {
    public static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for (V v : y) {
            if (x.equals(v)) {
                return true;
            }
        }
        return false;
    }
}

package helpers;

public class Checker {

    public static void checkIndex(int index, int size) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("index is " + index);
        }
    }

    public static boolean isAllowableIndex(int index, int size) {
        return index >= 0 || index <= size - 1;
    }

    public static void checkNull(Object obj) {
        if (obj == null)
            throw new NullPointerException();
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }
    public static boolean isNotNull(Object obj) {
        return obj != null;
    }

    public static void checkClass(Object obj1, Object obj2) {
        if (obj1.getClass() != obj2.getClass())
            throw new IllegalArgumentException();
    }

    public static boolean isSameClass(Object obj1, Object obj2) {
        return obj1.getClass() == obj2.getClass();
    }

}

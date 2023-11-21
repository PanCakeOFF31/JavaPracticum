package helpers;

public class MathHelpers {
    public static double rootOf(double a, double rootDegree) {
        return Math.pow(a,1.0/rootDegree);
    }

    public static double logByBase(double number, double base) {
        return Math.log(number) / Math.log(base);
    }
    public static int setTheFlag(int flagStorage, int position) {
        return flagStorage | (0b1 << position);
    }

    public static int resertTheFlag(int flagStorage, int position) {
        return flagStorage & ~(0b1 << position);
    }

    public static boolean checkTheFlag(int flagStorage, int position) {
        return ((flagStorage & (0b1 << position)) == (0b1 << position));
    }
}

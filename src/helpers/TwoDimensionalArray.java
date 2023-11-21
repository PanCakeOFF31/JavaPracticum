package helpers;

import java.util.Random;
public class TwoDimensionalArray {
    public static void printTwoDimensionalArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print("[");
            for (int j = 0; j < a[i].length; j++) {
                if (j == a[i].length - 1) {
                    System.out.print("[" + i + "][" + j + "] = " + a[i][j]);
                    continue;
                }
                System.out.print("[" + i + "][" + j + "] = " + a[i][j] + ", ");
            }
            System.out.print("]\n");
        }
    }

    public static void fillTwoDimansionalArray(int[][] a, int from, int to) {
        Random random = new Random();
        to++;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = random.nextInt(from,to);
            }
        }
    }

}

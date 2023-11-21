package freePractise;

import static helpers.Helpers.*;

public class RadixConverter {
    static void radixConverter() {
        printSubSection("Исходные данные:");
        int positiveDecimalNumber = Integer.MAX_VALUE;
        String positiveBinaryNumber = "0111_1111_1111_1111_1111_1111_1111_1111";

        int negativeDecimalNumber = Integer.MIN_VALUE;
        String negativeBinaryNumber = "1111_1111_1111_1111_1111_1111_1111_1111";

       /* System.out.println("positiveDecimalNumber = " + positiveDecimalNumber);
        System.out.println("positiveBinaryNumber = " + positiveBinaryNumber);
        System.out.println("negativeDecimalNumber = " + negativeDecimalNumber);
        System.out.println("negativeBinaryNumber = " + negativeBinaryNumber);*/
        printSubSectionEnding();

        printSubSection("Проверки:");
//        System.out.println(positiveDecimalNumber + " = " + positiveBinaryNumber);
//        System.out.println(toDecimal(deleteUnderline(positiveBinaryNumber)) + " = " + insertUnderline(toBinary(positiveDecimalNumber)));
//        System.out.println(negativeDecimalNumber + " = " + negativeBinaryNumber);
//        System.out.println(toDecimal(deleteUnderline(negativeBinaryNumber)) + " = " + insertUnderline(toBinary(negativeDecimalNumber)));
//        System.out.println(toDecimal(deleteUnderline("1111")) + " = " + insertUnderline(toBinary(15)));
        System.out.println(toDecimal(deleteUnderline("1000_0000_0000_0000_0000_0000_0000_0001")) + " = " + insertUnderline(toBinary(-1)));


        printSubSectionEnding();
    }

    private static int toDecimal(String binaryNumber) {
        if (binaryNumber == null || binaryNumber.isEmpty())
            return 0;

        int result = 0;

        StringBuilder string = new StringBuilder(binaryNumber);
        int length = string.length();

        if (string.length() % 32 == 0) {
            for (int i = length - 1; i >= 1; --i) {
                if (string.charAt(i) == '1') {
                    result -= Math.pow(2, length - i - 1);
                }
            }
        } else {
            for (int i = length - 1; i >= 0; --i) {
                if (string.charAt(i) == '1') {
                    result += Math.pow(2, length - i - 1);
                }
            }
        }

        return result;
    }

    private static String toBinary(int decialNumber) {
        if (decialNumber == 0)
            return "0";

        boolean isNegative = decialNumber < 0;
        if (isNegative) {
            decialNumber = ~decialNumber + 1;
        }

        StringBuilder string = new StringBuilder();

        while (decialNumber != 0) {
            int mod = decialNumber % 2;
            decialNumber /= 2;
            string.append(mod);
            string.reverse();
        }


        if (isNegative) {
            while (string.length() < 32) {
                string.insert(0,"0");
            }
            string.replace(0,1,"1");
        }

        return string.toString();
    }

    static String insertUnderline(String binaryString) {
        if (binaryString == null)
            return null;
        if (binaryString.isEmpty())
            return "";

        final String ONE_ZERO = "0";
        final String TWO_ZEROS = "00";
        final String THREE_ZEROS = "000";

        StringBuilder string = new StringBuilder(binaryString);

        deleteNonSignificantZeros(string); // 00001111

        int length = string.length();

        if (length % 4 == 0) { // Не добавляем нули
            splitBinaryStringWithUnderline(string);
        } else if (length % 4 == 1) { // Добавляем 3 нуля
            string.insert(0, THREE_ZEROS);
            splitBinaryStringWithUnderline(string);
        } else if (length % 4 == 2) { // Добавляем 2 нуля
            string.insert(0, TWO_ZEROS);
            splitBinaryStringWithUnderline(string);
        } else { // Добавляем 1 ноль
            string.insert(0, ONE_ZERO);
            splitBinaryStringWithUnderline(string);
        }

        return string.toString();
    }

    private static void splitBinaryStringWithUnderline(StringBuilder string) {
        final String UNDERLINE = "_";
        int bounds = string.length() / 4;
        int lastOperation = bounds - 1;

        if (string.length() == 4)
            return;

        for (int i = 0; i < bounds; i++) {
            if (i == lastOperation)
                break;
            int adaptiveOffset = 4 + i * 5;
            string.insert(adaptiveOffset, UNDERLINE);
        }
        string.trimToSize();
    }

    static String deleteUnderline(String binaryString) {
        if (binaryString == null)
            return null;
        if (binaryString.isEmpty())
            return "";

        final String UNDERLINE = "_";

        StringBuilder string = new StringBuilder(binaryString);
        int length = string.length();

        while (string.indexOf(UNDERLINE) >= 0) {
            int index = string.indexOf(UNDERLINE);
            string.deleteCharAt(index);
        }

        deleteNonSignificantZeros(string);

        return string.toString();
    }

    private static void deleteNonSignificantZeros(StringBuilder string) {
        while (string.indexOf("1") != 0) {
            string.deleteCharAt(0);
        }
    }

}

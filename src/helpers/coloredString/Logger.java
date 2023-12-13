package helpers.coloredString;

public class Logger {

    private static final String RESET = Colors.RESET.toString();

    private static final Colors DEFAULT_COLOR = Colors.BLACK;

    public static boolean toIndicate = true;

    public static ColoredString coloredString(String text, Colors color) {
        return new ColoredString(text, color);
    }

    public static void printMessage(String message) {
        System.out.println(new ColoredString(message, DEFAULT_COLOR));
    }

    public static void printMessage(String message, Colors color) {
        System.out.println(new ColoredString(message, color));
    }

    public static void printCallingMethod() {
        printCallingMethod(1);
    }

    public static void printCallingMethod(int offset) {
        StackTraceElement ste = Thread.currentThread().getStackTrace()[2 + offset];
        String className = ste.getClassName().split("\\.")[ste.getClassName().split("\\.").length - 1];
        String classMethod = ste.getMethodName();
        String lineNumber = " line " + ste.getLineNumber();

        ColoredString string1 = new ColoredString(className + "." + classMethod + "()" + lineNumber, DEFAULT_COLOR);

        System.out.println(string1);
    }

    public static void printMessage(String message, Colors color, boolean... options) {
        ColoredString coloredString = new ColoredString(message, color, options);
        System.out.println(coloredString);
    }

    public static void printAlarmMessage(String message) {
        if (toIndicate) {
            detailed(message, Colors.RED, 2);
        }
    }

    public static void printAlarmMessage(String message, int offset) {
        if (toIndicate) {
            detailed(message, Colors.RED, 2 + offset);
        }
    }

    public static void printWarningMessage(String message) {
        if (toIndicate) {
            detailed(message, Colors.YELLOW, 2);
        }
    }

    public static void printWarningMessage(String message, int offset) {
        if (toIndicate) {
            detailed(message, Colors.YELLOW, 2 + offset);
        }
    }

    public static void printMarkMessage(String message) {
        if (toIndicate) {
            detailed(message, Colors.CYAN, 2);
        }
    }

    public static void printMarkMessage(String message, int offset) {
        if (toIndicate) {
            detailed(message, Colors.CYAN, 2 + offset);
        }
    }

    public static void printBoldMessage(String message) {
        System.out.println(new ColoredString(message, Colors.NOT_COLOR, true));
    }

    public static void printItalicMessage(String message) {
        System.out.println(new ColoredString(message, Colors.NOT_COLOR, false, true));
    }

    public static void printUnderlineMessage(String message) {
        System.out.println(new ColoredString(message, Colors.NOT_COLOR, false, false, true));
    }

    public static void printBoldMessage(String message, Colors color) {
        System.out.println(new ColoredString(message, color, true));
    }

    public static void printItalicMessage(String message, Colors color) {
        System.out.println(new ColoredString(message, color, false, true));
    }

    public static void printUnderlineMessage(String message, Colors color) {
        System.out.println(new ColoredString(message, color, false, false, true));
    }

    private static void detailed(String message, Colors color, int offset) {
        printCallingMethod(offset);

        ColoredString string2 = new ColoredString("Message: ", Colors.BLUE);
        ColoredString string3 = new ColoredString("\"", DEFAULT_COLOR);
        ColoredString string4 = new ColoredString(message, color);

        System.out.println("\t" + string2 + string3 + string4 + string3);
    }
}
package freePractise.logger_coloredString;

import static freePractise.logger_coloredString.Colors.*;
import static helpers.Helpers.*;

public class Logger {
    public static void main(String[] args) {
        printArticle("Logger");

        printSubSection("printAlarm/Warning/MarkMessage()");
        {
            printAlarmMessage("Попытка добавить null задачу");
            printAlarmMessage("Попытка добавить null задачу", true);
            printAlarmMessage("Попытка добавить null задачу", false, true);
            printWarningMessage("Такой задачи еще не существует");
            printMarkMessage("Удалили из конца");
            printMarkMessage(false, "Удалили из конца");
        }

        printSubSection("printMessage()");
        {
            printMessage("Only bold", BLACK, true);
            printMessage("Only italic", BLACK, false, true);
            printMessage("Only underlain", BLACK, false, false, true);
            printMessage("Only bold and italic", BLACK, true, true);
            printMessage("Only italic and underline", BLACK, false, true, true);
            printMessage("Only bold and underline", BLACK, true, false, true);
        }

        printSubSection("Bold/Italic/Underline");
        {
            printBoldMessage("Only bold", GREEN);
            printItalicMessage("Only italic", GREEN);
            printUnderlineMessage("Only underline", GREEN);
        }


        printSubSection("Явная демонстрация");
        {
            System.out.println("\u001B[30m" + "Xyonix" + RESET);
            System.out.println("\u001B[1;30m" + "Xyonix" + RESET);
            System.out.println("\u001B[3;30m" + "Xyonix" + RESET);
            System.out.println("\u001B[4;30m" + "Xyonix" + RESET);
            System.out.println("\u001B[3;4;1;30m" + "Xyonix" + RESET);
        }

        printSubSection();
        {
            ColoredString string1 = new ColoredString("Zyzoza", RED);
            System.out.println(string1 + "Brightness" + string1);

            string1.changeColor(GREEN);
            System.out.println(string1 + "Brightness" + string1);

            string1.changeText("NewZyzoza ");
            System.out.println(string1 + "Brightness" + string1);

            System.out.println(string1.getUncoloredText() + "Brightness" + string1.getUncoloredText());
        }

        printSubSection("Перечисление Colors:");
        {
            for (Colors value : values()) {
                System.out.println(value.getColoredString());
            }
        }

        printSubSection("Просто сравнение длины строк");
        {
            String origin = "The wild wind";
            System.out.println(origin);
            System.out.println(origin.length());

            ColoredString string = new ColoredString("The wild wind", PURPLE);
            System.out.println(string);
            System.out.println(string.toString().length());

            string = string.changeOptions(true, false, true);
            System.out.println(string);
            System.out.println(string.toString().length());

        }

        printSubSection();
        {
            ColoredString string = new ColoredString("Если бы да кабы", BLACK, true, false, true);
            System.out.println(string);

            string.changeColor(GREEN);
            System.out.println(string);

            ColoredString copy = new ColoredString(string);
            System.out.println(copy);

            copy = string.changeColor(RED);
            copy.changeOptions(false, true, true);
            System.out.println(copy);
        }
        printArticleEnding();
    }

    private static final String RESET = Colors.RESET.toString();

    private static final Colors DEFAULT_COLOR = BLACK;
    private static final int DEFAULT_OFFSET = 2;

    public static boolean toIndicate = true;


    public static ColoredString coloredString(String text, Colors color) {
        return new ColoredString(text, color);
    }

    public static ColoredString coloredString(String text, boolean... options) {
        return new ColoredString(text, options);
    }

    public static ColoredString coloredString(String text, Colors color, boolean... options) {
        return new ColoredString(text, color, options);
    }

    public static void printMessage(ColoredString coloredString) {
        System.out.println(coloredString);
    }

    public static void printMessage(String message) {
        System.out.println(new ColoredString(message, DEFAULT_COLOR));
    }

    public static void printMessage(String message, boolean... options) {
        System.out.println(new ColoredString(message, DEFAULT_COLOR, options));
    }

    public static void printMessage(String message, Colors color) {
        System.out.println(new ColoredString(message, color));
    }

    public static void printMessage(String message, Colors color, boolean... options) {
        ColoredString coloredString = new ColoredString(message, color, options);
        System.out.println(coloredString);
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

    public static void printAlarmMessage(String message) {
        if (toIndicate) {
            detailed(true, message, RED, DEFAULT_OFFSET);
        }
    }

    public static void printAlarmMessage(String message, boolean... options) {
        if (toIndicate) {
            detailed(true, message, RED, DEFAULT_OFFSET, options);
        }
    }

    public static void printAlarmMessage(boolean showCollingMethod, String message, boolean... options) {
        if (toIndicate) {
            detailed(showCollingMethod, message, RED, DEFAULT_OFFSET, options);
        }
    }

    public static void printAlarmMessage(String message, int offset) {
        if (toIndicate) {
            detailed(true, message, RED, DEFAULT_OFFSET + offset);
        }
    }

    public static void printAlarmMessage(String message, int offset, boolean... options) {
        if (toIndicate) {
            detailed(true, message, RED, DEFAULT_OFFSET + offset, options);
        }
    }

    public static void printWarningMessage(String message) {
        if (toIndicate) {
            detailed(true, message, YELLOW, DEFAULT_OFFSET);
        }
    }

    public static void printWarningMessage(String message, boolean... options) {
        if (toIndicate) {
            detailed(true, message, YELLOW, DEFAULT_OFFSET, options);
        }
    }

    public static void printWarningMessage(boolean showCollingMethod, String message, boolean... options) {
        if (toIndicate) {
            detailed(showCollingMethod, message, YELLOW, DEFAULT_OFFSET, options);
        }
    }

    public static void printWarningMessage(String message, int offset) {
        if (toIndicate) {
            detailed(true, message, YELLOW, DEFAULT_OFFSET + offset);
        }
    }

    public static void printWarningMessage(String message, int offset, boolean... options) {
        if (toIndicate) {
            detailed(true, message, YELLOW, DEFAULT_OFFSET + offset, options);
        }
    }

    public static void printMarkMessage(String message) {
        if (toIndicate) {
            detailed(true, message, CYAN, DEFAULT_OFFSET);
        }
    }
    public static void printMarkMessage(String message, Colors color) {
        if (toIndicate) {
            detailed(true, message, color, DEFAULT_OFFSET);
        }
    }

    public static void printMarkMessage(boolean showCollingMessage, String message) {
        if (toIndicate) {
            detailed(showCollingMessage, message, CYAN, DEFAULT_OFFSET);
        }
    }

    public static void printMarkMessage(String message, boolean... options) {
        if (toIndicate) {
            detailed(true, message, CYAN, DEFAULT_OFFSET, options);
        }
    }

    public static void printMarkMessage(boolean showCollingMethod, String message, boolean... options) {
        if (toIndicate) {
            detailed(showCollingMethod, message, CYAN, DEFAULT_OFFSET, options);
        }
    }

    public static void printMarkMessage(boolean showCollingMethod, String message, Colors color, boolean... options) {
        if (toIndicate) {
            detailed(showCollingMethod, message, color, DEFAULT_OFFSET, options);
        }
    }

    public static void printMarkMessage(String message, int offset) {
        if (toIndicate) {
            detailed(true, message, CYAN, DEFAULT_OFFSET + offset);
        }
    }

    public static void printMarkMessage(boolean showCollingMethod, String message, int offset, boolean... options) {
        if (toIndicate) {
            detailed(showCollingMethod, message, CYAN, DEFAULT_OFFSET + offset, options);
        }
    }

    public static void printMarkMessage(boolean showCollingMethod, String message, Colors color, int offset, boolean... options) {
        if (toIndicate) {
            detailed(showCollingMethod, message, color, DEFAULT_OFFSET + offset, options);
        }
    }

    public static void printBoldMessage(String message) {
        System.out.println(new ColoredString(message, NOT_COLOR, true));
    }

    public static void printBoldMessage(String message, Colors color) {
        System.out.println(new ColoredString(message, color, true));
    }

    public static void printItalicMessage(String message) {
        System.out.println(new ColoredString(message, NOT_COLOR, false, true));
    }

    public static void printItalicMessage(String message, Colors color) {
        System.out.println(new ColoredString(message, color, false, true));
    }

    public static void printUnderlineMessage(String message) {
        System.out.println(new ColoredString(message, NOT_COLOR, false, false, true));
    }

    public static void printUnderlineMessage(String message, Colors color) {
        System.out.println(new ColoredString(message, color, false, false, true));
    }

    private static void detailed(boolean showCallingMethod, String message, Colors color, int offset, boolean... options) {
        if (showCallingMethod)
            printCallingMethod(offset);

        ColoredString string2 = new ColoredString("Message: ", BLUE);
        ColoredString string3 = new ColoredString("\"", DEFAULT_COLOR);
        ColoredString string4 = new ColoredString(message, color, options);

        System.out.println("\t" + string2 + string3 + string4 + string3);
    }
}
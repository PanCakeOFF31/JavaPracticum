package helpers.coloredString;

import static helpers.Helpers.*;

public class Logger {
    public static void logger() {
        printArticle("Logger");

        printSubSection("printMessage()");
        {
            printMessage("asdasd");
            printMessage("asdasd", Colors.CYAN);

            printMessage("Only bold", Colors.BLACK, true);
            printMessage("Only italic", Colors.BLACK, false, true);
            printMessage("Only underlain", Colors.BLACK, false, false, true);
            printMessage("Only bold and italic", Colors.BLACK, true, true);
            printMessage("Only italic and underline", Colors.BLACK, false, true, true);
            printMessage("Only bold and underline", Colors.BLACK, true, false, true);
        }

        printSubSection("Bold/Italic/Underline");
        {
            printBoldMessage("Only bold", Colors.GREEN);
            printItalicMessage("Only italic", Colors.GREEN);
            printUnderlineMessage("Only underline", Colors.GREEN);
        }

        printSubSection("printAlarm/Warning/MarkMessage()");
        {
            printAlarmMessage("Попытка добавить null задачу");
            printWarningMessage("Попытка добавить null задачу");
            printMarkMessage("Удалили из конца");
        }

        printSubSection();
        {
            System.out.println("\u001B[30m" + "Maxim" + RESET);
            System.out.println("\u001B[1;30m" + "Maxim" + RESET);
            System.out.println("\u001B[3;30m" + "Maxim" + RESET);
            System.out.println("\u001B[4;30m" + "Maxim" + RESET);
            System.out.println("\u001B[3;4;1;30m" + "Maxim" + RESET);
        }

        printSubSection();
        {
            String string = "House";

            ColoredString coloredString = Logger.of(string, Colors.GREEN);
            System.out.println(coloredString);

            coloredString = new ColoredString(string, Colors.GREEN);
            System.out.println(coloredString);
        }

        printSubSection();
        {
            ColoredString string1 = new ColoredString("Maxim", Colors.RED);
            System.out.println(string1 + "Blinov" + string1);

            string1.changeColor(Colors.GREEN);
            System.out.println(string1 + "Blinov" + string1);

            string1.changeText("NewMaxim ");
            System.out.println(string1 + "Blinov" + string1);

            System.out.println(string1.getUncoloredText() + "Blinov" + string1.getUncoloredText());
        }

        printSubSection("");
        {
            for (Colors value : Colors.values()) {
                System.out.println(value.getColorName());
            }
        }

        printSubSection("");
        {
            ColoredString string = new ColoredString("The wild wind", Colors.PURPLE);
            System.out.println(string);
            System.out.println(string.toString().length());

            string = new ColoredString(string, Colors.BLUE);
            System.out.println(string);
            System.out.println(string.toString().length());
            System.out.println(string.getUncoloredText());
        }

        printSubSection();
        {
            ColoredString string = new ColoredString("Если бы да кабы", Colors.BLACK, true, false, true);
            System.out.println("string = " + string);

            string.changeColor(Colors.GREEN);
            System.out.println("string = " + string);

            ColoredString copy = new ColoredString(string);
            System.out.println("copy = " + copy);

            copy = new ColoredString(string, Colors.RED);
            copy.changeOptions(new boolean[]{false, true, true});
            System.out.println("copy = " + copy);
        }
        printArticleEnding();
    }

    private static final String RESET = Colors.RESET.toString();

    public static ColoredString of(String text, Colors color) {
        return new ColoredString(text, color);
    }

    public static void printMessage(String message) {
        System.out.println(new ColoredString(message, Colors.BLACK));
    }

    public static void printMessage(String message, Colors color) {
        System.out.println(new ColoredString(message, color));
    }

    public static void printCollingMethod(){
        StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
        String className = ste.getClassName().split("\\.")[ste.getClassName().split("\\.").length - 1];
        String classMethod = ste.getMethodName();

        ColoredString string1 = new ColoredString(className + "." + classMethod + "()", Colors.BLACK);

        System.out.println(string1);
    }

    public static void printMessage(String message, Colors color, boolean... options) {
        ColoredString coloredString = new ColoredString(message, color, options);
        System.out.println(coloredString);
    }

    public static void printAlarmMessage(String message) {
        detailed(message, Colors.RED);
    }

    public static void printWarningMessage(String message) {
        detailed(message, Colors.YELLOW);
    }

    public static void printMarkMessage(String message) {
        detailed(message, Colors.CYAN);
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

    private static void detailed(String message, Colors color) {
        StackTraceElement ste = Thread.currentThread().getStackTrace()[3];
        String className = ste.getClassName().split("\\.")[ste.getClassName().split("\\.").length - 1];
        String classMethod = ste.getMethodName();

        ColoredString string1 = new ColoredString(className + "." + classMethod + "()", Colors.BLACK);
        ColoredString string2 = new ColoredString("Message: ", Colors.BLUE);
        ColoredString string3 = new ColoredString("\"", Colors.BLACK);
        ColoredString string4 = new ColoredString(message, color);

        System.out.println(string1);
        System.out.println("\t" + string2 + string3 + string4 + string3);
    }
}

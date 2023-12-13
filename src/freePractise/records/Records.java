package freePractise.records;

import freePractise.logger_coloredString.Logger;

import java.util.Arrays;

import static helpers.Helpers.*;

public class Records {
    public static void records() {
        printArticle("Records");

//        program_1();
//        program_2();
//        program_3();
//        program_4();
//        program_5();
        program_6();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1.  Простой пример");

        Employee employee = new Employee("Maxim", 24);
        System.out.println(employee);
        System.out.println(employee.name());
        System.out.println(employee.age());
        System.out.println(employee.hashCode());

        Employee employee1 = new Employee(employee);
        System.out.println(employee1);


        Employee employee2 = new Employee(null, 20);
        System.out.println(employee2);

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. Возврат record из switch");

        int initial = 105;

//         switch expression + returning a record
        Coordinates coordinates = switch (initial) {
            case 100, 101, 102 -> new Coordinates(100, 200, 300);
            default -> new Coordinates(0, 0, 0);
        };

        System.out.println(coordinates);
        System.out.println(coordinates.x());
        System.out.println(coordinates.y());
        System.out.println(coordinates.z());
        System.out.println(coordinates.hashCode());

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. Обобщенный Record<T>");

        TwoRecordTwo<Integer, String> twoRecord = new TwoRecordTwo<>(10, "asdasd");

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. Обобщенный record + var arguments");

        ManyRecords<Integer> records = new ManyRecords<>(10, 20, 30, 40, 50, 60);
        System.out.println(records);

        printSectionEnding();
    }

    private static void program_5() {
        printSection("Program_5. Record с неканоническим конструктором");

        Good good1 = new Good("Car", 100.5);
        Good good2 = new Good(null, -100.0);
        Good good3 = new Good("Ball");

        System.out.println("good1 = " + good1);
        System.out.println("good2 = " + good2);
        System.out.println("good3 = " + good3);

        printSectionEnding();
    }

    private static void program_6() {
        printSection("Program_6. Еще один пример не канонического конструктора");

        User user1 = new User("Maxim, Blinov");
        System.out.println("user1 = " + user1);

        User user2 = new User("Maxim,, Blinov");
        System.out.println("user2 = " + user2);

        User user3 = new User("a ,");
        System.out.println("user3 = " + user3);

        printSectionEnding();
    }
}

record Employee(String name, int age) {
    public static int defaultAge = 18;

    public Employee {
        if (name == null) {
            name = "no-name";
        }
    }

    public Employee(Employee employee) {
        this(employee.name, employee.age);
    }
}

record Coordinates(int x, int y, int z) {
}

record TwoRecordTwo<T, K>(T a, K b) {
    public TwoRecordTwo {
        if (a instanceof String) {
            System.out.println("Первый аргумент - строка");
        }
        if (b instanceof String) {
            System.out.println("Второй аргумент - строка");
        }
    }
}

record ManyRecords<T>(T... a) {


    @Override
    public String toString() {
        return Arrays.toString(this.a);
    }
}

record Good(String title, double price) {
    private final static double DEFAULT_PRICE = 0.0;

    public Good {
        if (title == null)
            title = "uknown";

        if (price < 0)
            price = 0;
    }

    public Good(String title) {
        this(title, DEFAULT_PRICE);
    }

}

record User(String fullName) {
    public User {
        fullName = fullName.trim();

        int firstIndex = fullName.indexOf(',');
        int lastIndex = fullName.lastIndexOf(',');

        if (firstIndex != lastIndex) {
            Logger.printAlarmMessage("Неверный формат строки");
            fullName = "unknown";
        }

        if (firstIndex < 1 || fullName.length() == firstIndex + 1) {
            Logger.printAlarmMessage("Неверная длина строки");
            fullName = "unknown";
        }
    }

}























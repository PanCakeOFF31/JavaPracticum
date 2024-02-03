package freePractise.deleteMeLater;

import java.util.function.UnaryOperator;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class DeleteMeLater {
    public static void main(String[] args) {
//        JsonElement jsonElement = JsonParser.parseString("\"any text hello\"");
//        System.out.println("jsonElement = " + jsonElement);
//        System.out.println(new Gson().toJson("any text"));

//        List<Integer> ints = new ArrayList<>(List.of(10, 20, 30));
//        System.out.println(ints);
//
//        Iterator<Integer> iterator = ints.iterator();
//
//        while (iterator.hasNext()) {
//            Integer number = iterator.next();
//            if (number == 20)
//                ints.remove(number);
//        }
//
//        String title = " asdasd";
//
//        for (int i = 0, y = 10; i < 10; i++) {
//            System.out.println(i + " " + y);
//        }
//
//        System.out.println(ints);
//
//        System.out.println("🤡");
//        new Temp("asd");
//
//        try {
//            return;
//        } catch (Exception e) {
//
//        } finally {
//            System.out.println("🤡");
//            return;
//        }

        A obj = new C();
        obj.info();
    }

    private static abstract class A {
        public void info() {
            System.out.println("Инфа из абстрактного классе A");
        }
    }

    private static abstract class B extends A {
        @Override
        public abstract void info();
    }

    private static class C extends B {
        @Override
        public void info() {
            System.out.println("Реализация в классе C");
        }
    }

    private static class Temp {
        private String name;

        {
            name = "asd";
            System.out.println("Раньше конструктора");
        }

        public Temp(String name) {
            System.out.println("Конструктор после блока иниициализации");
            this.name = name;
        }
    }

    private static void foo(UnaryOperator<String> operator, String text) {
        System.out.println(operator.apply(text));
    }

    private static class MyClass {
        private final String INNER;

        public MyClass(String INNER) {
            this.INNER = INNER;
        }

        static String foo1(String text) {
            return text.toUpperCase();
        }

        String foo2(String text) {
            return text.toUpperCase() + this.INNER;
        }
    }

    public static void deleteMeLater() {
        printSection("DeleteMeLater:");

        MyClass instance1 = new MyClass("+++++++");
        MyClass instance2 = new MyClass("-------");

        String originalText = "original text";

        foo(str -> str.toUpperCase(), originalText);

        foo(MyClass::foo1, originalText);

        foo(instance1::foo2, originalText);
        foo(instance2::foo2, originalText);

        foo(String::trim, originalText);

//
//        {
//            class A implements Comparable<A> {
//                int a;
//                String title;
//
//                public A(int a, String title) {
//                    this.a = a;
//                    this.title = title;
//                }
//
//                @Override
//                public int compareTo(A o) {
//                    return this.a - o.a;
//                }
//
//                @Override
//                public int hashCode() {
//                    return Objects.hash(a);
//                }
//
//                @Override
//                public boolean equals(Object object) {
//                    if (this == object) return true;
//
//                    if (object == null || getClass() != object.getClass()) return false;
//
//                    A a = (A) object;
//                    return this.a == a.a;
//                }
//
//                @Override
//                public String toString() {
//                    return "A{a:" + this.a + ", title:\"" + this.title + "}";
//                }
//            }
//
////        for (int i = 0; i < 10; i++) {
////            if (i == 0)
////                try {
////                    throw new ArithmeticException();
////                } catch (ArithmeticException e) {
////
////                }
////            if (i == 5)
////                throw new ArithmeticException();
////        }
//
//            Logger.printMessage("TreeSet");
//            {
////            TreeSet требует переопределения метода compareTo() для корректной работы
//                TreeSet<A> tree = new TreeSet<>(Comparator.naturalOrder());
//                tree.add(new A(20, "2"));
//                tree.add(new A(10, "1"));
//                tree.remove(new A(30, "4"));
//                tree.add(new A(40, "4"));
//
//                System.out.println(tree);
//            }
//
//            Logger.printMessage("HashSet");
//            {
////            HashSet требует переопределения метода hashCode() и equals() для корректной работы
//                HashSet<A> tree = new HashSet<>();
//                tree.add(new A(20, "2"));
//                tree.add(new A(30, "3"));
//                tree.add(new A(10, "1"));
//                tree.remove(new A(30, "4"));
//
//                System.out.println(tree);
////            tree.forEach(n -> System.out.println(n.hashCode()));
//            }
//
//            {
//                int a = 10;
//                int b = a + 20;
//
//                new A(10, "Asd").a = 20;
//            }
//        }
////        UnaryOperator<String> operator = (String::toUpperCase);
////        UnaryOperator<String> sameOperator = ((String text) -> text.toUpperCase());
////
////        String text = "some text";
////        UnaryOperator<String> basedOnText = (text::toUpperCase);
//
////        String str = String.valueOf(10);
//
        printSectionEnding();
    }

}

interface Cloneable<T> {
    T getMyCopy();
}

class A implements Cloneable<A> {
    int a;

    public A(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return String.valueOf(a);
    }

    @Override
    public A getMyCopy() {
        System.out.println("Вызван метод у " + this);
        return new A(a);
    }
}

//class B extends A {
//
//    @Override
//    public String toString() {
//        return "B";
//    }
//
//    @Override
//    public B getMyCopy() {
//        return new B();
//    }
//}
//
//class C extends B {
//    @Override
//    public String toString() {
//        return "C";
//    }
//
//    @Override
//    public B getMyCopy() {
//        return new C();
//    }
//}
package freePractise.explanation;

import helpers.coloredString.Colors;
import helpers.coloredString.Logger;

import java.util.Comparator;
import java.util.TreeMap;

import static helpers.Helpers.*;

public class Explanation {
    public static void main(String[] args) {
        program_1();
//        program_2();
//        program_3();
//        program_4();
//        program_5();
//        program_6();
//        program_7();
//        program_8();
//        program_9();
    }

    private static void program_1() {
        printArticle("Program_1. Explanation #1");
        String text = "any text";

        printSection();
        Logger.printMessage("Все возможные ситуации для Weapon", Colors.BLUE);
        {
            TreeMap<Weapon, String> nonSortedWeapons = new TreeMap<>();
            TreeMap<Weapon, String> sortedNaturallyWeapons = new TreeMap<>(new NaturalWeaponOrder());
            TreeMap<Weapon, String> sortedReverslyWeapons = new TreeMap<>(new ReverseWeaponOrder());

            printSubSection("№1");
//            Пытаемся добавить класс в таблицу, созданный через конструктор new TreeMap<>().
//            В этом случае сравнение будет происходить по методу интерфейса Comparable<>() - compareTo()
            {
//                Здесь возникнет исключение, в методе (посмотри по StackTrace какой), объект приводится к типу
//                Comparable<Weapon>(), но так как он не реализовал Comparable<Weapon>, то возникает исключение
//                ClassCastException. Все логично.
//                nonSortedWeapons.put(new Weapon(10), text);
            }

            printSubSection("№2");
            {
//                Сравнение происхоидт за счет метода compare() в Comparator
                sortedNaturallyWeapons.put(new Weapon(20), text);
                sortedNaturallyWeapons.put(new Weapon(30), text);
                sortedNaturallyWeapons.put(new Weapon(10), text);
                System.out.println("sortedNaturallyWeapons = " + sortedNaturallyWeapons);
            }

            printSubSection("№3");
            {
//                Сравнение происхоидт за счет метода compare() в Comparator
                sortedReverslyWeapons.put(new Weapon(20), text);
                sortedReverslyWeapons.put(new Weapon(30), text);
                sortedReverslyWeapons.put(new Weapon(10), text);
                System.out.println("sortedReverslyWeapons = " + sortedReverslyWeapons);
            }
        }

        printSection();
        Logger.printMessage("Все возможные ситуации для Shield", Colors.BLUE);
        {
            TreeMap<Shield, String> nonSortedShields = new TreeMap<>();
            TreeMap<Shield, String> sortedNaturallyShields = new TreeMap<>(new NaturalShieldOrder());
            TreeMap<Shield, String> sortedReverslyShields = new TreeMap<>(new ReverseShieldOrder());

            printSubSection("#1");
            {
//                Заметь: конструктор new TreeMap<>(), а сортируется нормально.
//                Shield реализует Comparable<>, поэтому приведение к Comparable<Shield> не вызывает исключения
//                Сравнение происхоидт за счет метода compareTo() в Comparable
                nonSortedShields.put(new Shield(120), text);
                nonSortedShields.put(new Shield(130), text);
                nonSortedShields.put(new Shield(110), text);
                System.out.println("nonSortedShields = " + nonSortedShields);
            }

            printSubSection("#2");
            {
//                Здесь конструктор new TreeMap<>(Comparator). Хоть объект реализовал Comparable<Shield>()
//                вызываться будет метод компаратора - compare()
//                Сравнение происхоидт за счет метода compare() в Comparator
                sortedNaturallyShields.put(new Shield(120), text);
                sortedNaturallyShields.put(new Shield(130), text);
                sortedNaturallyShields.put(new Shield(110), text);
                System.out.println("sortedNaturallyShields = " + sortedNaturallyShields);
            }

            printSubSection("#3");
            {
//                Сравнение происхоидт за счет метода compare() в Comparator
                sortedReverslyShields.put(new Shield(120), text);
                sortedReverslyShields.put(new Shield(130), text);
                sortedReverslyShields.put(new Shield(110), text);
                System.out.println("sortedReverslyShields = " + sortedReverslyShields);
            }
        }

        printSection();
        Logger.printMessage("А теперь неудобная ситуация", Colors.BLUE);
        {
//            Мой вопрос был в этом: почему обобщенный параметр K не ограничен сверху интерфейсом Comparable
//            Ответ: пример ниже.
//            Объяснение: Потому, что пришлось бы реализовывать для каждого класса, который засовывает под
//            параметр K, метод интерфейса Comparable, даже в ситуации, когда я передаю Comparator
            class OtherTreeMap<K extends Comparable<K>, V> extends TreeMap<K, V> {
                public OtherTreeMap() {
                    super();
                }

                public OtherTreeMap(Comparator<? super K> comparator) {
                    super(comparator);
                }
            }

//            OtherTreeMap<Weapon, String> map1 = new OtherTreeMap<Weapon, String>(new NaturalWeaponOrder());
            OtherTreeMap<Shield, String> map2 = new OtherTreeMap<Shield, String>(new NaturalShieldOrder());
        }

        printArticleEnding();
    }
}

class Weapon {
    protected int power;

    public Weapon(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return String.valueOf(power);
    }
}

class Shield implements Comparable<Shield> {
    protected int protection;

    public Shield(int protection) {
        this.protection = protection;
    }

    @Override
    public int compareTo(Shield o) {
        return this.protection - o.protection;
    }

    @Override
    public String toString() {
        return String.valueOf(protection);
    }
}

class NaturalWeaponOrder implements Comparator<Weapon> {
    @Override
    public int compare(Weapon o1, Weapon o2) {
        return o1.power - o2.power;
    }
}

class ReverseWeaponOrder implements Comparator<Weapon> {
    @Override
    public int compare(Weapon o1, Weapon o2) {
        return o2.power - o1.power;
    }
}

class NaturalShieldOrder implements Comparator<Shield> {
    @Override
    public int compare(Shield o1, Shield o2) {
        return o1.protection - o2.protection;
    }
}

class ReverseShieldOrder implements Comparator<Shield> {
    @Override
    public int compare(Shield o1, Shield o2) {
        return o2.protection - o1.protection;
    }
}


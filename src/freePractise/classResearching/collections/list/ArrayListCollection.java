package freePractise.classResearching.collections.list;

import java.util.*;

import static helpers.Helpers.*;

public class ArrayListCollection {

    private static List<Integer> staticList = new ArrayList<>();

    static void arrayListCollectoin() {
        printArticle("ArrayList implements List");

//        part_1();
//        part_2();
//        part_3();
//        part_4();
//        part_5();

//        part_6();


//        printArticleEnding();
    }

    private static void part_1() {
        printSection("");

        List<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(0, 100);
        list.addAll(list);
        list.addAll(1, list);

        System.out.println(list);

        System.out.println("Arrays.toString(list.toArray()) = " + Arrays.toString(list.toArray()));

        System.out.println("list.size() = " + list.size());
        list.clear();

        printSectionEnding();
    }

    private static void part_2() {
        printSection("part_2. Вспомогательный класс Collections");

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            list.add(i * 10);
        }

        System.out.println("list = " + list);
        Collections.reverse(list);
        System.out.println("list = " + list);

        Collections.shuffle(list);
        System.out.println("list = " + list);

        Collections.sort(list);
        System.out.println("list = " + list);

        int frequency = Collections.frequency(list, 10);
        System.out.println("frequency = " + frequency);

        Collections.fill(list, 13);
        System.out.println("frequency = " + frequency);

        var tempList = Collections.nCopies(20, Integer.valueOf(10));
        System.out.println("tempList = " + tempList);


        printSectionEnding();
    }

    private static void part_3() {
        printSection("part_3. Проверка методов");

        List<Integer> list = new ArrayList<>();

        fillList(list);
        System.out.println(list);

        list.clear();
        System.out.println(list);

        fillList(list);
        fillList(list);

        printSubSection("Объявляем список, с которым будем работать");
        System.out.println("Новый список:\n" + list.toString());
        System.out.println("list.size() = " + list.size());

        printSubSection("Определение индекса первого вхождения");
        int index = list.indexOf(30);
        System.out.println("int index = list.indexOf(30)");
        System.out.println("index = " + index);

        printSubSection("Определение на то, содержит ли список объект");
        boolean containts = list.contains(40);
        System.out.println("boolean contains = list.contains(40)");
        System.out.println("containts = " + containts);

        printSubSection("Определение первого вхождения с конца списка");
        int lastIndex = list.lastIndexOf(40);
        System.out.println("int lastIndex = list.lastIndexOf(40)");
        System.out.println("lastIndex = " + lastIndex);

        printSubSection("Использование статических методов интерфейса");
        List tempList1 = List.copyOf(list.subList(4, 9));
        List tempList2 = List.of(11, 22, 33);
        List tempList3 = List.of(50, 60, 80, 70);

        System.out.println("tempList1 = " + tempList1);
        System.out.println("tempList2 = " + tempList2);
        System.out.println("tempList3 = " + tempList3);

        System.out.println("list.containsAll(tempList1) = " + list.containsAll(tempList1));
        System.out.println("list.containsAll(tempList2) = " + list.containsAll(tempList2));
        System.out.println("list.containsAll(tempList3) = " + list.containsAll(tempList3));

        printSubSection("Удаление элементов из списка");
        list.remove(0);
        System.out.println("list.remove(1)");

        list.remove((Integer) 20);
        System.out.println("list.remove((Integer)20)");

//        removeAll() - удаляет все вхождения для каждого из элементов
        list.removeAll(List.of(60, 70, 90));
        System.out.println("list.removeAll(List.of(60,60,70,90))");

        while (list.remove((Integer) 100)) ;

        System.out.println("list = " + list);

        printSubSection("Удаление одного элемента через removeAll()");
        list.clear();
        fillList(list);
        fillList(list);
        fillList(list);
        System.out.println("list = " + list);

        list.removeAll(List.of(10));
        System.out.println("list = " + list);

        printSubSection("Сортировка списка");
        System.out.println("list = " + list);

        list.sort(Comparator.reverseOrder());
        System.out.println("list = " + list);

        list.sort(Comparator.naturalOrder());
        System.out.println("list = " + list);

        printSubSection("Метод превращения списка в массив");
        list = list.subList(0, 5);
        System.out.println("list = " + list);
        System.out.println("list.size() = " + list.size());

        Integer[] array = list.toArray(new Integer[list.size()]);
        System.out.println("Arrays.toString(array) = " + Arrays.toString(array));

        Object[] array2 = list.toArray();
        System.out.println("(Integer) array2[0] = " + (Integer) array2[0]);

        printSubSection("Метод сохранения");
        list.clear();
        fillList(list);
        fillList(list);
        System.out.println("list = " + list);

        list.retainAll(List.of(10, 20, 30));
        System.out.println("list = " + list);

        printSectionEnding();
    }

    private static void part_4() {
        printSection("part_4. removeIf(), forEach()");

        List<Integer> list = new ArrayList<>();
        fillList(list);
        fillList(list);
        System.out.println("list.hashCode() = " + list.hashCode());

        list.forEach(number -> {
            number += 10;
            System.out.println(number);
        });

        System.out.println("list = " + list);

        list.removeIf(element -> element.equals(50));

        System.out.println("list = " + list);

        printSectionEnding();
    }

    private static void part_5() {
        printSection("part_5. ArrayList methods");

        List<Integer> list = new ArrayList<>();
        fillList(list);
        fillList(list);

        // Обеспечить длину внутреннего массива
        ((ArrayList) list).ensureCapacity(30);
        System.out.println("list.size() = " + list.size());

        // Подогнать длину массива к актуальному размеру
        ((ArrayList<Integer>) list).trimToSize();
        System.out.println("list.size() = " + list.size());

        printSectionEnding();
    }

    private static void part_6() {
        printSection("part_6. interface List overrides methods");

        staticList.clear();
        ((ArrayList) staticList).ensureCapacity(50);
        fillList(staticList,2);

        System.out.println("staticList = " + staticList);

        System.out.println("staticList.getFirst() = " + staticList.getFirst());
        System.out.println("staticList.getLast() = " + staticList.getLast());

        int trancateRate = (int) (staticList.size() * 0.5);
        System.out.println("staticList.size() - trancateRate = " + (staticList.size() - trancateRate));
        for (int i = 0; i < staticList.size() - trancateRate; i++) {
            staticList.removeFirst();
            staticList.removeLast();
        }
        System.out.println("staticList = " + staticList);

        staticList.addFirst(999);
        staticList.addLast(888);
        System.out.println("staticList = " + staticList);


        printSectionEnding();
    }

    /*
        private static void part_() {
            printSection("part_");

            printSectionEnding();
        }
    */

    private static void fillList(List<Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i * 10);
        }
    }

    private static void fillList(List<Integer> list, int times) {
        for (int i = 0; i < times; ++i) {
            for (int j = 1; j <= 10; j++) {
                list.add(j * 10);
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}



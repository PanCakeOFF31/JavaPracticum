package freePractise.selfEnumeration;

import java.util.ArrayList;
import java.util.Collections;

import static helpers.Helpers.*;

public class SelfEnumeration {
    static void selfEnumeration() {
        printArticle("Собственная реализация перечисления, как было раньше");

        DayOfWeek dayOfWeek = DayOfWeek.MONDAY;
        System.out.println("dayOfWeek.toString() = " + dayOfWeek.toString());

        System.out.println("DayOfWeek.MONDAY = " + DayOfWeek.MONDAY);

        for (DayOfWeek value : DayOfWeek.values()) {
            System.out.println("value = " + value);
            System.out.println("value.getOrdinal() = " + value.getOrdinal());
        }

        System.out.println("DayOfWeek.valueOf(\"MONDAY\") = " + DayOfWeek.valueOf("MONDAY"));
//        DayOfWeek.valueOf("ASDASD");
        System.out.println("DayOfWeek.WEDNESDAY == DayOfWeek.WEDNESDAY - " +
                (DayOfWeek.WEDNESDAY == DayOfWeek.WEDNESDAY));



        printArticleEnding();
    }
}

class DayOfWeek {
    public static final DayOfWeek MONDAY = new DayOfWeek("MONDAY");
    public static final DayOfWeek TUESDAY = new DayOfWeek("TUESDAY");
    public static final DayOfWeek WEDNESDAY = new DayOfWeek("WEDNESDAY");
    private static final DayOfWeek[] members = {MONDAY, TUESDAY, WEDNESDAY};
    private static int commonOrdinal = 0;
    private final int ordinal;
    private final String title;

//      Никто не имеет доступ к этому конструктору кроме самого класса
    private DayOfWeek(String title) {
        ordinal = commonOrdinal++;
        this.title = title;
    }

    public static ArrayList<DayOfWeek> asList() {
        ArrayList<DayOfWeek> list = new ArrayList<>();
        Collections.addAll(list,members);
        return list;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public String getTitle() {
        return title;
    }

    public static DayOfWeek[] values() {
        return members;
    }

    public static DayOfWeek valueOf(String title) {
        for (DayOfWeek member : members) {
            if (member.getTitle().equals(title)) {
                return member;
            }
        }
        throw new IllegalArgumentException("Элемента с таким именем нет - " + title);
    }

    @Override
    public String toString() {
        return title;
    }
}
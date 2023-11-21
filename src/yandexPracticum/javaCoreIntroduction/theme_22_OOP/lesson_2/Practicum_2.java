package yandexPracticum.javaCoreIntroduction.theme_22_OOP.lesson_2;

import java.util.ArrayList;
import java.util.List;

import static helpers.Helpers.*;

public class Practicum_2 {
    public static void practicum_2() {
        printSection("Practicum_2. Interface");

        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. ");

        CalendarApp noteBook = new CalendarApp();
        noteBook.addNote("Зайти в магазин после работы.");
        noteBook.addNote("Позвонить маме.");

        noteBook.deleteNote(0);

        printSubSectionEnding();
    }

     /*private static void program_*() {
        printSubSection("");
        printSubSectionEnding();
    }*/
}

interface NoteBook {
    void addNote(String note);

    void deleteNote(int index);
}
class CalendarApp implements NoteBook {
    List<String> notes = new ArrayList<>();

    @Override
    public void addNote(String note) {
        notes.add(note);
        System.out.println("Заметка успешно добавлена!");
    }

    @Override
    public void deleteNote(int index){
        String object = notes.get(index);
        if (notes.remove(object)){
            System.out.println("Заметка успешно удалена!");
        } else {
            System.out.println("Неверный индекс для удаления заметки!");
        }
    }
}

abstract class Test {
    private int a = 1;
    protected abstract void test();
}
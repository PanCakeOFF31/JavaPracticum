package yandexPracticum.javaFinalModule.theme_8;

import lombok.NonNull;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import java.util.ArrayList;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Theme_8 {
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
        printSection("Program_1. ");

        printAnyMsg(null);
        printMsg(null);

        new ArrayList<>().add(null);

        printSectionEnding();
    }

//    @Validate
    private static void printMsg(@NonNull String msg){
//        System.out.println(msg);
    }

    private static void printAnyMsg(String msg){
//        System.out.println(msg);
    }
}

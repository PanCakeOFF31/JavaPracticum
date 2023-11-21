package yandexPracticum.javaCoreIntroduction.theme_16_Object.lesson_5;

import java.util.Arrays;
import java.util.Objects;

import static helpers.Helpers.*;

public class Practicum_5 {
    public static void practicum_5() {
        printSection("Practicum_5. toString()");

        program_1();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program_1. ");

        System.out.println(" " + " ");

        Address address = new Address();
        System.out.println(address);

        printSubSectionEnding();
    }

     /*private static void program_*() {
        printSubsection("");
        printSectionEnding();
    }*/
}
class PostComment {
    private String text; // содержание комментария
    private String[] whoLiked; // кто поддержал

    @Override
    public String toString() {
        return super.toString();
    }
}

class Address {
    public String city;
    public String street;
    public int houseNumber;
    public String extraInfo;
    public String[] residents;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return houseNumber == address.houseNumber && Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(extraInfo, address.extraInfo) && Arrays.equals(residents, address.residents);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(city, street, houseNumber, extraInfo);
        result = 31 * result + Arrays.hashCode(residents);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                "\n, street='" + street + '\'' +
                "\n, houseNumber=" + houseNumber +
                "\n, extraInfo='" + extraInfo + '\'' +
                "\n, residents=" + Arrays.toString(residents) +
                '}';
    }
}
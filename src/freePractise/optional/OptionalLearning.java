package freePractise.optional;

import java.util.Optional;

public class OptionalLearning {
    public static void main(String[] args) {
//        Integer number = null;
//        Optional<Integer> value = Optional.of(number);
//        Optional<Integer> empty = Optional.empty();

//        System.out.println(empty);
//        System.out.println(value);

        Integer number = null;
        Optional<Integer> value = Optional.ofNullable(number);
        System.out.println(value);

        number = 10;
        value = Optional.ofNullable(number);
        System.out.println(value);

        String asd = "";
        System.out.println("asd.isBlank() = " + asd.isBlank());
        System.out.println("asd.isEmpty() = " + asd.isEmpty());
        String asdd = "  ";
        System.out.println("asdd.isBlank() = " + asdd.isBlank());
        System.out.println("asdd.isEmpty() = " + asdd.isEmpty());
    }
}

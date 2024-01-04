package freePractise.JUunit5.parameterizedTest;

import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MethodSourceTest {
    @TestFactory
    static Stream<String> supplyStrings() {
        return Stream.of("first", "second", "another", null);
    }

    @ParameterizedTest
    @MethodSource("supplyStrings")
    void methodSource_test_1(String arg) {
        assertNotNull(arg);
        System.out.println("arg = " + arg);
    }

    static IntStream supplyInts() {
        return IntStream.of(10, 20, 30);
    }

    @ParameterizedTest
    @MethodSource("supplyInts")
    void methodSource_test_2(int arg) {
        assertTrue(arg > 0);
        System.out.println("arg = " + arg);
    }

    static List<Double> supplyIntsViaList() {
        return List.of(10.0, 20.0, 30.0);
    }

    @ParameterizedTest
    @MethodSource("supplyIntsViaList")
    void methodSource_test_3(double arg) {
        System.out.println(arg);
    }

    static Stream<Arguments> supplyMuptilpleArguments() {
        return Stream.of(
                Arguments.of("str-1", 10),
                Arguments.of("str-2", 20)
        );
    }

    @ParameterizedTest
    @MethodSource("supplyMuptilpleArguments")
    void methodSource_test_4(String str, int value) {
        System.out.println(str + value);
    }

    static Stream<Integer> supplierIntegerStream() {
        Random random = new Random();
        return Stream.generate(() -> random.nextInt(100, 150)).limit(10);
    }

    static Stream<Supplier<Integer>> supplierStream() {
        Supplier<Integer> supplier1 = () -> 10;
        Supplier<Integer> supplier2 = () -> 20;
        Supplier<Integer> supplier3 = () -> 30;
        return Stream.of(supplier1, supplier2, supplier3);
    }

    @ParameterizedTest
    @MethodSource("supplierStream")
    void methodSource_test_5(Supplier<Integer> supplier) {
        System.out.println(supplier.get());
    }

}

package freePractise.JUunit5.parameterizedTest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ArgumentAggregationTest {
    @ParameterizedTest
    @CsvSource({
            "Jane, Doe, F, 1990-05-20",
            "John, Doe, M, 1990-10-22"
    })
    void argumentAggregation_test_1(ArgumentsAccessor accessor) {
        System.out.println(accessor.getString(0));
        System.out.println(accessor.getString(1));
        System.out.println(accessor.getString(2));
        System.out.println(accessor.getString(3));
    }

    static Stream<Arguments> supply() {
        return Stream.of(
                Arguments.of("asd", "zxc", "asd", "zxvgf"),
                Arguments.of("asd", "zxc", "asd", "zxvgf")
        );
    }

    @ParameterizedTest
    @MethodSource("supply")
    void argumentAggregation_test_2(ArgumentsAccessor accessor) {
        System.out.println(accessor.getString(0));
        System.out.println(accessor.getString(1));
        System.out.println(accessor.getString(2));
        System.out.println(accessor.getString(3));
    }
}

package yandexPracticum.webinars.webinar7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Webinar7Test {

    @ParameterizedTest(name = "[{index}, {0}, {1}, {2}]")
    @MethodSource("getArguments")
    public void test1(int a, boolean b, String c) {
        assertEquals(10, a);
        assertEquals(3, c.length());
    }

    private static List<Arguments> getArguments() {
        return List.of(
                Arguments.of(10, false, "max"),
                Arguments.of(10, true, "max")
        );
    }

}

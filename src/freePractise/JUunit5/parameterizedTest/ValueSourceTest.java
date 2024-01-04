package freePractise.JUunit5.parameterizedTest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

public class ValueSourceTest {

    @ParameterizedTest(name = "{index} - длина строки {0} равняется 3")
    @ValueSource(strings = {"asd", "asd", "zxc"})
    void parameterizedTest1(String str) {
        assertEquals(3, str.length());
    }

    @ParameterizedTest(name = "[{index}] - число \"{0}\" положительное")
    @ValueSource(ints = {10, 20, 30, -15})
    void parameterizedTest2(int a) {
        assertTrue(a > 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"asd", " "})
    @NullSource
    @EmptySource
    void parameterizedTest3(String str) {
        System.out.println("\"" + str + "\"");
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 20})
    @NullAndEmptySource
    void parameterizedTest4(int value) {
        System.out.println(value);
    }

    @ParameterizedTest
    @ValueSource(classes = {Integer.class,Double.class})
    <T> void parameterizedTest5(Class<T> classOf) {
        System.out.println(classOf);
    }
}

package freePractise.JUunit5.parameterizedTest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CsvSourceTest {
    @ParameterizedTest
    @CsvSource({
            "apple, red",
            "orange,orange"})
    void csvSource_test1(String str1, String str2) {
        System.out.println(str1 + " " + str2);
    }
}

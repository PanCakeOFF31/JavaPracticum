package freePractise.JUunit5.parameterizedTest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ImplicitConversionTest {
    @ParameterizedTest
    @ValueSource(strings = "http://localhost:8080/tasks")
    void testWithImplicitArgumentConversion(URI argument) {
        System.out.println(argument.getClass());
        assertNotNull(argument.toString());
    }
}

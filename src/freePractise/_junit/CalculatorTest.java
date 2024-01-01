package freePractise._junit;

import helpers.coloredString.Logger;
import org.junit.jupiter.api.*;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @BeforeAll
    static void beforeAll() {
        Logger.printMessage("Выполнился lifecycle method перед началом выполнения всех тестов");
    }

    @AfterAll
    static void afterAll() {
        Logger.printMessage("Выполнился lifecycle method после выполнения всех тестов");
    }

    @BeforeEach
    void beforeEach() {
        Logger.printMessage("Выполнился lifecycle method перед каждым");
    }

    @AfterEach
    void afterEach() {
        Logger.printMessage("Выполнился lifecycle method после каждого");
    }

    @Test
    void T0010_PS01_addition() {
        Assertions.assertEquals(10, calculator.summation(5, 5));
    }

    @Test
    @Disabled("Тест отключен потому что не нужен")
    void T0010_PS02_addition() {
        Assertions.assertEquals(15, calculator.summation(5, 5));
    }

    @Test
    @Disabled
    void T0010_PS03_addition() {
        Assertions.fail();
    }

}

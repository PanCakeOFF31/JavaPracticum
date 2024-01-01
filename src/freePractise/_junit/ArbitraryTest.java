package freePractise._junit;

import helpers.coloredString.Logger;
import org.junit.jupiter.api.*;

public class ArbitraryTest {
    @BeforeEach
    @DisplayName("The before each annotated method №2")
    void beforeEach2() {
        Logger.printMessage("Выполнился метод beforeEach2");
    }

    @BeforeEach
    @DisplayName("The before each annotated method №1")
    void beforeEach1() {
        Logger.printMessage("Выполнился метод beforeEach1");
    }

    @BeforeEach
    @DisplayName("The before each annotated method №3")
    @Disabled
    void beforeEach3() {
        Logger.printMessage("Выполнился метод beforeEach3");
    }

    @Test
    void T0001_PS00_emptyTest() {
        Assumptions.assumeTrue(true);
        Assertions.assertTrue(true);
    }
    @Test
    @Disabled
    void T0002_PS00_emptyTest() {
        Assumptions.assumeTrue(false);
        Assertions.assertTrue(true);
    }
}

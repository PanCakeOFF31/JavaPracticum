package freePractise.JUunit5;

import helpers.coloredString.Logger;
import org.junit.jupiter.api.*;

public class LifecycleMethodsTest {
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
    @Disabled // На него не действует эта аннотация
    void beforeEach3() {
        Logger.printMessage("Выполнился метод beforeEach3");
    }

    @Test
    void T0001_PS00_emptyTest() {
        Assumptions.assumeTrue(true);
        Assertions.assertTrue(true);
    }
    @Test
    @Disabled("Деактивированный тест, с указанием причины")
    void T0002_PS00_emptyTest() {
        Assumptions.assumeTrue(false);
        Assertions.assertTrue(true);
    }

    @Test
    void T0001_PS00_(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(1,1),
                () -> Assertions.assertEquals(1,1),
                () -> Assertions.assertEquals(1,1)
        );
    }
}

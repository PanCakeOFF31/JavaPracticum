package freePractise.JUunit5.classOrderAnnotation;

import helpers.coloredString.Logger;
import org.junit.jupiter.api.*;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class ClassOrderClassNameTest {
    @BeforeEach
    void beforeEach() {
        Logger.printMessage("Before each from surrounding class");
    }

    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @Order(1)
    @Nested
    class SecondaryTest {
        @BeforeEach
        void beforeEach() {
            Logger.printMessage("Before each from inner class");
        }

        @Test
        @Order(1)
        @DisplayName("SecondaryTest_test_1")
        void test1_in_SecondaryTest() {

        }

        @Test
        @Order(2)
        @DisplayName("SecondaryTest_test_2")
        void test2_in_SecondaryTest() {

        }
    }

    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @Order(2)
    @Nested
    class PrimaryTest {
        @Test
        @Order(2)
        @DisplayName("PrimaryTest_test_1")
        void test1_in_PrimaryTest() {

        }

        @Test
        @Order(1)
        @DisplayName("PrimaryTest_test_2")
        void test2_in_PrimaryTest() {

        }
    }

    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @Order(2)
    static class TertiaryTest {
        @Test
        @Order(2)
        @DisplayName("PrimaryTest_test_1")
        void test1_in_PrimaryTest() {

        }

        @Test
        @Order(1)
        @DisplayName("PrimaryTest_test_2")
        void test2_in_PrimaryTest() {

        }

        @BeforeEach
        void beforeEach() {
            Logger.printMessage("Before each from nested class");
        }
    }
}

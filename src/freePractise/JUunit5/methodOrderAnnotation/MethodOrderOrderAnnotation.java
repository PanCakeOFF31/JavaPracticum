package freePractise.JUunit5.methodOrderAnnotation;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderOrderAnnotation {
    @Test
    @DisplayName("1")
    @Order(1)
    void test_4() {

    }

    @Test
    @DisplayName("2")
    @Order(10)
    void test_3() {

    }

    @Test
    @DisplayName("4")
    @Order(-5)
    void test_1() {

    }

    @Test
    @DisplayName("3")
    @Order(2)
    void test_2() {

    }
}

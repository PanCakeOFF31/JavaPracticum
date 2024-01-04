package freePractise.JUunit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Класс для демонстрации display name annotation")
public class DisplayNameTest {
    @Test
    @DisplayName("asd")
    void temp () {
        Assertions.assertTrue(true);
    }
}

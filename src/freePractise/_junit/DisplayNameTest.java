package freePractise._junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Класс для демонстрации display name annotation")
public class DisplayNameTest {
    @Test
    void temp () {
        Assertions.assertTrue(true);
    }
}

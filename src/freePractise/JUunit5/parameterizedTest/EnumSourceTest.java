package freePractise.JUunit5.parameterizedTest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;

public class EnumSourceTest {
    @ParameterizedTest
    @EnumSource(DayOfWeek.class)
    void parameterizedTest1(DayOfWeekBehavior day) {
        assertNotNull(day);
    }

    @ParameterizedTest
    @EnumSource
    void parameterizedTest2(DayOfWeek day) {
        assertNotNull(day);
    }

    @ParameterizedTest
    @EnumSource(names = {"MONDAY", "TUESDAY", "WEDNESDAY"})
    void parameterizedTest3(DayOfWeek day) {
        assertTrue(EnumSet.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY).contains(day));
    }


    @ParameterizedTest
    @EnumSource(mode = EXCLUDE, names = {"MONDAY", "TUESDAY"})
    void parameterizedTest4(DayOfWeek day) {
        assertTrue(EnumSet.of(DayOfWeek.WEDNESDAY,DayOfWeek.FRIDAY).contains(day));
    }


}

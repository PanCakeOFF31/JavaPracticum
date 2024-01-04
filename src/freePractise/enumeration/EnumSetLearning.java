package freePractise.enumeration;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;

public class EnumSetLearning {
    public static void main(String[] args) {
        Enum<Level> levels = Level.HIGH;

        EnumSet<Level> enumSet = EnumSet.of(Level.HIGH);

        EnumMap<Level, String> enumMap = new EnumMap<>(Level.class);
        enumMap.put(Level.HIGH, "Высокий уровень");

        HashMap<Level, String> map = new HashMap<>();
        map.put(Level.HIGH, "Высокий уровень");
    }
}

enum Level {
    HIGH,
    MEDIUM,
    LOW;
}

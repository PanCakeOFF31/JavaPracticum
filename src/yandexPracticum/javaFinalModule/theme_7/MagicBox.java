package yandexPracticum.javaFinalModule.theme_7;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class MagicBox implements Comparable<MagicBox> {
    int value;

    @Override
    public int compareTo(MagicBox o) {
        if (value > o.value) {
            return 42;
        } else {
            return -42;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

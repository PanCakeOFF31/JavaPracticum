package yandexPracticum.javaFinalModule.theme_7;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BowlingPin implements Comparable<BowlingPin> {
    private final int height;
    private final int width;

    @Override
    public int compareTo(BowlingPin o) {
        if (this.height == o.height)
            return this.width - this.height;
        else return this.height - o.height;

    }
}

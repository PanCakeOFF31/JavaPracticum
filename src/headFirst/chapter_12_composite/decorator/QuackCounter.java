package headFirst.chapter_12_composite.decorator;

import headFirst.chapter_12_composite.duck.Quackable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class QuackCounter implements Quackable {
    public static int numberOfQuacks = 0;
    private final Quackable duck;

    @Override
    public void quack() {
        duck.quack();
        numberOfQuacks++;
    }

    public static int getQuacks() {
        return numberOfQuacks;
    }
}

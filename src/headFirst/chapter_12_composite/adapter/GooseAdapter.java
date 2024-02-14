package headFirst.chapter_12_composite.adapter;

import headFirst.chapter_12_composite.duck.Quackable;
import headFirst.chapter_12_composite.goose.Goose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GooseAdapter {
    private final Goose goose;

    @Override
    public void quack() {
        goose.honk();
    }
}

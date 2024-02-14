package headFirst.chapter_1_startegy_repeat.duck_v2.quack_behavior;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Silence");
    }
}

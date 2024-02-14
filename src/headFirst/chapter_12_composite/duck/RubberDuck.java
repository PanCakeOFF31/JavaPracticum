package headFirst.chapter_12_composite.duck;

public class RubberDuck implements Quackable{
    @Override
    public void quack() {
        System.out.println("RubberDuck - quacking");
    }
}

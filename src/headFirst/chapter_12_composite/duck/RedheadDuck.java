package headFirst.chapter_12_composite.duck;

public class RedheadDuck implements Quackable{
    @Override
    public void quack() {
        System.out.println("RedheadDuck - quacking");
    }
}

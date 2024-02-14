package headFirst.chapter_12_composite.duck;

public class DuckCall implements Quackable{
    @Override
    public void quack() {
        System.out.println("DuckCall - Kwak");
    }
}

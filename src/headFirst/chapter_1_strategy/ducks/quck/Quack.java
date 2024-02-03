package headFirst.chapter_1_strategy.ducks.quck;

public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Утки, которые крякают: кря!");
    }
}

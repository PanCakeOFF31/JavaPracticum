package headFirst.chapter_12_composite.observer;

public class Quaclogist implements Observer {
    @Override
    public void update(QuackObservable duck) {
        System.out.println("Glaciologist: " + duck + "just quacked");
    }
}

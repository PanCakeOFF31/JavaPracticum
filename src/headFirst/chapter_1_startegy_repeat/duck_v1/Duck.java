package headFirst.chapter_1_startegy_repeat.duck_v1;

public abstract class Duck {
    public void quack() {
        System.out.println("Утка крякает");
    }

    public void swim() {
        System.out.println("Утка плавает");
    }

    public void fly() {
        System.out.println("Утка летает");
    }

    public abstract void display();
}

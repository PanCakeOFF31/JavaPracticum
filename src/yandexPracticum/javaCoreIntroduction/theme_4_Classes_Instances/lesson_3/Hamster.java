package yandexPracticum.javaCoreIntroduction.theme_4_Classes_Instances.lesson_3;

class Hamster {

    String name = "Байт";
    int age = 2;
    String color = "Рыжий";
    int weight  = 350;

    void eat(int foodWeight) {
        this.weight += foodWeight;
        System.out.println("Съел еды на " + foodWeight + " грамм");
    }

    void runInWheel() {
        System.out.println("Бегу-Бегу-Бегу");
        this.weight -= 5;
    }

    void hideSeed(int seedWeight) {
        weight += seedWeight;
        System.out.println("Зимой не заголодаю");
    }

}

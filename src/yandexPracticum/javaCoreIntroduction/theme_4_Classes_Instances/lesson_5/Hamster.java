package yandexPracticum.javaCoreIntroduction.theme_4_Classes_Instances.lesson_5;

class Hamster {
    String name;
    int age;
    String color;
    int weight;
    static private final String detachment = "rodent";

    // Конструктор №1, количество параметров соответствует количеству полей класса
    Hamster(String name, int age, int weight, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.weight = weight;
    }

    Hamster(String name, int age, String color) {
        this.weight = -1;
    }

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

    void printName() {
        System.out.println("Меня зовут: " + this.name);
        System.out.println("Я из отряда: " + detachment);
    }
}
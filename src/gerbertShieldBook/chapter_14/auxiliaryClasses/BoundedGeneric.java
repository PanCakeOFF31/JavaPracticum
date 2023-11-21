package gerbertShieldBook.chapter_14.auxiliaryClasses;

public class BoundedGeneric<T extends Number> {
    private final T[] numbers;

    public BoundedGeneric(T[] numbers) {
        this.numbers = numbers;
    }

    public double average() {
        double sum = 0.0;

        for (T number : numbers) {
            sum += number.doubleValue();
        }

        return sum / numbers.length;
    }

//    Использую аргумент с подстановочным знаком, чтобы сравнить разные спецификации обобщенного
//    класса на то, что внутренни массив имеет то же среднее.
    public boolean isSameAverage(BoundedGeneric<?> numbers) {
        return this.average() == numbers.average();
    }
}

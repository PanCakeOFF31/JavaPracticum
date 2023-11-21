package yandexPracticum.javaCoreIntroduction.theme_10_primitive.lesson_2;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Lesson_2 {
    public static void lesson_2() {
        printSection("Lesson_2. Приведение типов в арифметических вычислениях");

        double roubles = 5000; // сумма на счету
        double yearRate = 4; // годовая процентная ставка
        int numOfMonth = 36; // количество месяцев, на который открыт вклад
        double monthRefill = 1000; // ежемесячное пополнение

        double monthRate = yearRate / 12; // вычислите месячную процентную ставку

        for (int i = 0; i < 36; ++i) { // дополните условие цикла
            double depositInterest = roubles * monthRate / 100; // вычислите доход от процентов
            roubles += depositInterest; // добавьте доход от процентов
            roubles += monthRefill; // учтите ежемесячное пополнение
        }

        System.out.println("Через " + numOfMonth + " месяцев накопится " + roubles + " рублей");

        if (roubles >= 41000) { // определите, удалось ли достичь цели
            System.out.println("Ура! Можно идти в магазин за новым объективом!");
        } else {
            System.out.println("Нужно ещё немного подкопить.");
        }

        printSectionEnding();
    }
}

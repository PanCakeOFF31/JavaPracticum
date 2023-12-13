package yandexPracticum.javaCoreContinuation.theme_9.lesson_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static helpers.Helpers.printSection;

public class Lesson_4 {
    public static void lesson_4() {
        printSection("Lesson_4. ");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество участников: ");
        int playersNumber = scanner.nextInt();

        List<String> words = readWordsFromFile("words.txt");

        // если слов меньше, чем участников, то выведите сообщение:
        // "Недостаточно слов в файле. Добавьте слова и обновите файл."
        // и завершите выполнение программы

        if (words.size() < playersNumber) {
            System.out.println("Недостаточно слов в файле. Добавьте слова и обновите файл.");
            return;
        }

        // воспользуйтесь статическим методом Collections.shuffle(List<?> list),
        // чтобы поменять порядок слов случайным образом

        Collections.shuffle(words);

        int wordsNumber = words.size() / playersNumber;

        for (int i = 0; i < playersNumber; i++) {
            String filename = String.format("player%s.txt", i + 1);
            List<String> subList = words.subList(i * wordsNumber, (i + 1) * wordsNumber);

            writeListToFile(subList, filename);
        }

        System.out.println("Карточки готовы!");
    }

    private static List<String> readWordsFromFile(String filename) {
        // добавьте построчное чтение из файла с помощью BufferedReader
        // в случае ошибки выведите сообщение: "Произошла ошибка во время чтения файла."
        List<String> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename,StandardCharsets.UTF_8))) {
            while (reader.ready()) {
                list.add(reader.readLine());
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка во время чтения файла.");
        }

        return list;
    }

    private static void writeListToFile(List<String> list, String filename) {
        // добавьте запись слов в файл с помощью FileWriter
        // в случае ошибки выведите сообщение: "Произошла ошибка во время записи файла."
        try (FileWriter writer = new FileWriter(filename, StandardCharsets.UTF_8)) {
            for (String s : list) {
                writer.write(s);
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка во время записи файла.");
        }
    }

}

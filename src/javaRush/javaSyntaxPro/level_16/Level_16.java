package javaRush.javaSyntaxPro.level_16;

import java.io.*;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Filter;

import static helpers.Helpers.*;

public class Level_16 {
    public static void level_16() {
        printSection("Level 16. Потоки ввода/вывода. Input/Output Streams");


//        FiledReader
//        program_2();

//        BufferedReader
//        program_1();

//        FileInputStream
//        program_3();

//        BufferedInputStream
//        program_4();

//        Копирование файла FileReader and FileWriter
//        Копирование файла BufferedReader and BufferedWriter
//        program_5();

//        Упрощенная форма оформления кода
//        program_6();

//        FileInputStream Methods
//        program_7();
//        program_8();

//        OutputStream Methods
//        program_9();

//        transferTo(OutputStream out)
//        program_10();

//        FileReader/FileWriter
//        program_11();

//        BufferedReader/BufferedWriter
//        program_12();

//        1,2,3 и 4 байтный код символа
//        program_13();

//        readAllLines vs BufferedReader
//        program_14();

//        Path interface
//        program_15();

//        Files class
        program_16();

        printSectionEnding();
    }

    private static void program_1() {
        printSubSection("Program 1. Character input stream - BufferedReader");

        String path = "src/files/JavaRush/JavaSyntaxPro/Level_16/JavaRushFile.txt";

        printSubSection("Стандартная конструкция:");
        {
            BufferedReader input = null;

            try {
                input = new BufferedReader(new FileReader(path));
                int character = input.read();
                while (character != -1) {
                    System.out.println((char) character);
                    character = input.read();
                }

                input = new BufferedReader(new FileReader(path));
                String text = input.readLine();
                System.out.println(text);

            } catch (FileNotFoundException e) {
                System.out.println("Проблемы при открытии");
            } catch (IOException e) {
                System.out.println("Проблемы во время считывания");
            } finally {
                try {
                    if (input != null) input.close();
                } catch (IOException e) {
                    System.out.println("Проблемы при закрытии");
                }
            }
        }
        printSubSectionEnding();

        printSubSection("try-with-resources конструкция");
        {
            try (BufferedReader input = new BufferedReader(new FileReader(path))) {
                int character = input.read();
                while (character != -1) {
                    System.out.println((char) character);
                    character = input.read();
                }
            } catch (FileNotFoundException e) {
                System.out.println("Проблемы при открытии");
            } catch (IOException e) {
                System.out.println("Проблемы во время считывания");
            } finally {
//               На тот случай, если нужно сделать свой finally
            }

            try (BufferedReader input = new BufferedReader(new FileReader(path))) {
                String text = input.readLine();
                System.out.println(text);
            } catch (FileNotFoundException e) {
                System.out.println("Проблемы при открытии");
            } catch (IOException e) {
                System.out.println("Проблемы во время считывания");
            } finally {
//               На тот случай, если нужно сделать свой finally
            }

        }

        printSubSectionEnding();
    }

    private static void program_2() {
        printSubSection("Program_2. Character input stream - FileReader ");

        String path = "src/files/src/files/JavaRush/JavaSyntaxPro/Level_16/JavaRushFile.txt";
        FileReader input = null;

        try {
            input = new FileReader(path);
            int character = input.read();
            while (character != -1) {
                System.out.println((char) character);
                character = input.read();
            }

//            FileReader не может читать строки
//            input = new FileReader(path);
//            String text = input.readLine();
//            System.out.println(text);

        } catch (FileNotFoundException e) {
            System.out.println("Проблемы при открытии");
        } catch (IOException e) {
            System.out.println("Пробелмы во время считывания");
        } finally {
            try {
                if (input != null) input.close();
            } catch (IOException e) {
                System.out.println("Проблемы при закрытии");
            }
        }

        printSubSectionEnding();
    }

    private static void program_3() {
        printSubSection("Program_3. Byte input stream - FileInputStream ");

        String path = "src/files/src/files/JavaRush/JavaSyntaxPro/Level_16/JavaRushFile.txt";
        FileInputStream input = null;

        try {
            input = new FileInputStream(path);
            int character = input.read();
            while (character != -1) {
                System.out.println((char) character);
                character = input.read();
            }

//            FileInputStream не читает по строке
//            input = new FileInputStream(path);
//            String text = input.readLine();
//            System.out.println(text);

        } catch (FileNotFoundException e) {
            System.out.println("Проблемы при открытии");
        } catch (IOException e) {
            System.out.println("Проблемы во время считывания");
        } finally {
            try {
                if (input != null) input.close();
            } catch (IOException e) {
                System.out.println("Проблемы при закрытии");
            }
            printSubSectionEnding();
        }
    }

    private static void program_4() {
        printSubSection("Program_4. Byte input stream - BufferedInputStream");


        String path = "src/files/src/files/JavaRush/JavaSyntaxPro/Level_16/JavaRushFile.txt";
        BufferedInputStream input = null;

        try {
            input = new BufferedInputStream(new FileInputStream(path));
            int character = input.read();

            while (character != -1) {
                System.out.println((char) character);
                character = input.read();
            }

            input = new BufferedInputStream(new FileInputStream(path));
            byte[] allBytes = input.readAllBytes();

            for (byte b : allBytes) {
                System.out.print((char) b);
            }
            System.out.println();

        } catch (FileNotFoundException e) {
            System.out.println("Проблемы при открытии");
        } catch (IOException e) {
            System.out.println("Проблемы во время считывания");
        } finally {
            try {
                if (input != null) input.close();
            } catch (IOException e) {
                System.out.println("Проблемы при закрытии");
            }
            printSubSectionEnding();
        }

        printSubSectionEnding();
    }

    private static void program_5() {
        printSubSection("Program_5. Character stream. FileReader and FileWriter");

        {
            String pathFrom = "src/files/JavaRush/JavaSyntaxPro/Level_16/CopyingFrom.txt";
            String pathTo = "src/files/JavaRush/JavaSyntaxPro/Level_16/CopyingTo.txt";

            try (FileReader input = new FileReader(pathFrom); FileWriter output = new FileWriter(pathTo)) {
                int character = input.read();

                while (character != -1) {
                    output.write(character);
                    character = input.read();
                }
                System.out.println("Копирование файла CopyingFrom.txt в CopyingTo.txt выполнено успешно!");
            } catch (FileNotFoundException e) {
                System.out.println("Проблемы при открытии");
            } catch (IOException e) {
                System.out.println("Проблемы во время reading/writing");
            }
        }

        {
            String pathFrom = "src/files/JavaRush/JavaSyntaxPro/Level_16/CopyingFrom_1.txt";
            String pathTo = "src/files/JavaRush/JavaSyntaxPro/Level_16/CopyingTo_1.txt";

            try (BufferedReader input = new BufferedReader(new FileReader(pathFrom)); BufferedWriter output = new BufferedWriter(new FileWriter(pathTo))) {
                String text;

                while ((text = input.readLine()) != null) {
                    output.write(text);
                    output.write('\n');
                }
                System.out.println("Копирование файла CopyingFrom_1.txt в CopyingTo_1.txt выполнено успешно!");
            } catch (FileNotFoundException e) {
                System.out.println("Проблемы при открытии");
            } catch (IOException e) {
                System.out.println("Проблемы во время reading/writing");
            }
        }

        printSubSectionEnding();
    }

    private static void program_6() {
        printSubSection("Program_6. JustEmmetText.txt");

        String path = "src/files/JavaRush/JavaSyntaxPro/Level_16/JustEmmetText.txt";

        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            String text;

            while ((text = reader.readLine()) != null) {
                System.out.println(text);
            }
            System.out.println("Работа с файлом успешно завершена.");
        } catch (FileNotFoundException e) {
            System.out.println("Проблемы при открытии");
        } catch (IOException e) {
            System.out.println("Проблемы во время reading/writing");
        }

        printSubSectionEnding();

    }

    private static void program_7() {
        printSubSection("Program_7. FileInputStream methods: read(), readAllBytes()");

        String path = "src/files/JavaRush/JavaSyntaxPro/Level_16/FileInputStreamMethods.txt";

        printSubSection("Part 1. read(byte[] b)");
        {
            try (FileInputStream input = new FileInputStream(path)) {
                System.out.println("input.available() = " + input.available());
                System.out.println("input.read() = " + (char) input.read());

                System.out.println("input.available() = " + input.available());

                byte[] buffer = new byte[15]; // 1 kilobyte buffer
                int length = input.read(buffer);
                System.out.println("length = " + length);

                printByteAsChar(buffer);

                System.out.println("input.available() = " + input.available());
            } catch (FileNotFoundException e) {
                System.out.println("Проблемы при открытии");
            } catch (IOException e) {
                System.out.println("Проблемы во время reading/writing");
            }
        }

        printSubSection("Part 2. read(byte[] b, int off, int len)");
        {
            try (FileInputStream input = new FileInputStream(path)) {
                System.out.println("input.available() = " + input.available());

                byte[] buffer = new byte[13]; // 1 kilobyte buffer
                int length = input.read(buffer, 3, 10);
                System.out.println("length = " + length);

                printByteAsChar(buffer);

                System.out.println("input.available() = " + input.available());
            } catch (FileNotFoundException e) {
                System.out.println("Проблемы при открытии");
            } catch (IOException e) {
                System.out.println("Проблемы во время reading/writing");
            }
        }

        printSubSection("Part 3. readAllBytes()");
        {
            try (FileInputStream input = new FileInputStream(path)) {
                System.out.println("input.available() = " + input.available());
                int available = input.available();

                byte[] allBytes = input.readAllBytes();

                printByteAsChar(allBytes);

            } catch (FileNotFoundException e) {
                System.out.println("Проблемы при открытии");
            } catch (IOException e) {
                System.out.println("Проблемы во время reading/writing");
            }
        }

        printSubSectionEnding();
    }

    private static void printByteAsChar(byte... a) {
        PrintStream console = System.out;

        console.print("[");
        for (byte b : a) {
            if (b == 0) {
                System.out.print("_");
                continue;
            }

            System.out.print((char) b);
        }
        console.println("]");
    }

    private static void program_8() {
        printSubSection("Program_8. FileInputStream methods: readNBytes()");

        String path = "src/files/JavaRush/JavaSyntaxPro/Level_16/FileInputStreamMethods.txt";

        printSubSection("Part 1. readNBytes(int len)");
        {
            try (FileInputStream input = new FileInputStream(path)) {
                System.out.println("input.available() = " + input.available());

                System.out.println("input.skip(6) = " + input.skip(6));

                byte[] bytes = input.readNBytes(40);
                System.out.println("bytes.length = " + bytes.length);

                printByteAsChar(bytes);

                System.out.println("input.available() = " + input.available());
            } catch (FileNotFoundException e) {
                System.out.println("Проблемы при открытии");
            } catch (IOException e) {
                System.out.println("Проблемы во время reading/writing");
            }
        }

        printSubSection("Part 2. readNBytes(byte[] b, int off, int len)");
        {
            try (FileInputStream input = new FileInputStream(path)) {
                System.out.println("input.available() = " + input.available());

                byte[] buffer = new byte[10];
                int readed = input.readNBytes(buffer, 0, 10);

                System.out.println("readed = " + readed);

                printByteAsChar(buffer);

                System.out.println("input.available() = " + input.available());
            } catch (FileNotFoundException e) {
                System.out.println("Проблемы при открытии");
            } catch (IOException e) {
                System.out.println("Проблемы во время reading/writing");
            }
        }

        printSubSectionEnding();
    }

    private static void program_9() {
        printSubSection("Program_9. OutputStream");

        String path = "src/files/JavaRush/JavaSyntaxPro/Level_16/FileOutputStreamMethods.txt";

        try (FileOutputStream output = new FileOutputStream(path)) {
            byte[] buffer = {'M', 'A', 'N', '!'};

            output.write(100);
            output.write('J');
            output.write('\n');

            output.write(buffer);
            output.write('\n');

            output.write(buffer, 1, 2);

            printByteFile(path);
        } catch (FileNotFoundException e) {
            System.out.println("Проблемы при открытии:\n" + path);
        } catch (IOException e) {
            System.out.println("Проблемы во время reading/writing:\n" + path);
        }

        printSubSectionEnding();
    }

    private static void printByteFile(String path) {
        try (FileInputStream input = new FileInputStream(path)) {
            byte[] buffer = new byte[input.available()];

            input.read(buffer);
            printByteAsChar(buffer);
        } catch (FileNotFoundException e) {
            System.out.println("Проблемы при открытии:\n" + path);
        } catch (IOException e) {
            System.out.println("Проблемы во время reading/writing:\n" + path);
        }
    }

    private static void program_10() {
        printSubSection("Program_10. transferTo(OutputStream output)");

        String pathFrom = "src/files/JavaRush/JavaSyntaxPro/Level_16/transferToFrom.txt";
        String pathTo = "src/files/JavaRush/JavaSyntaxPro/Level_16/transferToTo.txt";

        {
            try (FileInputStream input = new FileInputStream(pathFrom);
                 FileOutputStream output = new FileOutputStream(pathTo)) {
                input.transferTo(output);
                printByteFile(pathTo);
            } catch (FileNotFoundException e) {
                System.out.println("Проблемы при открытии:");
            } catch (IOException e) {
                System.out.println("Проблемы во время reading/writing");
            }
        }

        {
            try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(pathFrom))) {
                input.mark(100);

                byte[] buffer = input.readNBytes(10);
                printByteAsChar(buffer);

                System.out.println("input.markSupported() = " + input.markSupported());
                input.reset();

                buffer = input.readNBytes(10);
                printByteAsChar(buffer);

            } catch (FileNotFoundException e) {
                System.out.println("Проблемы при открытии:");
            } catch (IOException e) {
                System.out.println("Проблемы во время reading/writing");
            }
        }


        printSubSectionEnding();
    }

    private static void program_11() {
        printSubSection("Program_11. FileWriter/FileReader");

        String readPath = "src/files/JavaRush/JavaSyntaxPro/Level_16/FileReader.txt";
        String writePath = "src/files/JavaRush/JavaSyntaxPro/Level_16/FileWriter.txt";


        try (FileReader reader = new FileReader(readPath);
             FileWriter writer = new FileWriter(writePath)) {

            while (reader.ready()) {
                int character = reader.read();
                writer.append((char) character);
            }

            writer.write("\nБонусная строка, сам добавил :)");

        } catch (FileNotFoundException e) {
            System.out.println("Проблемы при открытии:");
        } catch (IOException e) {
            System.out.println("Проблемы во время reading/writing");
        }

        printCharFile(writePath);

        printSubSectionEnding();
    }

    private static void printCharFile(String path) {
        try (FileReader reader = new FileReader(path)) {
            char[] buffer = new char[1000];
            int length = reader.read(buffer);

            char[] correctedBuffer = new char[length];
            System.arraycopy(buffer, 0, correctedBuffer, 0, length);

            printChars(correctedBuffer);
        } catch (FileNotFoundException e) {
            System.out.println("Проблемы при открытии:\n" + path);
        } catch (IOException e) {
            System.out.println("Проблемы во время reading/writing:\n" + path);
        }
    }

    private static void printChars(char... chars) {
        PrintStream console = System.out;

        console.print("[");
        for (char c : chars) {
            console.print(c);
        }
        console.println("]");
    }

    private static void program_12() {
        printSubSection("Program_12. BufferedReader/BufferedWriter");

        printSubSectionEnding();
    }

    //    Здесь я проверял 1,2,3 и 4 байтное код символа
    private static void program_13() {
        printSubSection("Program_13. 1-byte, 2-bytes and 3-bytes characters of UTF-8");

        String path = "src/files/JavaRush/JavaSyntaxPro/Level_16/UTF-8.txt";

        try (FileInputStream input = new FileInputStream(path)) {

            byte[] buffer = new byte[input.available()];
            System.out.println("input.available() = " + input.available());

            input.read(buffer);
            System.out.println(buffer.length);

            for (byte b : buffer) {
                System.out.println(b);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Проблемы при открытии:");
        } catch (IOException e) {
            System.out.println("Проблемы во время reading/writing");
        }
/*

        try (FileOutputStream output = new FileOutputStream(path)) {
//
//            Запись двух-байтного кода-символа
//           output.write(0b1110_0000);
//           output.write(0b10_10_0000);
//           output.write(0b10_00_0001);

//            Запись 4 байтного кода-символа
//            output.write(0b1111_0_000);
//            output.write(0b10_010110);
//            output.write(0b10_010000);
//            output.write(0b10_100101);

//              Не записывать эту строку, вызовет ошибку.
//              Так как есть ведущий байт, двух байтного кода, но нет байта продолжения.
//            output.write(0b1101_1010);

        } catch (FileNotFoundException e) {
            System.out.println("Проблемы при открытии:");
        } catch (IOException e) {
            System.out.println("Проблемы во время reading/writing");
        }
*/

//        System.out.println('\u0430');
//        System.out.println((char) 1072);
//        System.out.println();

        System.out.println("\u0430\u0430");

        printSubSectionEnding();
    }

    //    InputStreamReader - это Reader, который читает из InputStream
    private static void program_14() {
        printSubSection("Program_14. readAllLines() vs BufferedReader");

        String path = "src/files/JavaRush/JavaSyntaxPro/Level_16/ReadingLines.txt";

        printPart("readAllLines()");
        {
            try {
                List<String> lines =
                        Files.readAllLines(Path.of("src", "files", "JavaRush",
                                "JavaSyntaxPro", "Level_16", "ReadingLines.txt"));

                System.out.println("lines.size() = " + lines.size());

                for (String line : lines) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Возникли проблемы с readAllLines()");
            }
        }

        printPart("BufferedReader");
        {
//            Здесь я построил конструкцию для наглядности, блок ниже упрощенный вариант,
//            но внутри суть та же.
            try (FileInputStream fileIS = new FileInputStream(path);
                 InputStreamReader inputSR = new InputStreamReader(fileIS);
                 BufferedReader reader = new BufferedReader(inputSR)) {

                for (; ; ) {
                    String line = reader.readLine();
                    if (line == null)
                        break;
                    System.out.println(line);
                }

            } catch (FileNotFoundException e) {
                System.out.println("Проблемы при открытии:");
            } catch (IOException e) {
                System.out.println("Проблемы во время reading/writing");
            }
        }

        printPart("BufferedReader, the simple form");
        {
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

                for (; ; ) {
                    String line = reader.readLine();
                    if (line == null)
                        break;
                    System.out.println(line);
                }

            } catch (FileNotFoundException e) {
                System.out.println("Проблемы при открытии:");
            } catch (IOException e) {
                System.out.println("Проблемы во время reading/writing");
            }
        }

        printSubSectionEnding();
    }

    private static void program_15() {
        printSubSection("Program_15. Path interface");

        Path file_1 = Path.of("D:\\YandexDisk\\YandexDisk\\0_Programming\\IntelliJavaProjects\\JavaYandexPracticum\\src\\files\\JavaRush\\JavaSyntaxPro\\Level_16\\PathFile.txt");
        Path file_2 = Path.of("src/files/JavaRush/JavaSyntaxPro/Level_16/PathFile.txt");

        Path directory_1 = Path.of("D:/YandexDisk\\YandexDisk\\0_Programming\\IntelliJavaProjects\\JavaYandexPracticum\\src\\files\\JavaRush\\JavaSyntaxPro\\Level_16");
        Path directory_2 = Path.of("src\\files\\JavaRush\\JavaSyntaxPro\\Level_16");

        printPart("Имена файлов, через URL/String");
        {
            System.out.println("file_1.getFileName() = " + file_1.getFileName());
            System.out.println("file_2.getFileName() = " + file_2.getFileName());
        }

        printPart("Имена директорий через URL/String");
        {
            System.out.println("directory_1.getFileName() = " + directory_1.getFileName());
            System.out.println("directory_2.getFileName() = " + directory_2.getFileName());
        }

        printPart("Проверка на абсолютный адрес и название корневого компонентна пути");
        {
            System.out.println("file_1.isAbsolute() = " + file_1.isAbsolute());
            System.out.println("file_1.getRoot() = " + file_1.getRoot());

            System.out.println("file_2.isAbsolute() = " + file_2.isAbsolute());
            System.out.println("file_2.getRoot() = " + file_2.getRoot());
        }

        printPart("Путь к файлу, родительский путь, количество родительских элементов");
        {
            System.out.println("file_1 = " + file_1);
            System.out.println("file_1.getParent() = " + file_1.getParent());
            System.out.println("file_1.getNameCount() = " + file_1.getNameCount());

            System.out.println("directory_2 = " + directory_2);
            System.out.println("directory_2.getParent() = " + directory_2.getParent());
            System.out.println("directory_2.getNameCount() = " + directory_2.getNameCount());
        }

        printPart("Превращение путей в абсолютные");
        {
            System.out.println("file_1 = " + file_1);
            System.out.println("file_2 = " + file_2);

            Path copy_1 = Path.of(file_1.toString()).toAbsolutePath();
            Path copy_2 = Path.of(file_2.toString()).toAbsolutePath();

            System.out.println("copy_1 = " + copy_1);
            System.out.println("copy_2 = " + copy_2);
        }

        printPart("Разница между путями");
        {
//            Нарочно использую разные slashes, чтобы продемонстрировать независимость
            Path test_1 = Path.of("C:\\photo\\personal Photo/not Photo/");
            Path test_2 = Path.of("C:\\photo\\personal Photo\\../..\\.\\././");

            System.out.println("test_1.relativize(test_2) = " + test_1.relativize(test_2));
            System.out.println("test_2.relativize(test_1) = " + test_2.relativize(test_1));
        }

        printPart("Строим абсолютный путь из двух путей");
        {
            Path test_1 = Path.of("C:\\photo");
            Path test_2 = Path.of("personal Photo\\");

            System.out.println("test_1 = " + test_1);
            System.out.println("test_2 = " + test_2);

            System.out.println("test_1.resolve(test_2) = " + test_1.resolve(test_2));
            System.out.println("test_2.resolve(test_1) = " + test_2.resolve(test_1));

        }

        printSubSectionEnding();
    }

    private static void program_16() {
        printSubSection("Program_16. Files class.");

        Path folderFrom = Path.of("src\\files\\folder_1\\");
        Path folderTo = Path.of("src\\files\\folder_2\\");

        System.out.println("Files.isDirectory(folderFrom) = " + Files.isDirectory(folderFrom));
        System.out.println("Files.isRegularFile(folderTo) = " + Files.isRegularFile(folderTo));

        Path file = Path.of("file.txt");
        Path source = folderFrom.resolve(file);
        Path destination = folderTo.resolve(file);

        System.out.println("Files.isRegularFile(source) = " + Files.isRegularFile(source));


        try {
//            Если нужно, сними комментарий строки
//            Files.deleteIfExists(destination);

            if (Files.exists(destination)) {
                Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Скопировали с замещением");
            } else {
                Files.copy(source, destination);
                System.out.println("Скопировали без exists");
            }
            String fileName = destination.getFileName().toString();
            System.out.println(fileName + " весит " + Files.size(destination) + " bytes");
        } catch (IOException e) {
            System.out.println("Проблемы в процессе копирования файлов");
        }

        printPart();
        try {
            folderTo = Path.of("src\\files\\");
            Path folder = folderTo.resolve("folder_3");
            Path newFile = folder.resolve("text.txt");

            System.out.println("folder = " + folder);
            System.out.println("newFile = " + newFile);

            Files.createDirectory(folder);
            Files.createFile(newFile);

            System.out.println("folder.resolve(\"textCopy.txt\") = " + folder.resolve("textCopy.txt"));
            Files.copy(newFile,folder.resolve("textCopy.txt"));

        } catch (IOException e) {
            System.out.println("Проблемы в процессе создания");
        }

        printPart();
        try {
            Path oldFile = Path.of("src\\files\\folder_3\\text.txt");
            Files.deleteIfExists(oldFile);

        } catch (IOException e) {
            System.out.println("Проблемы в процессе  удаления");
        }

        printSubSectionEnding();
    }

    private static void program_17() {
        printSubSection("Program_17. Files Class. new...");



        printSubSectionEnding();
    }

    private static void program_18() {
        printSubSection("Program_18. ");
        printSubSectionEnding();
    }

    private static void program_19() {
        printSubSection("Program_19. ");
        printSubSectionEnding();
    }

}





























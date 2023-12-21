package gerbertShieldBook.chapter_22;

import helpers.coloredString.Colors;
import helpers.coloredString.Logger;

import java.io.*;
import java.nio.file.Path;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Arrays;

import static helpers.Helpers.*;

public class Chapter_22 {
    private static final Path base = Path.of("src/gerbertShieldBook/chapter_22/files");

    public static void chapter_22() {
        printArticle("Chapter_22. Input/Output. Exploring java.io");

//        Path methods: normalize(), resolve()
//        program_1();

//        File: base methods
//        program_2();

//        File: rename(), create(), delete()
//        program_3();

//        File: other methods
//        program_4();

//        InputStream, FileInputStream
//        program_5();
//        program_6();
//        Порционное чтение через буффер
//        program_7();

//        OutputStream, FileOutputStream
//        program_8();

//        InputStream: transferTo()
//        program_9();

//        InputStream, ByteArrayInputStream
//        program_10();

//        OutputStream, ByteArrayOutputStream
//        program_11();

//        InputStream, FilterInputStream, BufferedInputStream
        program_12();
//        program_13();
//        program_14();
//        program_15();
//        program_16();
//        program_17();
//        program_18();
//        program_19();

//        program_20();

//        program_21();
//        program_22();
//        program_23();
//        program_24();
//        program_25();
//        program_26();
//        program_27();
//        program_28();
//        program_29();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. Path methods: normalize(), resolve()");

        Logger.printMessage("normalize() - part1");
        {
            Path path = Path.of("././text.csv/..");
            System.out.println("original path - " + path);
            System.out.println("normalized path - " + path.normalize());
        }

        Logger.printMessage("normalize() - part2");
        {
            Path path = Path.of("./././home/../home/joy/car/../.");
            System.out.println("original path - " + path);
            System.out.println("normalized path - " + path.normalize());
        }

        Logger.printMessage("resolve() - part1 - relative paths");
        {
            Path path1 = Path.of("box/inner/home/text.csv");
            Path path2 = Path.of("./../");

            System.out.println("path1 = " + path1);
            System.out.println("path2 = " + path2);

            System.out.println(path1.resolve(path2).normalize());
            System.out.println(path2.resolve(path1).normalize());
        }

        Logger.printMessage("resolve() - part2 - absolute path");
        {
            Path path1 = Path.of("box/inner/home/text.csv");
            Path path2 = Path.of("D:/");

            System.out.println("path1 = " + path1);
            System.out.println("path2 = " + path2);

            System.out.println(path1.resolve(path2).normalize());
            System.out.println(path2.resolve(path1).normalize());
        }

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. File: base methods");

        Logger.printMessage("File with file file.txt", Colors.YELLOW);
        {
            File file = new File(base.toFile(), "file/file.txt");
            extracted(file);
        }

        Logger.printMessage("File with file directory", Colors.YELLOW);
        {
            File file = new File(base.toString(), "file");
            extracted(file);
        }

        Logger.printMessage("Some methods:", Colors.YELLOW);
        {
            File file = new File(base.toFile(), "file");
            System.out.println("file.getPath() = " + file.getPath());
            System.out.println("list of files: " + Arrays.toString(file.list()));
        }

        printSectionEnding();
    }

    private static void extracted(File file) {
        System.out.println("file = " + file);
        System.out.println("Path: " + file.getPath());
        System.out.println("File name: " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("File size: " + file.length());
        System.out.println("My parent: " + file.getParent());
        System.out.println("My parent's pathname: " + file.getParentFile());
        System.out.println("Exists: " + file.exists());
        System.out.println("is file: " + file.isFile());
        System.out.println("is directory: " + file.isDirectory());
        System.out.println("has absolute path: " + file.isAbsolute());
        long lastModified = file.lastModified();
        System.out.println("last modified: " + Instant.ofEpochMilli(lastModified).atZone(ZoneId.systemDefault()));
        System.out.println("File is readable: " + file.canRead());
        System.out.println("File is writable: " + file.canWrite());
        System.out.println("File is hidden: " + file.isHidden());
    }

    private static void program_3() {
        printSection("Program_3. File: rename(), create(), delete()");

        Logger.printMessage("rename()");
        {
            File file = new File(base.toFile(), "program_3/file.txt");
            readWriteInfo(file);

            File newFile = new File(base.toFile(), "program_3/fileRenamed.txt");
            if (file.renameTo(newFile))
                Logger.printMessage("Переименование прошло успешно", Colors.BLUE);

            newFile.renameTo(file);
        }

        Logger.printMessage("createNewFile(), setReadOnly()");
        {
            System.out.println("Время запуска программы: " + Instant.now().atZone(ZoneId.systemDefault()));

            File file = new File(base.toFile(), "program_3/file1.txt");
            if (file.exists())
                file.delete();

            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            readWriteInfo(file);

            file.setReadOnly();
            readWriteInfo(file);
        }

        Logger.printMessage("delete()");
        {
            File file = new File(base.toFile(), "program_3/file2.txt");

            try {
                if (file.createNewFile())
                    System.out.println("Создан файл: " + file.getName());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (file.delete())
                System.out.println("Удален файл: " + file.getName());

        }
        printSectionEnding();
    }

    private static void readWriteInfo(File file) {
        System.out.println("Файл - " + file.getName());
        System.out.println("is readable: " + file.canRead());
        System.out.println("is writable: " + file.canWrite());
        System.out.println("is hidden: " + file.isHidden());
        long lm = file.lastModified();
        System.out.println("last modified: " + Instant.ofEpochMilli(lm).atZone(ZoneId.systemDefault()));
    }

    private static void program_4() {
        printSection("Program_4. File: otherMethods");

        File file = new File(base.toFile(), "program_4/file.txt");

        if (file.exists())
            file.delete();

        try {
            file.createNewFile();
            System.out.println("Файл создан: " + file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File dir = new File(base.toFile(), "program_4");
        spaceInfo(dir);

        printSectionEnding();
    }

    private static void spaceInfo(final File dir) {
        System.out.println(dir.getTotalSpace() / 1024 / 1024 / 1024);
        System.out.println(dir.getUsableSpace() / 1024 / 1024 / 1024);
        System.out.println(dir.getFreeSpace() / 1024 / 1024 / 1024);
        System.out.println((dir.getTotalSpace() - dir.getFreeSpace()) / 1024 / 1024 / 1024);
    }

    private static void program_5() {
        printSection("Program_5. InputStream, FileInputStream");

        File file0 = new File(base.toFile(), "program_5/file0.txt");

        try (InputStream input0 = new FileInputStream(file0)) {
            System.out.println("Размер файла в байтах: " + file0.length());

            Logger.printMessage("skip()");
            {
                int len0;
                System.out.println("Доступно байтов: " + (len0 = input0.available()));

                input0.skip(7);
                System.out.println("Пропустим 7 байтов, доступно: " + (len0 = input0.available()));
            }

            Logger.printMessage("read()");
            {
                int read1 = 5;
                System.out.println("Прочитаем байтов: " + read1);
                for (int i = 0; i < read1; i++)
                    System.out.print(input0.read() + " ");
                System.out.println("\nОсталось байт: " + input0.available());
            }

            Logger.printMessage("read(byte[] b)");
            {
                byte[] read2 = new byte[4];
                System.out.println("Прочитаем в буффер размером: " + read2.length);
                int len2 = input0.read(read2);
                System.out.println("Количество прочитанных байт: " + len2);
                System.out.println(Arrays.toString(read2));
                System.out.println("Осталось байт: " + input0.available());
            }

            Logger.printMessage("read(byte[] b, int  off, int len)");
            {
                byte[] read3 = new byte[16];
                System.out.println("Прочитаем в буффер размером: " + read3.length);
                int len3 = input0.read(read3, 2, 14);
                System.out.println("Количество прочитанных байт: " + len3);
                System.out.println(Arrays.toString(read3));
                System.out.println("Осталось байт: " + input0.available());
            }

            Logger.printMessage("Чтение пустого потока");
            {
                System.out.println("Доступно байт: " + input0.available());
                System.out.println(input0.read());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Проблемы в процессе");
        }

        printSectionEnding();
    }

    private static void program_6() {
        printSection("Program_6. InputStream, FileInputStream");

        File file0 = new File(base.toFile(), "program_6/file0.txt");

        try (InputStream input0 = new FileInputStream(file0)) {
            System.out.println("Размер файла в байтах: " + file0.length());
            System.out.println("Доступно байтов: " + input0.available());

            Logger.printMessage("readNBytes()");
            {
                byte[] read0 = input0.readNBytes(10);
                System.out.println("Количество считанных байт равно размеру массива: " + read0.length);
            }

            Logger.printMessage("readNBytes(byte[] b, int off, int len)");
            {
                byte[] read1 = new byte[5];
                int len1 = input0.readNBytes(read1, 0, 5);
                System.out.println("Считано байт: " + len1);
            }

            Logger.printMessage("readAllBytes");
            {
                byte[] read2 = input0.readAllBytes();
                System.out.println("Считано оставшихся байт: " + read2.length);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Проблемы в процессе");
        }

        printSectionEnding();
    }

    private static void program_7() {
        printSection("Program_7. InputStream, FileInputStream, порционное чтение");

        File file0 = new File(base.toFile(), "program_7/file0.txt");

        try (InputStream input0 = new FileInputStream(file0)) {
            System.out.println("Размер файла в байтах: " + file0.length());
            System.out.println("Доступно байтов: " + input0.available());

            byte[] buffer = new byte[10];
            int len;

            while ((len = input0.read(buffer)) != -1) {
                if (len == 10)
                    System.out.println(Arrays.toString(buffer));

                System.out.print("[");
                for (int i = 0; i < len; i++) {
                    System.out.print(buffer[i] + ", ");
                }
                System.out.println("\b]");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Проблемы в процессе");
        }

        printSectionEnding();
    }

    private static void program_8() {
        printSection("Program_8. OutputStream, FileOutputStream");

        File file1 = new File(base.toFile(), "program_8/file1.txt");
        File file2 = new File(base.toFile(), "program_8/file2.txt");
        File file3 = new File(base.toFile(), "program_8/file3.txt");

        if (file1.length() > 3)
            file1.delete();

        try (OutputStream output1 = new FileOutputStream(file1, true);
             OutputStream output2 = new FileOutputStream(file2);
             OutputStream output3 = new FileOutputStream(file3)) {

            String original = "This abstract class is the superclass of all classes";
            byte[] buffer = original.getBytes();

            output1.write(buffer[0]);
            output2.write(buffer);
            output3.write(buffer, buffer.length / 2, buffer.length / 2);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Проблемы в процессе");
        }

        printSectionEnding();
    }

    private static void program_9() {
        printSection("Program_9. InputStream: transferTo()");

        File from = new File(base.toFile(), "program_9/from.txt");
        File to = new File(base.toFile(), "program_9/to.txt");

//        Запрещает запись в файл
//        to.setReadOnly();

        try (InputStream input = new FileInputStream(from);
             OutputStream output = new FileOutputStream(to, false)) {

            long bytes = input.transferTo(output);
            System.out.println("Перемещено байт: " + bytes);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Проблемы в процессе");
        }

        printSectionEnding();
    }

    private static void program_10() {
        printSection("Program_10. InputStream, ByteArrayInputStream");

        String alphabet = "абвгде";
        System.out.println("Исходная строка длинной 6 символов: " + alphabet);
        byte[] letters = alphabet.getBytes();
        System.out.println("Массив байт размером: " + letters.length);

        File file1 = new File(base.toFile(), "program_10/file1.txt");

        try (
                InputStream input1 = new ByteArrayInputStream(letters);
                InputStream input2 = new ByteArrayInputStream(letters, 4, 9);
                InputStream input3 = new ByteArrayInputStream(letters);
                OutputStream output3 = new FileOutputStream(file1)) {

            input3.skip(6);
            System.out.println(Arrays.toString(input3.readAllBytes()));

            input3.reset();
            System.out.println(Arrays.toString(input3.readAllBytes()));

            input3.reset();
            input3.transferTo(output3);

            String str1 = new String(input1.readAllBytes());
            System.out.println(str1);

            String str2 = new String(input2.readAllBytes());
            System.out.println(str2);
        } catch (
                FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (
                IOException e) {
            System.out.println("Проблемы в процессе");
        }

        printSectionEnding();
    }

    private static void program_11() {
        printSection("Program_11. OutputStream, ByteArrayOutputStream");

        File file1 = new File(base.toFile(), "program_11/file1.txt");

        try (ByteArrayOutputStream output1 = new ByteArrayOutputStream(10);
             FileOutputStream output2 = new FileOutputStream(file1)) {

            for (int i = 0; i < 20; ++i) {
                output1.write(100);
            }

            System.out.println(output1);
            System.out.println(output1.size());

//            output1.writeTo(output1);
            output1.writeTo(output2);

        } catch (
                FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (
                IOException e) {
            System.out.println("Проблемы в процессе");
        }

        printSectionEnding();
    }

    private static void program_12() {
        printSection("Program_12. InputStream, FilterInputStream, BufferedInputStream");



        printSectionEnding();
    }

    private static void program_20() {
        printSection("Program_20. Test");

        File file1 = new File(base.toFile(), "program_20/file1.txt");

        try (FileInputStream input1 = new FileInputStream(file1);
             FileOutputStream output2 = new FileOutputStream(file1)) {

            byte[] bytes = input1.readAllBytes();
            System.out.println(Arrays.toString(bytes));

            output2.write(bytes);

        } catch (
                FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (
                IOException e) {
            System.out.println("Проблемы в процессе");
        }

        printSectionEnding();
    }
}

























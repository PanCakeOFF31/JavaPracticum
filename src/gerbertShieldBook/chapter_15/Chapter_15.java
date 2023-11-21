package gerbertShieldBook.chapter_15;

import java.io.*;

import static helpers.Helpers.*;

// the title of a chapter
public class Chapter_15 {
    public static void chapter_15() {
        printArticle("Chapter 15. I/O");

//        program_1();

//        program_2();

//        program_3();

//        program_4();

//        program_5();

//        program_6();

//        program_7();

//        program_8();

//        program_9();

//        program_10();

//        asserts
        program_11();

//        program_12();

        printArticleEnding();

    }

    private static void program_1() {
        printSection("Program_1. Character Stream. Reading characters: read()");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            char character = (char) bufferedReader.read();
            System.out.println(character);

            character = (char) bufferedReader.read();
            System.out.println(character);
        } catch (IOException ignored) {

        }

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. Character Stream. Reading Strings: readLine()");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = bufferedReader.readLine();
            System.out.println(str);
        } catch (IOException ignored) {

        }

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. PrintStream. Writing byte: write()");

//        write() записывает байт
        System.out.write(0b1111_1111_0011_0011);
        System.out.write(0b1111_1111_1111_1111_1111_0011_0011);
        System.out.write('\n');

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. PrintWriter Class. Writing: print(), println()");

        PrintWriter printWriter = new PrintWriter(System.out, false);

        printWriter.print("Maxim");
        printWriter.print("Max");
        printWriter.println("Long string");

        printWriter.close();

        printSectionEnding();
    }

    private static void program_5() {
        printSection("Program_5. FileInputStream - Byte Stream");

        FileInputStream input = null;

        try {
            input = new FileInputStream("src/files/GerbertShieldProgram_5.txt");
            byte byteStrem;
            while (true) {
                byteStrem = (byte) input.read();
                if (byteStrem == -1) {
                    break;
                }
                System.out.print((char) byteStrem);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("input output exception after opening");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    System.out.println("Ошибка при закрытии фалйа");
                }
            }
        }

        printSectionEnding();
    }

    private static void program_6() {
        printSection("Program_6. FileInputStream - Byte Stream");

        String path = "src/files/GerbertShieldProgram_5.txt";
        FileInputStream input = null;

        try {
            input = new FileInputStream(path);
            int byteStrem;
            while (true) {
                byteStrem = input.read();
                if (byteStrem == -1) {
                    break;
                }
                System.out.print((char) byteStrem);
            }

        } catch (IOException e) {
            System.out.println("input output exception after opening");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    System.out.println("Ошибка при закрытии фалйа");
                }
            }
        }

        printSectionEnding();
    }

    private static void program_7() {
        printSection("Program_7. FileOutputStream - Byte Stream");

        char[] name = new char[]{'M', 'a', 'x', 'i', 'm', '!'};

        String path = "src/files/GerbertShieldProgram_7.txt";

        FileOutputStream output = null;

        try {
            output = new FileOutputStream(path);
            for (char c : name) {
                output.write(c);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл с таким путем - \"" + path + "\" не найден");
        } catch (IOException e) {
            System.out.println("Возникли проблемы в процессе записи");
        } finally {
            if (output != null) {
                try {
                    output.close();
                    System.out.println("В файла успешно записаны данные!");
                } catch (IOException e) {
                    System.out.println("Ошибка в процессе закрытия файла");
                }
            }
        }


        printSectionEnding();
    }

    private static void program_8() {
        printSection("Program_8. Copying a file");

        String source = "src/files/GerbertShieldProgram_8_1.txt";
        String destination = "src/files/GerbertShieldProgram_8_2.txt";

        FileInputStream input = null;
        FileOutputStream output = null;

        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(destination);

            int tempByte;
            while (true) {
                tempByte = input.read();

                if (tempByte == -1) break;

                output.write(tempByte);
            }
        } catch (IOException e) {
            System.out.println("Возникли проблемы в процессы чтения-записи");
        } finally {
            if (input != null) {
                try {
                    input.close();
                    System.out.println("Из файла успешно считаны данные!");
                } catch (IOException e) {
                    System.out.println("Проблемы в процессе закрытия чтения");
                }
            }

            if (output != null) {
                try {
                    output.close();
                    System.out.println("В файла успешно записаны данные!");
                } catch (IOException e) {
                    System.out.println("Проблемы в процессе закрытия чтения");
                }
            }
        }


        printSectionEnding();
    }


    private static void program_9() {
        printSection("Program_9. try-with-resources. Refactoring Program_5");

        String path = "src/files/GerbertShieldProgram_5.txt";

        try (FileInputStream input = new FileInputStream(path)) {
            byte byteStrem;
            while (true) {
                byteStrem = (byte) input.read();
                if (byteStrem == -1) {
                    break;
                }
                System.out.print((char) byteStrem);
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } finally {

        }

        printSectionEnding();
    }

    private static void program_10() {
        printSection("Program_10. try-with-resources. Refactoring program 8");

        String source = "src/files/GerbertShieldProgram_8_1.txt";
        String destination = "src/files/GerbertShieldProgram_8_2.txt";

        try (FileInputStream input = new FileInputStream(source);
             FileOutputStream output = new FileOutputStream(destination)) {
            byte byteStream;

            while (true) {
                byteStream = (byte) input.read();

                if (byteStream == -1) break;

                output.write(byteStream);
            }

            System.out.println("Из файла успешно считаны данные!");
            System.out.println("В файла успешно записаны данные!");
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }


        printSectionEnding();
    }

    private static void program_11() {
        printSection("Program_11. Using assert condition");

        int testValue = 100;

        testValue = doSomething(testValue);
        testValue = doSomething(testValue);

        assert testValue > 35;
        assert false;

        System.out.println(testValue);

        printSectionEnding();
    }

    private static int doSomething(int value) {
        return value = value/2;
    }

    private static void program_12() {
        printSection("Program_12. ");


        printSectionEnding();
    }


    /*private static void program_*() {
        printSection("");
        printSectionEnding();
    }*/

}



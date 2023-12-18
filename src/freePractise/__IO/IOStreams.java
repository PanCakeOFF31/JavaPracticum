package freePractise.__IO;

import helpers.coloredString.Logger;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import static helpers.Helpers.*;

public class IOStreams {
    public static void ioStreams() {
        printArticle("IOStreams");

//        get the file separator
        program_1();

//        Construct a file path
        program_2();

        program_3();
//        program_4();
//        program_5();
//        program_6();
//        program_7();
//        program_8();
//        program_9();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. Get the file separator");

        String fileSeparator = File.separator;
        char fileSeparatorChar = File.separatorChar;
        String fileSeparatorSystem = FileSystems.getDefault().getSeparator();

        System.out.println("fileSeparator = " + fileSeparator);
        System.out.println("fileSeparatorChar = " + fileSeparatorChar);
        System.out.println("fileSeparatorSystem = " + fileSeparatorSystem);

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. Construct a file path");

        String dir1 = "user";
        String dir2 = "photo";
        String dir3 = "summer";
        String file1 = "myPhotoOnTheBeach";

        Logger.printMessage("Path");
        {
            Path path1 = Path.of(dir1, dir2, dir3, file1);
            Path path2 = Paths.get(dir1, dir2, dir3, file1);
            Path path3 = Path.of("user\\photo\\summer\\myPhotoOnTheBeach");
            Path path4 = Path.of("user/photo/summer/myPhotoOnTheBeach");

            System.out.println("path1 = " + path1);
            System.out.println("path2 = " + path2);
            System.out.println("path3 = " + path3);
            System.out.println("path4 = " + path4);

            System.out.println(path1.equals(path2));
        }

        Logger.printMessage("File");
        {
            File filepath1 = new File("user\\photo\\summer\\myPhotoOnTheBeach");
            File filepath2 = new File("user/photo/summer/myPhotoOnTheBeach");

            System.out.println("filepath1 = " + filepath1);
            System.out.println("filepath2 = " + filepath2);

            System.out.println(filepath1.equals(filepath2));
        }


        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. ");

        System.out.println("File.pathSeparator = " + File.pathSeparator);

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. ");

        Path path1 = Path.of("user\\photo\\summer\\sun.jpg");
        Path path2 = Path.of("user/photo/summer/sun.jpg");

        System.out.println("path1 = " + path1);
        System.out.println("path2 = " + path2);

        printSectionEnding();
    }
}

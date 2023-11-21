package freePractise.textBlock;

import static helpers.Helpers.*;

public class TextBlock {
    public static void textBlock() {
        printArticle("text block");

        String block = """
                 Maxim
                           Blinov \
                 - PanCakeOFF""";

        System.out.println(block);


        String part1 = "Maxim";
        String part2 = "Blinov";
        String part3 = "Pan-Cake-OFF";


        printArticleEnding();
    }
}

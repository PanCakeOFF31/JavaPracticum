package yandexPracticum.javaCoreContinuation.theme_12.lesson_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Lesson_2 {
    public static void lesson_2() {
        printSection("Lesson_2. ");

        printSectionEnding();
    }
}

class BookEditor {

//    private HeaderDecorator headerDecorator;
//    private List<LineProcessor> lineProcessors = new ArrayList<>();

    public static void main(String[] args) {
        BookEditor bookEditor = new BookEditor();
//
//        bookEditor.setHeaderDecorator(new ToUpperCaseHeaderDecorator());
//        bookEditor.addLineProcessor(new CapitalizeFirstLetterProcessor());

        List<String> content = Arrays.asList(
                "Приключения Java-программиста",
                "История началась рано утром, ",
                "когда программист вышел из дома, ",
                "решив выпить утренний кофе."
        );

        List<String> resultContent = bookEditor.processText(content);
        System.out.println(resultContent);
    }

    public List<String> processText(List<String> sourceText) {
        List<String> resultText = new ArrayList<>();

//        String sourceHeader = sourceText.get(0);
//        String decoratedHeader = sourceHeader.toUpperCase() + "\n";
//        resultText.add(decoratedHeader);

        resultText.add(sourceText.stream().findFirst().orElse("").toUpperCase() + "\n");

        List<String> temp = sourceText.stream()
                .skip(1)
                .map(line -> line.substring(0, 1).toUpperCase() + line.substring(1) + '\n')
                .collect(Collectors.toList());


        resultText.addAll(temp);

        return resultText;
    }

//    public void setHeaderDecorator(HeaderDecorator headerDecorator) {
//        this.headerDecorator = headerDecorator;
//    }
//
//    public void addLineProcessor(LineProcessor lineProcessor) {
//        this.lineProcessors.add(lineProcessor);
//    }
}

//interface HeaderDecorator {
//    String decorate(String header);
//}
//
//interface LineProcessor {
//    String processLine(String line);
//}
//
//class ToUpperCaseHeaderDecorator implements HeaderDecorator {
//    @Override
//    public String decorate(String header) {
//        return header.toUpperCase() + "\n";
//    }
//}
//
//class CapitalizeFirstLetterProcessor implements LineProcessor {
//    @Override
//    public String processLine(String line) {
//        return line.substring(0, 1).toUpperCase() + line.substring(1);
//    }
//}
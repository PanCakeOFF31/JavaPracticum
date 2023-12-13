package freePractise.regex;

import helpers.coloredString.ColoredString;
import helpers.coloredString.Colors;
import helpers.coloredString.Logger;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static helpers.Helpers.*;

public class Regex {
    private static String input1 = "Мы лЮбим животных и стараемся поддерживать тех из них, кому не посчастливилось иметь ласковых хозяев и тёплый кров";
    private static String input2 = "Lorem ipsum Dolor sit Amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    private static String input3 = "Противоположная точка зрения подразумевает, что реплицированные с зарубежных источников, современные исследования и по сей день остаются уделом либералов, которые жаждут быть преданы социально-демократической анафеме. Для современного мира разбавленное изрядной долей эмпатии, рациональное мышление не оставляет шанса для вывода текущих активов. И нет сомнений, что диаграммы связей могут быть ограничены исключительно образом мышления. Мы вынуждены отталкиваться от того, что социально-экономическое развитие играет важную роль в формировании прогресса профессионального сообщества. Задача организации, в особенности же базовый вектор развития предполагает независимые способы реализации новых принципов формирования материально-технической и кадровой базы. Есть над чем задуматься: непосредственные участники технического прогресса, вне зависимости от их уровня, должны быть представлены в исключительно положительном свете. Мы вынуждены отталкиваться от того, что современная методология разработки, а также свежий взгляд на привычные вещи — безусловно открывает новые горизонты для новых предложений. Ясность нашей позиции очевидна: современная методология разработки влечет за собой процесс внедрения и модернизации своевременного выполнения сверхзадачи.";


    public static void regex() {
        printArticle("regular expression");

//        simple examples
//        program_1();
//        program_2();
//        program_3();

//        region() - границы поиска соответствия в строке input
//        program_4();

//        start(), end() - начало и конец индекса строки последнего найденного соответствия
//        program_5();

//        group() - подстроку которой соответствует шаблон
//        program_6();

//        usePattern() - использовать другой шаблон в Matcher
//        program_7();

//        replaceAll() - заменить все соответствия шаблону на другую строку
//        program_8();

//        word bound
//        program_9();

        printArticleEnding();
    }

    public static void regexOracle() {
        printArticle("Oracle learning. Regular expressions.");

//        String literals
//        program_50();

//        Character Classes
//        program_51();

//        Character Classes: numbers
//        program_52();

//        Predefined Character Classes
//        program_53();

//        Quantifiers
//        1) Greedy:
//        1.1) Empty string
//        program_54();
//        1.2) One character string
//        program_55();
//        1.3) The letter five times in a raw
//        program_56();
//        1.4) The special raw
//        program_57();
//        1.5) {n} - Exactly n number if times
//        program_58();
//        1.6) {n,} - At least n times
//        program_59();
//        1.7) {n,m} - At least n times but not more than m times
//        program_60();
//        1.8) Capturing group with quantifiers
//        program_61();
//        1.9) Character classes with quantifiers
//        program_62();
//        2) Difference among: greedy, reluctant, possessive
//        program_65();

//        Boundary Matchers
//        program_70();
//        program_71();
//        program_72();
//        program_73();

//        program_75();
//        Using split()
//        program_76();
//        program_77();
//        program_78();
//        program_79();

//        Pattern's methods
        program_80();

//        Matcher's methods
        program_82();
//        program_83();



        printArticleEnding();
    }

    private static void printAllMatcher(Matcher matcher) {
        Logger.printMessage("Matcher:");
        matcher.reset();

        int counter = 0;

        System.out.println("The matcher's region - [" + matcher.regionStart() + ";" + matcher.regionEnd() + ")");

        ColoredString pattern = new ColoredString(matcher.pattern().toString(), Colors.PURPLE);
        System.out.println("Pattern - " + pattern);

        while (matcher.find()) {
            ColoredString start = new ColoredString(String.valueOf(matcher.start()), Colors.BLACK);
            ColoredString end = new ColoredString(String.valueOf(matcher.end()), Colors.BLACK);
            ColoredString result = new ColoredString(matcher.group(), Colors.BLUE);

            System.out.println("The text " + result + " starting at index " + start + " and ending at index " + end);

            counter++;
        }

        if (counter == 0) {
            Logger.printWarningMessage("Совпадения вообще не найдено");
        }

//        if (!matcher.find() && counter > 0) {
//            Logger.printMarkMessage("Совпадения закончились");
//        }
    }

    private static void checkRegex(String input, String... regex) {
        Pattern pattern;
        Matcher matcher;

        for (String reg : regex) {
            pattern = Pattern.compile(reg);
            matcher = pattern.matcher(input);
            printAllMatcher(matcher);
        }
    }

    public static void checkInputs(String regex, String... input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        for (String inp : input) {
            System.out.println("Строка - \"" + inp + "\"");
            System.out.println("Длина строки - " + inp.length());
            matcher = pattern.matcher(inp);
            printAllMatcher(matcher);
        }
    }

    private static void program_50() {
        printSection("Program_50. String literals");

        String regex = "foo";
        String input = "\"foo\"       \"foo\"foo";

        System.out.println(input);
        System.out.println("input.length() = " + input.length());

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        printAllMatcher(matcher);

        String regex1 = "\"foo\"";
        matcher.reset();
        matcher.usePattern(Pattern.compile(regex1));
        printAllMatcher(matcher);

        String regex2 = "oo";
        matcher.reset();
        matcher.usePattern(Pattern.compile(regex2));
        printAllMatcher(matcher);

        String regex3 = "o";
        matcher.reset();
        matcher.usePattern(Pattern.compile(regex3));
        printAllMatcher(matcher);

        printSectionEnding();
    }

    private static void program_51() {
        printSection("Program_51. Character Classes");

//        Любой из символов
        String regex = "[bcr]at";
        String input = "Bat, cat, rat, Mat, Dat, hat.";

        System.out.println("Строка - \"" + input + "\"");
        System.out.println("Длина строки - " + input.length());

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        printAllMatcher(matcher);

//        Любой из
        String regex1 = "[bcrBCR]at";
        matcher.reset();
        matcher.usePattern(Pattern.compile(regex1));
        printAllMatcher(matcher);

//        Исключение - exception или отрицание. Любые символы кроме указанного диапазона
        String regex2 = "[^d-z]at";
        matcher.reset();
        matcher.usePattern(Pattern.compile(regex2));
        printAllMatcher(matcher);

//        Range - диапазон символов
//        два диапазона через или
        String regex3 = "[a-zA-Z]at";
        matcher.reset();
        matcher.usePattern(Pattern.compile(regex3));
        printAllMatcher(matcher);

//        Union - объединение диапазонов
        String regex4 = "[A-dr-t]at";
        matcher.reset();
        matcher.usePattern(Pattern.compile(regex4));
        printAllMatcher(matcher);

//        Пересечение диапазонов - intersaction
        String regex5 = "[A-x&&B-z]at";
        matcher.reset();
        matcher.usePattern(Pattern.compile(regex5));
        printAllMatcher(matcher);

//          Вычитание - subtraction
        String regex6 = "[[A-z]&&[^B-F]]at";
        matcher.reset();
        matcher.usePattern(Pattern.compile(regex6));
        printAllMatcher(matcher);

        printSectionEnding();
    }


    private static void program_52() {
        printSection("Program_52. Character Classes: numbers");

        String regex = "[\\w&&\\D]oo\\d";
        String input = "Foo1, foo2, Foo3, foo4, 5oo5, fooo5, fo5, ofo5oo5, foo6, foo7, 8oof.";

        System.out.println("Строка - \"" + input + "\"");
        System.out.println("Длина строки - " + input.length());

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        printAllMatcher(matcher);

        String regex1 = "[fF]oo[4-9]";
        matcher.usePattern(Pattern.compile(regex1));
        printAllMatcher(matcher);

        String regex2 = "[Ff]oo[1-9&&[^456789]]";
        matcher.usePattern(Pattern.compile(regex2));
        printAllMatcher(matcher);

        String regex3 = "[Ff]oo\\d";
        matcher.usePattern(Pattern.compile(regex3));
        printAllMatcher(matcher);

        String regex4 = "[A-z_0-5]oo\\d";
        matcher.usePattern(Pattern.compile(regex4));
        printAllMatcher(matcher);

        printSectionEnding();
    }

    private static void program_53() {
        printSection("Program_53. Character Classes: predefined character classes");

        String regex = "\\d";
        String input = "! \"/\\№\t\n120.,4\f9\r;%:?*()_+max";

        System.out.println("Строка - \"" + input + "\"");
        System.out.println("Длина строки - " + input.length());

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        printAllMatcher(matcher);

        String regex1 = ".";
        matcher.usePattern(Pattern.compile(regex1));
        printAllMatcher(matcher);

        String regex2 = "\\s";
        matcher.usePattern(Pattern.compile(regex2));
        printAllMatcher(matcher);

        String regex3 = "\\S";
        matcher.usePattern(Pattern.compile(regex3));
        printAllMatcher(matcher);

//        word character - [a-zA-z_0-9]
        String regex4 = "\\w";
        matcher.usePattern(Pattern.compile(regex4));
        printAllMatcher(matcher);

        String regex5 = "\\W";
        matcher.usePattern(Pattern.compile(regex5));
        printAllMatcher(matcher);

        String regex6 = "[\\W&&\\S]";
        matcher.usePattern(Pattern.compile(regex6));
        printAllMatcher(matcher);

//        horizontal whitespaces
        String regex7 = "\\h";
        matcher.usePattern(Pattern.compile(regex7));
        printAllMatcher(matcher);

        printSectionEnding();
    }


    private static void program_54() {
        printSection("Program_54. Quantifiers: Greedy quantifiers. Empty String");

//        [0;1]
        String regex = "a?";
        String input = "";

        System.out.println("Строка - \"" + input + "\"");
        System.out.println("Длина строки - " + input.length());

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        printAllMatcher(matcher);

//        [0;+]
        String regex1 = "a*";
        matcher.usePattern(Pattern.compile(regex1));
        printAllMatcher(matcher);

//        [1;+]
        String regex2 = "a+";
        matcher.usePattern(Pattern.compile(regex2));
        printAllMatcher(matcher);

        printSectionEnding();
    }

    private static void program_55() {
        printSection("Program_55. Quantifiers: Greedy quantifiers. One character string");

        String input = "a";
        System.out.println("Строка - \"" + input + "\"");
        System.out.println("Длина строки - " + input.length());

        String regex = "a?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        printAllMatcher(matcher);

        String regex1 = "a*";
        matcher.usePattern(Pattern.compile(regex1));
        printAllMatcher(matcher);

        String regex2 = "a+";
        matcher.usePattern(Pattern.compile(regex2));
        printAllMatcher(matcher);

        printSectionEnding();
    }

    private static void program_56() {
        printSection("Program_56. Quantifiers: Greedy quantifiers. The letter five times in a row");

        String input = "aaaaa";

        System.out.println("Строка - \"" + input + "\"");
        System.out.println("Длина строки - " + input.length());

        String regex = "a?";
        String regex1 = "a*";
        String regex2 = "a+";
        String regex3 = "";
        String regex4 = "";
        String regex6 = "";

        checkRegex(input, regex, regex1, regex2);

        printSectionEnding();
    }

    private static void program_57() {
        printSection("Program_57. Quantifiers: The special raw");

        String input = "ababaaaab";

        System.out.println("Строка - \"" + input + "\"");
        System.out.println("Длина строки - " + input.length());

        String regex = "a?";
        String regex1 = "a*";
        String regex2 = "a+";
        String regex3 = "";
        String regex4 = "";
        String regex6 = "";

        checkRegex(input, regex, regex1, regex2);

        printSectionEnding();
    }

    private static void program_58() {
        printSection("Program_58. Quantifiers: {n} - exactly n number if times");

        String input = "a";
        String input1 = "aa";
        String input2 = "aaa";
        String input3 = "aaaa";
        String input4 = "aaaaaaaaa";

        System.out.println("Строка - \"" + input + "\"");
        System.out.println("Длина строки - " + input.length());

        String regex = "a{3}";
        checkInputs(regex, input, input1, input2, input3, input4);

        printSectionEnding();
    }

    private static void program_59() {
        printSection("Program_59. Quantifiers: {n,} - At least n times");

        String input = "a";
        String input1 = "aa";
        String input2 = "aaa";
        String input3 = "aaaa";
        String input4 = "aaaaaaaaa";
        String input5 = "ababaaaab";

        System.out.println("Строка - \"" + input + "\"");
        System.out.println("Длина строки - " + input.length());

        String regex = "a{2,}";
        checkInputs(regex, input, input1, input2, input3, input4, input5);


        printSectionEnding();
    }

    private static void program_60() {
        printSection("Program_60. Quantifiers: {n,m} - at least n but not more than m times ");

        String input = "a";
        String input1 = "aa";
        String input2 = "aaa";
        String input3 = "aaaa";
        String input4 = "aaaaaaaaa";
        String input5 = "ababaaaab";

        System.out.println("Строка - \"" + input + "\"");
        System.out.println("Длина строки - " + input.length());

        String regex = "a{2,4}";
        checkInputs(regex, input, input1, input2, input3, input4, input5);


        printSectionEnding();
    }

    private static void program_61() {
        printSection("Program_61. Capturing Groups with Quantifiers: ");

        String input = "do";
        String input1 = "dog";
        String input2 = "dogdoggod";
        String input3 = "dogdogdogdogdog";

        String regex = "(dog){2,4}";
        checkInputs(regex, input, input1, input2, input3);

        String regex1 = "dog{2,4}";
        checkInputs(regex1, input, input1, input2, input3);

        printSectionEnding();
    }

    private static void program_62() {
        printSection("Program_62. Character classes with Quantifiers: ");

        String input = "abccabaaaccbbbcabcccc";

        System.out.println("Строка - \"" + new ColoredString(input, Colors.BLACK) + "\"");
        System.out.println("Длина строки - " + input.length());

        String regex = "abc{3}";
        String regex1 = "ccc";
        String regex2 = "[ac]{3}";
        String regex3 = "";
        String regex4 = "";
        String regex6 = "";

        checkRegex(input, regex, regex1, regex2);

        printSectionEnding();
    }

    private static void program_70() {
        printSection("Program_70. Boundary Matchers");

        String input = "Doggies is a doggy dog style.";

        System.out.println("Строка - \"" + new ColoredString(input, Colors.BLACK) + "\"");
        System.out.println("Длина строки - " + input.length());

//        Содержит внутри строки
        String regex = "[Dd]og";
//        Начинается на
        String regex1 = "^[Dd]og.{1}";
//       Заканчивается на
        String regex2 = "(^[Dd]og\\s)|(^[Dd]og$)";
        String regex3 = "\\b[dD]og\\b";
        String regex4 = "\\b[Dd]og\\w*";
        String regex5 = "\\b[Dd]og\\B";

        checkRegex(input, regex, regex1, regex2, regex3, regex4, regex5);

        printSectionEnding();
    }

    private static void program_71() {
        printSection("Program_71. Boundary Matchers:");

        String input = "Catty cat cat,cat super-cats catting  tankcat cut abccatabc";

        System.out.println("Строка - \"" + new ColoredString(input, Colors.BLACK) + "\"");
        System.out.println("Длина строки - " + input.length());

        String regex = "\\b[Cc]at\\b";
        String regex1 = "[\\s+_[\\W&&[^-]]+]*[Cc]at[\\s+[\\W&&[^-]]+]*";
        String regex2 = "(^(C|c)at\\W)|(\\W*[Cc]at\\W)";
        String regex3 = "(\\bcat\\B)&&^(-cat\\B)";
        String regex4 = "(\\B|[\\W&&\\S])cat(\\B|[\\W&&\\S])";
        String regex5 = "\\Bcat\\B";

        checkRegex(input, regex, regex1, regex2, regex3, regex4, regex5);

        printSectionEnding();
    }

    private static void program_72() {
        printSection("Program_72. Boundary Matchers: ");

        String input = "RabbitRabbit";

        System.out.println("Строка - \"" + new ColoredString(input, Colors.BLACK) + "\"");
        System.out.println("Длина строки - " + input.length());

        String regex = "\\G[Rr]abbit";
        String regex1 = "";
        String regex2 = "";
        String regex3 = "";
        String regex4 = "";
        String regex5 = "";

        checkRegex(input, regex);

        printSectionEnding();
    }

    private static void program_73() {
        printSection("Program_73. Boundary Matchers: Слова длинной в 5 символов");

        String input = "";

        System.out.println("Строка - \"" + new ColoredString(input, Colors.BLACK) + "\"");
        System.out.println("Длина строки - " + input.length());

        String regex = "\\b[A-z]{5}\\b";
        String regex1 = "[\\s\\W]*[A-z]{5}[\\s]";
        String regex2 = "";
        String regex3 = "";
        String regex4 = "";
        String regex5 = "";

        checkRegex(input2, regex, regex1);

        printSectionEnding();
    }

    private static void program_75() {
        printSection("Program_75. Embedded Flag Expressions");

        String input = "FooFoOfoOfOO";

        System.out.println("Строка - \"" + new ColoredString(input, Colors.BLACK) + "\"");
        System.out.println("Длина строки - " + input.length());

        String regex = "(?i)foo";
        String regex1 = "";
        String regex2 = "";
        String regex3 = "";
        String regex4 = "";
        String regex5 = "";

        checkRegex(input, regex);

        printSectionEnding();
    }

    private static void program_76() {
        printSection("Program_76. Split Method of Pattern Class");

        final String input = "one:two:three:four:five";
        String regex = ":";

        Pattern pattern = Pattern.compile(regex);
        String[] items = pattern.split(input);

        System.out.println(Arrays.toString(items));

        printSectionEnding();
    }

    private static void program_77() {
        printSection("Program_77. Split Method of Pattern Class");

        final String input = "one, two_m-ax ,   three_min,  four_average, live";
        String regex = "[\\W&&[^-]]+";

        Pattern pattern = Pattern.compile(regex);
        String[] items = pattern.split(input);

        System.out.println(Arrays.toString(items));

        printSectionEnding();
    }

    private static void program_78() {
        printSection("Program_78. Split Method of Pattern Class");

        final String input = "one4two6three23four6five";
        String regex = "\\d+";

        Pattern pattern = Pattern.compile(regex);
        String[] items = pattern.split(input);

        System.out.println(Arrays.toString(items));

        printSectionEnding();
    }

    private static void program_79() {
        printSection("Program_79. Quote Method of Pattern Class");

        String regex = "[abc]+";
        Pattern pattern = Pattern.compile(regex);
        System.out.println(pattern.toString());

        String literalPattern = Pattern.quote("max");
        System.out.println(literalPattern);

        String input = "mAX NAX Maxmasd maximue asdmaxiaskldj";

        Matcher matcher = pattern.matcher(input);
        String result = matcher.replaceAll("XXX");

        System.out.println(result);

        checkRegex(input, literalPattern);

        printSectionEnding();
    }

    private static void program_80() {
        printSection("Program_80. Pattern methods: matches(), pattern(), flags()");

        String regex = "a{5}";
        String input = "avasmkvalkjfaaaaakl;kl";

        Pattern pattern = Pattern.compile(regex);

        System.out.println(pattern.pattern());
        System.out.println(pattern.toString());
        System.out.println(pattern.flags());
        System.out.println(Pattern.CASE_INSENSITIVE);

        boolean exists = Pattern.matches(regex, input);

        System.out.printf("Регулярное выражение %s присутствует в строке %s, %b\n", regex, input, exists);

        printSectionEnding();
    }

    private static void program_82() {
        printSection("Program_82. Matcher's methods: ");

        String regex = "aa{1}";
        String input = "aa aa aa aa";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

//        matches - сопоставляет целиком область поиска с регулярным выражением
        matcher.region(0, 2);
        System.out.println(matcher.matches());
        System.out.println(matcher.group());
        System.out.println(matcher.start());
        System.out.println(matcher.end());
        matcher.reset();

//        Ищет во всей области поиска хотя бы один раз и запоминает первое вхождение
        System.out.println(matcher.lookingAt());
        System.out.println(matcher.lookingAt());
        System.out.println(matcher.group());
        System.out.println(matcher.start());
        System.out.println(matcher.end());
        matcher.reset();

//        Ищет во всей области поиска, запоминается после вызова последнее вхождение, каждый раз смещается
        System.out.println(matcher.find());
        System.out.println(matcher.find());
        System.out.println(matcher.find());
        System.out.println(matcher.group());
        System.out.println(matcher.start());
        System.out.println(matcher.end());
        matcher.reset();

        printSectionEnding();
    }

    private static void program_83() {
        printSection("Program_83. Matcher's methods: ");

        String regex = "";
        String input = "";

        Pattern pattern = Pattern.compile(regex);

        printSectionEnding();
    }

    private static void program_1() {
        printSection("Program_1. Regular expressions: just example");

        Pattern pattern = Pattern.compile("[а-я]{2,4}");
        Matcher matcher = pattern.matcher(input1);

        System.out.println("pattern = " + pattern);

        while (matcher.find()) {
            System.out.println(input1.substring(matcher.start(), matcher.end()));
        }

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. Regular expressions: just example");

        Pattern pattern = Pattern.compile("\\s[А-я]{5}\\s");
        Matcher matcher = pattern.matcher(input1);

        System.out.println("pattern = " + pattern);

        while (matcher.find()) {
            System.out.println(input1.substring(matcher.start() + 1, matcher.end() - 1));
        }

        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. Regular expressions: just example");

        Pattern pattern = Pattern.compile("[А-яё]+");
        Matcher matcher = pattern.matcher(input1);

        System.out.println("pattern = " + pattern);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. Regular expressions: regionStart(), regionEnd(), region()");

        String regex = "[А-яё]+";
        Matcher matcher = Pattern.compile(regex).matcher(input1);
        int regionStart = matcher.regionStart();
        int regionEnd = matcher.regionEnd();

        System.out.println("regionStart = " + regionStart);
        System.out.println("regionEnd = " + regionEnd);

        matcher.region(0, 50);
        regionStart = matcher.regionStart();
        regionEnd = matcher.regionEnd();
        System.out.println("regionStart = " + regionStart);
        System.out.println("regionEnd = " + regionEnd);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        printSectionEnding();
    }

    private static void program_5() {
        printSection("Program_5. Regular expression: start(), end()");

        Matcher matcher = Pattern.compile("[A-z]{5}").matcher(input2);

        matcher.find();
        int start = matcher.start();
        int end = matcher.end();
        System.out.println("matcher.start() = " + start);
        System.out.println("matcher.end() = " + end);
        System.out.println(input2.substring(start, end));

        matcher.find();
        start = matcher.start();
        end = matcher.end();
        System.out.println("matcher.start() = " + start);
        System.out.println("matcher.end() = " + end);
        System.out.println(input2.substring(start, end));

        printSectionEnding();
    }

    private static void program_6() {
        printSection("Program_6. Regular expressions: group()");

        Matcher matcher = Pattern.compile("[A-z]{4}").matcher(input2);

        if (matcher.find()) {
            System.out.println("Я нашел соответствие шаблону в строке");
        }

        String matchedString = matcher.group();
        System.out.println("matchedString = " + matchedString);

        System.out.println("matcher = " + matcher);


        printSectionEnding();
    }

    private static void program_7() {
        printSection("Program_7. Regular expression: usePattern()");

        Matcher matcher = Pattern.compile("[a-dA-D][A-z]+").matcher(input2);
        System.out.println("matcher.pattern() = " + matcher.pattern());

        for (int i = 0; i < 10; i++) {
            matcher.find();
            System.out.println(matcher.group());
        }

        Logger.printMessage("Смена паттерна", Colors.GREEN);
        System.out.println("matcher.pattern() = " + matcher.pattern());
        matcher.usePattern(Pattern.compile("[A-z]{5,}+"));

        for (int i = 0; i < 10; i++) {
            matcher.find();
            System.out.println(matcher.group());
        }


        Logger.printMessage("Смена паттерна", Colors.GREEN);
        matcher.usePattern(Pattern.compile(" [f|p|r][A-z]+"));
        System.out.println("matcher.pattern() = " + matcher.pattern());

        while (matcher.find()) {
            System.out.println(matcher.group().trim());
        }


        printSectionEnding();
    }

    private static void program_8() {
        printSection("Program_8. Regular expressions: replaceAll()");

        Matcher matcher = Pattern.compile(" [абвгде][А-я]{4,}+").matcher(input3);

        while (matcher.find())
            System.out.println(matcher.group().trim());

        System.out.println(matcher.replaceAll(" ЗАМЕНА").substring(0, 400));

        printSectionEnding();
    }

    private static void program_9() {
        printSection("Program_9. ");

        Matcher matcher = Pattern.compile("\bточка\b").matcher(input3);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        printSectionEnding();
    }
}
































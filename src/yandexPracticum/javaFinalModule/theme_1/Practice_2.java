package yandexPracticum.javaFinalModule.theme_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Реализация рекурсивной раскопки списка
public class Practice_2 {
    public static final String STOP = "стоп!"; // остановить выполнение
    public static final String LEFT = "левее!"; // перешагнуть команду слева
    public static final String WALK = "шагай!"; // начать выполнение следующей команды
    public static final String RIGHT = "правее!"; // перешагнуть команду справа
    public static final String TURN = "обратно!"; // вернуться к предыдущей команде
    public static final String DIGG = "копай!"; // копать и перейти на следующую команду

    public static final List<String> MASTER_CHIEF_COMMANDS = Arrays.asList(
            WALK, WALK, WALK,
            DIGG, // новый тип команды для рекурсивного робота "Работяга 2.1"
            DIGG, WALK, DIGG, WALK, DIGG, WALK, DIGG, STOP);

    public static final List<List<Character>> LETTER_LIST_LIST = // проинициализируйте "список списков" символов
            new ArrayList<>(List.of(
                    Arrays.asList('ы', 'т', 'о', 'б', 'а', 'Р'),
                    Arrays.asList('й', 'ы', 'т', 'а', 'ч', 'о', 'п', 'е', 'н'),
                    Arrays.asList('.', 'й', 'а', 'р', 'к'),
                    Arrays.asList('а', 'д', 'е', 'б', 'о', ' ', 'о', 'Д'),
                    Arrays.asList('.', 'о', 'к', 'е', 'л', 'а', 'д')
            ));

    public static void main(String[] args) {
        try {
            doMyCommand(0);
            System.out.println("Всё исполнено в лучшем виде!");
        } catch (
                StackOverflowError err) {
            System.out.println("Робот зациклился, задание провалено!");
        }
    }

    private static void doMyCommand(int cmdIdx) {
        doMyCommandNow(-1, cmdIdx);
    }

    private static void doMyCommandNow(int prevCmdIdx, int cmdIdx) {
        String nextCommand = MASTER_CHIEF_COMMANDS.get(cmdIdx);
        System.out.println("Выполняю команду: " + nextCommand);
        switch (nextCommand) {
            case WALK:
                doMyCommandNow(cmdIdx, cmdIdx + 1);
                break;
            case DIGG:
                List<Character> characters = new ArrayList<>(LETTER_LIST_LIST.get(0));
                doDiggLetter(new StringBuilder(), characters, characters.size() - 1);
                LETTER_LIST_LIST.remove(0);
                doMyCommandNow(cmdIdx, cmdIdx + 1);
                break;
            case STOP:
                break;
            default:
                throw new RuntimeException("Нет такой команды!");
        }
    }

    private static void doDiggLetter(StringBuilder word, List<Character> characters, int index) {
        int size = characters.size();

        if (size == 0 || index == 0) {
            System.out.println(word.toString());
            word = null;
            return;
        }

        word.append(characters.get(index));
        characters.remove(index);

        doDiggLetter(word, characters, index - 1);
    }

}

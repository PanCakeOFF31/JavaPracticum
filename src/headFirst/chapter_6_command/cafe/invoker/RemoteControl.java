package headFirst.chapter_6_command.cafe.invoker;

import headFirst.chapter_6_command.cafe.command.Command;
import headFirst.chapter_6_command.cafe.command.NoCommand;
import helpers.coloredString.Colors;
import helpers.coloredString.Logger;
import lombok.Setter;

/**
 * Клиент - создает объекты-команды
 * Пульт - инициатор выполнения команды
 * Получатель - тот кто выполняет конкретные действия
 */
@Setter
public class RemoteControl {
    private final Command[] onCommands;
    private final Command[] offCommands;
    private Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }

        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        if (onCommand == null || offCommand == null || slot < 0 || slot > 6)
            throw new IllegalStateException();

        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        Logger.printMessage("Инициатор - ON", Colors.GREEN);
        System.out.println("Инициирована выполнение команды клиентом");

        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        Logger.printMessage("Инициатор - OFF", Colors.RED);
        System.out.println("Инициирована выполнение команды клиентом");

        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPushed() {
        Logger.printMessage("Инициатор - undo", Colors.RED);
        System.out.println("Инициирована выполнение отмены прошлой клиентом");

        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n-------------- Remote Control --------------\n");
        for (int i = 0; i < 7; i++) {
            String[] pathOn = onCommands[i].getClass().getName().split("\\.");
            String onName = pathOn[pathOn.length - 1];

            String[] pathOff = offCommands[i].getClass().getName().split("\\.");
            String offName = pathOff[pathOff.length - 1];


            builder.append("[slot ")
                    .append(i + 1)
                    .append("] ")
                    .append(onName)
                    .append(" ")
                    .append(offName)
                    .append("\n");
        }

        String[] undo = undoCommand.getClass().getName().split("\\.");
        String undoName = undo[undo.length - 1];

        builder.append("[Undo command] ")
                .append(undoName)
                .append("\n");

        return builder.toString();
    }
}

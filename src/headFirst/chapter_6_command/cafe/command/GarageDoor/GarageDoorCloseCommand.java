package headFirst.chapter_6_command.cafe.command.GarageDoor;

import headFirst.chapter_6_command.cafe.command.Command;
import headFirst.chapter_6_command.cafe.receiver.GarageDoor;
import helpers.coloredString.Colors;
import helpers.coloredString.Logger;

public class GarageDoorCloseCommand implements Command {
    private final GarageDoor garageDoor;

    public GarageDoorCloseCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        Logger.printMessage("Команда", Colors.BLUE);
        System.out.println("Команда опускания двери отправлена");

        garageDoor.down();
    }

    @Override
    public void undo() {
        Logger.printMessage("Команда", Colors.BLUE);
        System.out.println("Команда отмены опускания двери отправлена");

        garageDoor.up();
    }
}

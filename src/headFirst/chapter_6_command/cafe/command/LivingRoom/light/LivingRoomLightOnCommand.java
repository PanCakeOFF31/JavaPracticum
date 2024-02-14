package headFirst.chapter_6_command.cafe.command.LivingRoom.light;

import headFirst.chapter_6_command.cafe.command.Command;
import headFirst.chapter_6_command.cafe.receiver.LivingRoom;
import helpers.coloredString.Colors;
import helpers.coloredString.Logger;

public class LivingRoomLightOnCommand implements Command {
    private final LivingRoom livingRoom;

    public LivingRoomLightOnCommand(LivingRoom livingRoom) {
        this.livingRoom = livingRoom;
    }

    @Override
    public void execute() {
        Logger.printMessage("Команда", Colors.BLUE);
        System.out.println("Команда на включение света отправлена");

        livingRoom.lightOn();
    }

    @Override
    public void undo() {
        Logger.printMessage("Команда", Colors.BLUE);
        System.out.println("Команда отмены включения света");

        livingRoom.lightOff();
    }
}

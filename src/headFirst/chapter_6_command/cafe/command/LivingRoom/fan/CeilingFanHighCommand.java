package headFirst.chapter_6_command.cafe.command.LivingRoom.fan;

import headFirst.chapter_6_command.cafe.command.Command;
import headFirst.chapter_6_command.cafe.receiver.CeilingFan;
import helpers.coloredString.Colors;
import helpers.coloredString.Logger;

public class CeilingFanHighCommand implements Command {
    private final CeilingFan ceilingFan;
    private int prevSpeed;

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }


    @Override
    public void execute() {
        Logger.printMessage("Команда", Colors.BLUE);
        System.out.println("Команда на включение вентилятора скорость 3");

        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.highMode();
    }

    @Override
    public void undo() {
        Logger.printMessage("Команда", Colors.BLUE);
        System.out.println("Команда отмены скорости вентилятора 3");

        CeilingFanMode.setPrevSpeed(prevSpeed, ceilingFan);
    }
}

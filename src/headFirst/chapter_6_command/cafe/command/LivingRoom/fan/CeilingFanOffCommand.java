package headFirst.chapter_6_command.cafe.command.LivingRoom.fan;

import headFirst.chapter_6_command.cafe.command.Command;
import headFirst.chapter_6_command.cafe.receiver.CeilingFan;
import helpers.coloredString.Colors;
import helpers.coloredString.Logger;

public class CeilingFanOffCommand implements Command {
    private final CeilingFan ceilingFan;
    private int prevSpeed;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }


    @Override
    public void execute() {
        Logger.printMessage("Команда", Colors.BLUE);
        System.out.println("Команда на выключение вентилятора скорость 0");

        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.offMode();
    }

    @Override
    public void undo() {
        Logger.printMessage("Команда", Colors.BLUE);
        System.out.println("Команда отмены выключения вентилятора");

        CeilingFanMode.setPrevSpeed(prevSpeed, ceilingFan);
        System.out.println("Режим вентилятора: " + ceilingFan.getSpeed());
    }
}

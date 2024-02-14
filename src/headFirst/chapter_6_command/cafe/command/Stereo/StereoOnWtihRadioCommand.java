package headFirst.chapter_6_command.cafe.command.Stereo;

import headFirst.chapter_6_command.cafe.command.Command;
import headFirst.chapter_6_command.cafe.receiver.LivingRoom;
import headFirst.chapter_6_command.cafe.receiver.Stereo;
import helpers.coloredString.Colors;
import helpers.coloredString.Logger;

public class StereoOnWtihRadioCommand implements Command {
    private final Stereo stereo;

    public StereoOnWtihRadioCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        Logger.printMessage("Команда", Colors.BLUE);
        System.out.println("Команда на включение стерео в режиме радио");

        stereo.on();
        stereo.setVolume(15);
        stereo.setRadio();
    }

    @Override
    public void undo() {
        Logger.printMessage("Команда", Colors.BLUE);
        System.out.println("Команда отмены включения стерео в режиме радио");

        stereo.off();
    }
}

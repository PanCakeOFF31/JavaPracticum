package headFirst.chapter_6_command.cafe.command.Stereo;

import headFirst.chapter_6_command.cafe.command.Command;
import headFirst.chapter_6_command.cafe.receiver.Stereo;
import helpers.coloredString.Colors;
import helpers.coloredString.Logger;

public class StereoOffCommand implements Command {
    private final Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        Logger.printMessage("Команда", Colors.BLUE);
        System.out.println("Команда на выключение");

        stereo.off();
    }

    @Override
    public void undo() {
        Logger.printMessage("Команда", Colors.BLUE);
        System.out.println("Команда отмены выключения стерео");

        stereo.on();
        stereo.setVolume(15);
        stereo.setRadio();
    }
}

package headFirst.chapter_6_command.cafe.receiver;

import helpers.coloredString.Colors;
import helpers.coloredString.Logger;

public class GarageDoor {
    public void up() {
        Logger.printMessage("Получатель", Colors.BLUE);
        System.out.println("Дверь поднята");
    }

    public void down() {
        Logger.printMessage("Получатель", Colors.BLUE);
        System.out.println("Дверь опущена");
    }

    public void stop() {

    }

    public void lightOn() {

    }

    public void lightOff() {

    }
}

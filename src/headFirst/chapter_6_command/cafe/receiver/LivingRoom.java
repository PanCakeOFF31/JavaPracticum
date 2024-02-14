package headFirst.chapter_6_command.cafe.receiver;

import helpers.coloredString.Colors;
import helpers.coloredString.Logger;

public class LivingRoom {
    public void lightOn() {
        Logger.printMessage("Получатель", Colors.BLUE);
        System.out.println("Свет включен");
    }

    public void lightOff() {
        Logger.printMessage("Получатель", Colors.BLUE);
        System.out.println("Свет выключен");
    }
}

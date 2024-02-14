package headFirst.chapter_6_command.cafe.receiver;

import helpers.coloredString.Colors;
import helpers.coloredString.Logger;

public class Stereo {
    private int volume;

    public void on() {
        Logger.printMessage("Получатель", Colors.BLUE);
        System.out.println("Стерео включен");
    }

    public void off() {
        Logger.printMessage("Получатель", Colors.BLUE);
        System.out.println("Стерео выключено");
    }

    public void setCD() {
        Logger.printMessage("Получатель", Colors.BLUE);
        System.out.println("Установлен CD диск");
    }

    public void setDVD() {
        Logger.printMessage("Получатель", Colors.BLUE);
        System.out.println("Установлен DVD диск");
    }

    public void setRadio() {
        Logger.printMessage("Получатель", Colors.BLUE);
        System.out.println("Включено радио");
    }

    public void setVolume(int volume) {
        this.volume = volume;

        Logger.printMessage("Получатель", Colors.BLUE);
        System.out.println("Громкость установлена на " + this.volume);
    }
}

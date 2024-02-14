package headFirst.chapter_6_command.cafe.receiver;

import helpers.coloredString.Colors;
import helpers.coloredString.Logger;
import lombok.Getter;

@Getter
public class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    String location;
    private int speed;

    public CeilingFan(String location) {
        this.location = location;
    }

    public void highMode() {
        speed = HIGH;
    }

    public void mediumMode() {
        speed = MEDIUM;
    }

    public void lowMode() {
        speed = LOW;
    }
    public void offMode() {
        speed = OFF;
    }

}

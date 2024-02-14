package headFirst.chapter_6_command.cafe.command.LivingRoom.fan;

import headFirst.chapter_6_command.cafe.receiver.CeilingFan;

public class CeilingFanMode {
    public static void setPrevSpeed(int prevSpeed, CeilingFan fan) {
        switch (prevSpeed) {
            case CeilingFan.HIGH -> fan.highMode();
            case CeilingFan.MEDIUM -> fan.mediumMode();
            case CeilingFan.LOW -> fan.lowMode();
            case CeilingFan.OFF -> fan.offMode();
        }
    }
}

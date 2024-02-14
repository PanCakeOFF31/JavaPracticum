package headFirst.chapter_6_command;

import headFirst.chapter_6_command.cafe.command.Command;
import headFirst.chapter_6_command.cafe.command.GarageDoor.GarageDoorCloseCommand;
import headFirst.chapter_6_command.cafe.command.GarageDoor.GarageDoorOpenCommand;
import headFirst.chapter_6_command.cafe.command.LivingRoom.fan.CeilingFanHighCommand;
import headFirst.chapter_6_command.cafe.command.LivingRoom.fan.CeilingFanLowCommand;
import headFirst.chapter_6_command.cafe.command.LivingRoom.fan.CeilingFanMediumCommand;
import headFirst.chapter_6_command.cafe.command.LivingRoom.fan.CeilingFanOffCommand;
import headFirst.chapter_6_command.cafe.command.LivingRoom.light.LivingRoomLightOnCommand;
import headFirst.chapter_6_command.cafe.command.LivingRoom.light.LivingRoomLightOffCommand;
import headFirst.chapter_6_command.cafe.command.Stereo.StereoOffCommand;
import headFirst.chapter_6_command.cafe.command.Stereo.StereoOnWtihRadioCommand;
import headFirst.chapter_6_command.cafe.command.macro.MacroCommand;
import headFirst.chapter_6_command.cafe.invoker.RemoteControl;
import headFirst.chapter_6_command.cafe.receiver.CeilingFan;
import headFirst.chapter_6_command.cafe.receiver.GarageDoor;
import headFirst.chapter_6_command.cafe.receiver.LivingRoom;
import headFirst.chapter_6_command.cafe.receiver.Stereo;
import helpers.coloredString.Colors;
import helpers.coloredString.Logger;

import static helpers.Helpers.*;
import static helpers.Helpers.printSectionEnding;

public class Chapter_6_command {
    public static void chapter_6() {
        printArticle("Command Pattern");

        program_1();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. Command");

        RemoteControl remote = new RemoteControl(); // Инициатор - вызывает выполнение команд

        LivingRoom livingRoom = new LivingRoom();
        LivingRoomLightOnCommand lightOn = new LivingRoomLightOnCommand(livingRoom); // Команда с указанием получателя
        LivingRoomLightOffCommand lightOff = new LivingRoomLightOffCommand(livingRoom);

        GarageDoor door = new GarageDoor();
        GarageDoorOpenCommand openDoor = new GarageDoorOpenCommand(door); // Команда с указанием получателя
        GarageDoorCloseCommand closeDoor = new GarageDoorCloseCommand(door);

        Stereo stereo = new Stereo();
        StereoOffCommand stereOff = new StereoOffCommand(stereo);
        StereoOnWtihRadioCommand stereoOnWtihRadio = new StereoOnWtihRadioCommand(stereo);

        CeilingFan fan = new CeilingFan("Living Room");
        Command ceilingFanHighCommand = new CeilingFanHighCommand(fan);
        Command ceilingFanMediumCommand = new CeilingFanMediumCommand(fan);
        Command ceilingFanLowCommand = new CeilingFanLowCommand(fan);
        Command ceilingFanOffCommand = new CeilingFanOffCommand(fan);

        printSubSection();
        {
            Logger.printMessage("  Светильник в жилой комнате", Colors.GREEN);
            remote.setCommand(0, lightOn, lightOff);
            remote.onButtonWasPushed(0);
            remote.offButtonWasPushed(0);
        }

        printSubSection();
        {
            Logger.printMessage("  Гаражная дверь", Colors.GREEN);
            remote.setCommand(1, openDoor, closeDoor);
            remote.onButtonWasPushed(1);
            remote.offButtonWasPushed(1);
        }

        printSubSection();
        {
            Logger.printMessage("  Стерео дверь", Colors.GREEN);
            remote.setCommand(4, stereoOnWtihRadio, stereOff);
            remote.onButtonWasPushed(4);
            remote.offButtonWasPushed(4);
        }

        remote.undoButtonWasPushed();

        System.out.println(remote);

        printSubSection();
        {
            Logger.printMessage("  Вентилятор в жилой комнате", Colors.GREEN);
            remote.setCommand(0, ceilingFanHighCommand, ceilingFanOffCommand);
            remote.setCommand(1, ceilingFanMediumCommand, ceilingFanOffCommand);
            remote.setCommand(2, ceilingFanLowCommand, ceilingFanOffCommand);


            remote.onButtonWasPushed(0);
            System.out.println("fan.getSpeed() = " + fan.getSpeed());
            remote.undoButtonWasPushed();
            System.out.println("fan.getSpeed() = " + fan.getSpeed());

            remote.offButtonWasPushed(0);
            System.out.println("fan.getSpeed() = " + fan.getSpeed());
            remote.undoButtonWasPushed();
            System.out.println("fan.getSpeed() = " + fan.getSpeed());

            remote.onButtonWasPushed(1);
            remote.onButtonWasPushed(2);
            System.out.println("fan.getSpeed() = " + fan.getSpeed());
            remote.undoButtonWasPushed();
            System.out.println("fan.getSpeed() = " + fan.getSpeed());
        }

        printSubSection();
        {
            Command[] commands = {ceilingFanLowCommand, ceilingFanMediumCommand, ceilingFanHighCommand, ceilingFanOffCommand};
            Command macroOnCommand = new MacroCommand(commands);
            remote.setCommand(6, macroOnCommand, macroOnCommand);
            remote.onButtonWasPushed(6);
            remote.undoButtonWasPushed();
        }

        printSectionEnding();
    }
}

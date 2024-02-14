package headFirst.chapter_6_command.cafe.command;

public class NoCommand implements Command{
    @Override
    public void execute() {
        System.out.println("Пустая команда");
    }

    @Override
    public void undo() {
        System.out.println("Пустая команда");
    }
}

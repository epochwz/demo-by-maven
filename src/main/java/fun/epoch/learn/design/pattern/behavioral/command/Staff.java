package fun.epoch.learn.design.pattern.behavioral.command;

import fun.epoch.learn.design.pattern.behavioral.command.cmds.Command;

import java.util.ArrayList;
import java.util.List;

public class Staff {
    private List<Command> commandList = new ArrayList<>();

    public void addCommand(Command command) {
        commandList.add(command);
    }

    public void executeCommands() {
        for (Command command : commandList) {
            command.execute();
        }
        commandList.clear();
    }
}

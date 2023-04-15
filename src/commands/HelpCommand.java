package commands;

import logic.IODevice;

import java.util.HashMap;

public class HelpCommand extends AbstractCommand {
    private HashMap<String, Command> commandList;
    private String report = "";
    public HelpCommand(IODevice io, HashMap<String, Command> commandList) {
        this.commandList = commandList;
        this.io = io;
    }
    @Override
    public void execute() {
        for (Command command : commandList.values()) {
            report += command.getName() + command.argumentsInfo() + " : " + command.getInfo() + "\n";
        }
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getReport() {
        return report;
    }

    @Override
    public String getInfo() {
        return "выводит справку по доступным командам";
    }
}

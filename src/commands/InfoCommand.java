package commands;

import logic.IODevice;
import logic.Manager;

public class InfoCommand extends AbstractCommand {
    private String report;

    public InfoCommand(IODevice io, Manager manager) {
        super(io, manager);
    }

    @Override
    public void execute() {
        report = manager.getInfo();
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getReport() {
        return report;
    }

    @Override
    public String getInfo() {
        return  "выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}

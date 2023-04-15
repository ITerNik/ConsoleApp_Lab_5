package commands;

import logic.IODevice;
import logic.Manager;

public class ClearCommand extends AbstractCommand {
    public ClearCommand(IODevice io, Manager manager) {
        super(io, manager);
    }
    @Override
    public void execute() {
        manager.clear();
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getReport() {
        return "Коллекция очищена";
    }

    @Override
    public String getInfo() {
        return "очищает коллекцию";
    }
}

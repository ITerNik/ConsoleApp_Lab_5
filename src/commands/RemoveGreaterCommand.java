package commands;

import logic.IODevice;
import logic.Manager;

import java.util.ArrayList;

public class RemoveGreaterCommand extends AbstractCommand {
    private ArrayList<String> removed;
    public RemoveGreaterCommand(IODevice io, Manager manager) {
        super(io, manager);
        setParameterNames("key");
    }

    @Override
    public void execute() {
        removed = manager.removeGreater(parameters[0]);
    }

    @Override
    public String getName() {
        return "remove_greater_key";
    }

    @Override
    public String getReport() {
        if (removed.isEmpty()) {
            return "Ничего не удалено";
        } else {
            return "Удалены следующие объекты:\n" + removed;
        }
    }

    @Override
    public String getInfo() {
        return "удаляет из коллекции все элементы, ключ которых превышает заданный";
    }
}

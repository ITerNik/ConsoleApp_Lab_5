package commands;

import elements.Person;
import logic.IODevice;
import logic.Manager;

import java.util.ArrayList;

public class RemoveLowerCommand extends AbstractCommand {
    private ArrayList<String> removed;
    public RemoveLowerCommand(IODevice io, Manager manager) {
        super(io, manager);
        setElementNumber(1);
    }

    @Override
    public void execute() {
        removed = manager.removeLower(elements[0]);
    }

    @Override
    public String getName() {
        return "remove_lower";
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
        return "удаляет из коллекции все элементы, меньшие, чем заданный";
    }
}

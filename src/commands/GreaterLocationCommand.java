package commands;

import elements.Location;
import exceptions.BadParametersException;
import logic.IODevice;
import logic.Manager;

public class GreaterLocationCommand extends AbstractCommand {
    private int count;

    public GreaterLocationCommand(IODevice io, Manager manager) {
        super(io, manager);
    }



    @Override
    public void execute() {
        count = manager.countGreaterThanLocation(io.readElement(new Location()));
    }

    @Override
    public String getInfo() {
        return "выводит количество элементов, значение поля location которых больше заданного";
    }

    @Override
    public String getReport() {
        return "Элементов найдено: " + count;
    }

    @Override
    public String getName() {
        return "count_greater_than_location";
    }
}

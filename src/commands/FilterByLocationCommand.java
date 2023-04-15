package commands;

import elements.Location;
import elements.Person;
import exceptions.BadParametersException;
import logic.IODevice;
import logic.Manager;

import java.util.ArrayList;

public class FilterByLocationCommand extends AbstractCommand{

    private ArrayList<Person> selected;
    public FilterByLocationCommand(IODevice io, Manager manager) {
        super(io, manager);
    }



    @Override
    public void execute() {
        selected = manager.filterByLocation(io.readElement(new Location()));
    }

    @Override
    public String getInfo() {
        return "выводит элементы, значение поля location которых равно заданному";
    }

    @Override
    public String getReport() {
        return "Найденные элементы:\n" + selected;
    }

    @Override
    public String getName() {
        return "filter_by_location";
    }
}

package commands;

import elements.Location;
import elements.Person;
import logic.IODevice;
import logic.Manager;
import resources.Messages;

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
        return Messages.getMessage("command.filter_by_location");
    }

    @Override
    public String getReport() {
        return Messages.getMessage("message.format.found", selected);
    }

    @Override
    public String getName() {
        return "filter_by_location";
    }
}

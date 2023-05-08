package commands;

import elements.Location;
import logic.IODevice;
import logic.Manager;
import resources.Messages;

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
        return Messages.getMessage("command.greater_location");
    }

    @Override
    public String getReport() {
        return Messages.getMessage("message.format.count", count);
    }

    @Override
    public String getName() {
        return "count_greater_than_location";
    }
}

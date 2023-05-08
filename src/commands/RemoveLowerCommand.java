package commands;

import logic.IODevice;
import logic.Manager;
import resources.Messages;

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
            return Messages.getMessage("message.nothing_deleted");
        } else {
            return Messages.getMessage("message.format.deleted", removed);
        }
    }

    @Override
    public String getInfo() {
        return Messages.getMessage("command.remove_lower");
    }
}

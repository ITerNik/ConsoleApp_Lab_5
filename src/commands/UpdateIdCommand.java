package commands;


import logic.IODevice;
import logic.Manager;
import resources.Messages;

import java.util.ArrayList;

public class UpdateIdCommand extends AbstractCommand {
    private ArrayList<String> keys;

    public UpdateIdCommand(IODevice io, Manager manager) {
        super(io, manager);
        setParameterNames("id");
        setElementNumber(1);
    }

    @Override
    protected void checkArguments(String[] param) throws IllegalArgumentException {
        try {
            int id = Integer.parseInt(param[0]);
            keys = manager.findById(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.getMessage("warning.format.not_real", Messages.getMessage("parameter.id")));
        }
    }

    @Override
    public void execute() {
        for (String key : keys) {
            manager.update(key, elements[0]);
        }
    }

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getReport() {
        return Messages.getMessage("message.format.updated", keys);
    }

    @Override
    public String getInfo() {
        return Messages.getMessage("command.update");
    }
}

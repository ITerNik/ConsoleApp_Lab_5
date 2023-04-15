package commands;

import logic.IODevice;
import logic.Manager;

public class RemoveKeyCommand extends AbstractCommand {
    public RemoveKeyCommand(IODevice io, Manager manager) {
        super(io, manager);
        setParameterNames("key");
    }

    @Override
    protected void checkArguments(String[] param) throws IllegalArgumentException {
        if (!manager.containsKey(param[0]))
            throw new IllegalArgumentException("Элемента с ключом " + param[0] + " не существует");
    }

    @Override
    public void execute() {
        manager.remove(parameters[0]);
    }

    @Override
    public String getName() {
        return "remove_key";
    }

    @Override
    public String getReport() {
        return "Элемент " + parameters[0] + " успешно удален";
    }

    @Override
    public String getInfo() {
        return "удаляет элемент из коллекции по его ключу";
    }
}

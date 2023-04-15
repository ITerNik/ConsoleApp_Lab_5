package commands;

import elements.Person;
import exceptions.BadParametersException;
import exceptions.NonUniqueIdException;
import logic.IODevice;
import logic.Manager;


public class InsertCommand extends AbstractCommand {
    public InsertCommand(IODevice io, Manager manager) {
        super(io, manager);
        elements = new Person[1];
        setParameterNames("key");
    }

    @Override
    protected void checkArguments(String[] param) throws IllegalArgumentException {
        if (manager.containsKey(param[0]))
            throw new IllegalArgumentException("Элемент с ключом " + param[0] + " уже существует");
    }

    @Override
    public void execute() {
        manager.put(parameters[0], elements[0]);
    }

    @Override
    public String getName() {
        return "insert";
    }

    @Override
    public String getReport() {
        return "Элемент " + parameters[0] + " добавлен";
    }

    @Override
    public String getInfo() {
        return "добавляет новый элемент с заданным ключом";
    }
}

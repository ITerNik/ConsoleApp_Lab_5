package commands;

import exceptions.NonUniqueIdException;
import logic.Service;

import java.util.NoSuchElementException;

public class ExitCommand extends AbstractCommand {

    @Override
    public void execute() {
        throw new NoSuchElementException();
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getReport() {
        return "Заглядывайте еще!";
    }

    @Override
    public String getInfo() {
        return "завершает программу (без сохранения в файл)";
    }
}

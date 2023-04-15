package commands;

import elements.EyeColor;
import elements.Person;
import logic.FileDevice;
import logic.IODevice;
import logic.Manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;


public class TestCommand extends AbstractCommand {
    public TestCommand(IODevice io, Manager manager) {
        super(io, manager);
    }


    @Override
    public void execute() {
    }

    @Override
    public String getName() {
        return "test";
    }

    @Override
    public String getInfo() {
        return "побочная команда для тестов";
    }
}

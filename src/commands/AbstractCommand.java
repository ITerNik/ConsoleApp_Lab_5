package commands;

import elements.Person;
import exceptions.*;
import logic.IODevice;
import logic.Manager;

import java.time.LocalDate;

/**
 * Абстрактный класс реализующий интерфейс Command и определяющий базовое поведение команд.
 * Здесь определены методы чтения и установки аргументов.
 * Все команды наследуются от этого класса и переопределяют исполнение в соответствии с требованиями.
 */
public abstract class AbstractCommand implements Command {
    protected Manager manager;
    protected IODevice io;
    protected String[] parameters;
    protected Person[] elements;

    public AbstractCommand() {
    }

    public AbstractCommand(IODevice io, Manager manager) {
        this.manager = manager;
        this.io = io;
    }

    /**
     * Проверяет аргументы из командной строки на соответствие формату
     * и выбрасывает исключение для обработки выше в случае некорректного ввода.
     * Переопределить при необходимости
     *
     * @param param строка идущая после названия команды, разбитая на токены по пробельным символам
     * @throws BadParametersException если аргумент не соответствует формату
     */
    protected void checkArguments(String[] param) throws BadParametersException {
    }

    /**
     * Устанавливает количество аргументов, требуемых команде для последующей проверки
     * с помощью {@link #checkArguments} и считывания {@link #parseArguments}
     *
     * @param names набор строк которые будут выводиться при вызове команды help
     * @see #argumentsInfo()
     */
    protected void setParameterNames(String... names) {
        parameters = names;
    }

    /**
     * Устанавливает количество экземпляров, требуемых команде для считывания и исполнения.
     * Задает количество скобок {element} выводимых help
     *
     * @param number количество считываемых элементов коллекции
     * @see #argumentsInfo()
     */
    protected void setElementNumber(int number) {
        elements = new Person[number];
    }

    @Override
    public Command parseArguments(String[] param) throws BadParametersException {
        if (parameters != null) {
            if (param.length == 0) throw new BadParametersException("Команда не может принимать пустой аргумент");
            checkArguments(param);
            for (int i = 0; i < Math.max(parameters.length, param.length); ++i) {
                try {
                    parameters[i] = param[i];
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new BadParametersException("Команда принимает " + parameters.length + " аргумент(а)");
                }
            }
        } else if (param.length != 0) throw new BadParametersException("Команде не требуется аргумент");

        if (elements != null) {
            for (int i = 0; i < elements.length; ++i) {
                elements[i] = io.readElement(new Person(LocalDate.now()));
            }
        }
        return this;
    }


    @Override
    public String getInfo() {
        return "No information";
    }

    @Override
    public String getReport() {
        return "Команда успешно выполнена";
    }

    @Override
    public String argumentsInfo() {
        String res = "";
        if (parameters != null) {
            for (String param : parameters) {
                res += " " + param;
            }
        }
        if (elements != null) {
            for (int i = 0; i < elements.length; ++i) {
                res += " {element}";
            }
        }
        return res;
    }
}

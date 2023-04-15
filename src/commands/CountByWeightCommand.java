package commands;

import logic.IODevice;
import logic.Manager;

public class CountByWeightCommand extends AbstractCommand {
    private double weight;
    private int count;

    public CountByWeightCommand(IODevice io, Manager manager) {
        super(io, manager);
        setParameterNames("weight");
    }

    @Override
    protected void checkArguments(String[] param) throws IllegalArgumentException {
        try {
            weight = Double.parseDouble(param[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Вес должен быть числом");
        }
    }

    @Override
    public void execute() {
        count = manager.countByWeight(weight);
    }

    @Override
    public String getName() {
        return "count_by_weight";
    }

    @Override
    public String getReport() {
        return String.format("В коллекции найдено %s элементов с весом %s", count, weight);
    }

    @Override
    public String getInfo() {
        return "выводит количество элементов, значение поля weight которых равно заданному";
    }
}

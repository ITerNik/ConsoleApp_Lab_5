package elements;

import annotations.Builder;
import exceptions.BadParametersException;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Person implements Comparable<Person> {
    private static AtomicInteger idCounter = new AtomicInteger(0); //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private int id;
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null

    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double height; //Значение поля должно быть больше 0
    private double weight; //Значение поля должно быть больше 0
    private EyeColor eyeColor; //Поле может быть null
    private HairColor hairColor; //Поле может быть null
    private Location location; //Поле может быть null


    public Person() {
    }

    public Person(LocalDate date) {
        this.id = idCounter.getAndIncrement();
        creationDate = date;
    }


    public Location getLocation() {
        return location;
    }

    public Integer getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }


    public EyeColor getEyeColor() {
        return eyeColor;
    }

    public HairColor getHairColor() {
        return hairColor;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new BadParametersException("ID не может быть отрицательным");
        }
        this.id = id;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Builder(field = "Имя", order = 2)
    public void setName(String name) {
        if (name == null || name.isBlank()) throw new BadParametersException("Человек должен иметь имя");
        this.name = name;
    }

    @Builder(order = 3)
    public void setCoordinates(Coordinates coordinates) {
        if (coordinates == null) throw new BadParametersException("Координаты должны быть определены");
        this.coordinates = coordinates;
    }

    @Builder(field = "Вес", order = 6)
    public void setWeight(String weight) {
        try {
            this.weight = weight.isBlank() ? 0 : Double.parseDouble(weight);

        } catch (NumberFormatException e) {
            throw new BadParametersException("Вес должен быть вещественным числом");
        }
        if (this.weight < 0) throw new BadParametersException("Вес не может быть отрицательным");
    }

    @Builder(field = "Рост", order = 5)
    public void setHeight(String height) {
        try {
            this.height = height.isBlank() ? 0 : Double.parseDouble(height);

        } catch (NumberFormatException e) {
            throw new BadParametersException("Рост должен быть вещественным числом");
        }
        if (this.height < 0) throw new BadParametersException("Рост не может быть отрицательным");
    }

    @Builder(field = "Цвет глаз", variants = {"Зеленый", "Красный", "Карий", "Голубой", "Янтарь"}, order = 7)
    public void setEyeColor(String value) {
        if (value == null || value.isBlank()) {
            this.eyeColor = null;
        } else {
            EyeColor converted = EyeColor.getByValue(value);
            if (converted == null) throw new BadParametersException("Такого цвета не существует");
            this.eyeColor = converted;
        }
    }

    @Builder(field = "Цвет волос", variants = {"Рыжий", "Седой", "Брюнет"}, order = 8)
    public void setHairColor(String value) {
        if (value == null || value.isBlank()) {
            this.hairColor = null;
        } else {
            HairColor converted = HairColor.getByValue(value);
            if (converted == null) throw new BadParametersException("Такого цвета не существует");
            this.hairColor = converted;
        }
    }

    @Builder(order = 9)
    public void setLocation(Location location) {
        this.location = location;
    }

    public void setCounterId(int id) {
        this.id = id;
        idCounter.set(id);
    }


    @Override
    public int compareTo(Person o) {
        int res = Double.compare(height, o.height);
        if (res == 0) {
            res = Double.compare(weight, o.weight);
        }
        if (res == 0) {
            res = name.compareToIgnoreCase(o.name);
        }
        return res;
    }

    @Override
    public String toString() {
        return String.format("ID: %s\nИмя: %s\nКоординаты: %s\nДата создания: %s\nРост: %s\nВес: %s\nЦвет глаз: %s\n" +
                "Цвет волос: %s\nМестоположение: %s", id, name, coordinates, creationDate, height, weight, eyeColor, hairColor, location);
    }
}


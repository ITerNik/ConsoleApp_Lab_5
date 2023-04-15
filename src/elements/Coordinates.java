package elements;

import annotations.Builder;
import exceptions.BadParametersException;

public class Coordinates implements Comparable<Coordinates> {
    private Double x; //Поле не может быть null
    private Integer y; //Значение поля должно быть больше -663, Поле не может быть null

    public Coordinates(double x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {
    }

    @Builder(field = "Координата X", order = 1)
    public void setX(String x) {
        try {
            if (x.isBlank()) throw new BadParametersException("Координата X должна быть определена");
            this.x = Double.parseDouble(x);
        } catch (NumberFormatException e) {
            throw new BadParametersException("Координата X должна быть вещественным числом");
        }
    }

    @Builder(field = "Координата Y", order = 2)
    public void setY(String y) {
        try {
            if (y.isBlank()) throw new BadParametersException("Координата Y должна быть определена");
            this.y = Integer.parseInt(y);
            if (this.y < -633) throw new BadParametersException("Координата Y должна превышать -633");
        } catch (NumberFormatException e) {
            throw new BadParametersException("Координата Y должна быть целым числом");
        }
    }

    public Double getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", x, y);
    }


    @Override
    public int compareTo(Coordinates o) {
        double distanceThis = Math.sqrt(x * x + y * y);
        double distanceO = Math.sqrt(o.x * o.x + o.y * o.y);
        return Double.compare(distanceThis, distanceO);
    }
}

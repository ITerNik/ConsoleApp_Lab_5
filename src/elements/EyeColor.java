package elements;

public enum EyeColor {
    GREEN("ЗЕЛЕНЫЙ"),
    RED("КРАСНЫЙ"),
    BLACK("КАРИЙ"),
    BLUE("ГОЛУБОЙ"),
    YELLOW("ЯНТАРЬ");

    private String locale;

    EyeColor(String name) {
        this.locale = name;
    }

    public static EyeColor getByValue(String value) {
        for (EyeColor color : EyeColor.values()) {
            if (color.locale.contains(value.toUpperCase()) ||
                    color.name().contains(value.toUpperCase())) return color;
        }
        try {
            return EyeColor.values()[Integer.parseInt(value) - 1];
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            return null;
        }
    }


    @Override
    public String toString() {
        return locale;
    }
}

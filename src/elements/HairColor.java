package elements;

public enum HairColor {
    ORANGE("РЫЖИЙ"),
    WHITE("СЕДОЙ"),
    BROWN("БРЮНЕТ");

    private String locale;

    HairColor(String name) {
        this.locale = name;
    }

    public static HairColor getByValue(String value) {
        for (HairColor color : HairColor.values()) {
            if (color.locale.contains(value.toUpperCase()) ||
                    color.name().contains(value.toUpperCase())) return color;
        }
        try {
            return HairColor.values()[Integer.parseInt(value) - 1];
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return locale;
    }
}

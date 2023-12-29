package freePractise.logger_coloredString;

public enum Colors {
    BLACK("\u001B[30m", "BLACK"),
    RED("\u001B[31m", "RED"),
    GREEN("\u001B[32m", "GREEN"),
    YELLOW("\u001B[33m", "YELLOW"),
    BLUE("\u001B[34m", "BLUE"),
    PURPLE("\u001B[35m", "PURPLE"),
    CYAN("\u001B[36m", "CYAN"),
    WHITE("\u001B[37m", "WHITE"),
    RESET("\u001B[0m", "RESET"),
    NOT_COLOR("\u001B[38m", "NOT_COLOR");
    private final String colorCode;
    private final String colorName;

    Colors(String colorCode, String colorName) {
        this.colorCode = colorCode;
        this.colorName = colorName;
    }

    @Override
    public String toString() {
        return colorCode;
    }

    public String getColorName() {
        return colorName;
    }

    public ColoredString getColoredString() {
        return new ColoredString(colorName, this);
    }

    public String[] getCodes() {
        String[] codes = new String[helpers.coloredString.Colors.values().length];

        int counter = 0;
        for (helpers.coloredString.Colors value : helpers.coloredString.Colors.values()) {
            codes[counter] = value.toString();
            counter++;
        }

        return codes;
    }
}
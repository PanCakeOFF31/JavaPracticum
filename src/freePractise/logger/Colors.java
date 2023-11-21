package freePractise.logger;

public enum Colors {
    BLACK("\u001B[30m", "BLACK"),
    RED("\u001B[31m", "RED"),
    GREEN("\u001B[32m", "GREEN"),
    YELLOW("\u001B[33m", "YELLOW"),
    BLUE("\u001B[34m", "BLUE"),
    PURPLE("\u001B[35m", "PURPLE"),
    CYAN("\u001B[36m", "CYAN"),
    WHITE("\u001B[37m", "WHITE"),
    RESET("\u001B[0m", "RESET");
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

    public ColoredString getColorName() {
        return new ColoredString(colorName,this);
    }

    public String[] getCodes() {
        String[] codes = new String[Colors.values().length];

        int counter = 0;
        for (Colors value : Colors.values()) {
            codes[counter] = value.toString();
            counter++;
        }

        return codes;
    }

//    public String getColorName() {
//        return this.colorName;
//    }
}
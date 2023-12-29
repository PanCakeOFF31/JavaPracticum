package helpers.coloredString;

public class ColoredString {
    private static final String RESET = Colors.RESET.toString();
    private String coloredText = null;
    private String uncoloredText = null;
    private Colors color = null;
    private boolean[] options = null;


    public static ColoredString of(String text, boolean... options) {
        return new ColoredString(text, options);
    }

    public static ColoredString of(String text, Colors color) {
        return new ColoredString(text, color);
    }

    public static ColoredString of(String text, Colors color, boolean... options) {
        return new ColoredString(text, color, options);
    }

    public ColoredString(String text, boolean... options) {
        if (text == null || options == null || options.length > 3)
            throw new IllegalArgumentException();

        this.color = Colors.NOT_COLOR;
        this.uncoloredText = text;
        this.coloredText = uncoloredText;
        this.options = new boolean[0];

        initializeOptions();
    }

    public ColoredString(String text, Colors color) {
        if (text == null || color == null)
            throw new IllegalArgumentException();

        this.color = color;
        this.uncoloredText = text;
        this.coloredText = uncoloredText;
        this.options = new boolean[0];

        initializeColor();
    }

    public ColoredString(String text, Colors color, boolean... options) {
        this(text, color);

        if (options == null || options.length > 3) {
            throw new RuntimeException("ОЛО");
        }

        this.options = options;
        initializeOptions();
    }

    public ColoredString(ColoredString coloredString) {
        if (coloredString == null)
            throw new RuntimeException("ОЛО");

        this.color = coloredString.color;
        this.uncoloredText = coloredString.uncoloredText;
        this.coloredText = coloredString.uncoloredText;
        this.options = coloredString.options;

        initializeOptions();
    }

    public ColoredString changeColor(Colors color) {
        coloredTextInference(color);
        initializeOptions();
        return this;
    }

    public ColoredString changeOptions(boolean... options) {
        optionsInference(options);
        return this;
    }

    public ColoredString changeText(String text) {
        this.uncoloredText = text;
        initializeColor();
        return this;
    }

    public String getUncoloredText() {
        return uncoloredText;
    }

    private void initializeColor() {
        this.coloredText = this.color + this.uncoloredText + RESET;
    }

    private void initializeOptions() {
        String handledColorText = this.color.toString();

        handledColorText = switch (this.options.length) {
            case 1 -> {
                if (this.options[0]) {
                    handledColorText = boldHandling(handledColorText);
                }
                yield handledColorText;
            }
            case 2 -> {
                if (this.options[0])
                    handledColorText = boldHandling(handledColorText);

                if (this.options[1])
                    handledColorText = italicHandling(handledColorText);

                yield handledColorText;
            }
            case 3 -> {
                if (this.options[0])
                    handledColorText = boldHandling(handledColorText);

                if (this.options[1])
                    handledColorText = italicHandling(handledColorText);

                if (this.options[2])
                    handledColorText = underlineHandling(handledColorText);
                yield handledColorText;
            }
            default -> handledColorText = handledColorText;
        };

        correctColoredText(handledColorText);
    }

    private void correctColoredText(String correctedText) {
        this.coloredText = correctedText + this.uncoloredText + RESET;
    }

    private String boldHandling(String coloredText) {
        String[] parts = coloredText.split("\\[");
        return parts[0] + "[1;" + parts[1];
    }

    private static String italicHandling(String coloredText) {
        String[] parts = coloredText.split("\\[");
        return parts[0] + "[3;" + parts[1];
    }

    private static String underlineHandling(String coloredText) {
        String[] parts = coloredText.split("\\[");
        return parts[0] + "[4;" + parts[1];
    }

    private void coloredTextInference(Colors color) {
        this.color = color;
        initializeColor();
    }

    private void optionsInference(boolean... options) {
        this.options = options;
        initializeOptions();
    }

    @Override
    public String toString() {
        return coloredText;
    }
}

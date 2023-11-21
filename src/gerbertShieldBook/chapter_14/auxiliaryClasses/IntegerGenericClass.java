package gerbertShieldBook.chapter_14.auxiliaryClasses;

public class IntegerGenericClass implements GenericInterface<Integer> {
    private final Integer[] values;

    public IntegerGenericClass(Integer[] values) {
        this.values = values;
    }
    @Override
    public Integer min() {
        Integer min = values[0];
        for (Integer value : values) {
            if (value.compareTo(min) < 0)
                min = value;
        }
        return min;
    }

    @Override
    public Integer max() {
        Integer max = values[0];
        for (Integer value : values) {
            if (value.compareTo(max) > 0)
                max = value;
        }
        return max;
    }
}

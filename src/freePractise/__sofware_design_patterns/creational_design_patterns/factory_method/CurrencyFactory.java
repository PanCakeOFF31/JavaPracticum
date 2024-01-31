package freePractise.__sofware_design_patterns.creational_design_patterns.factory_method;

import freePractise.__sofware_design_patterns.creational_design_patterns.factory_method.currencies.Currency;

public class CurrencyFactory {
    public static Currency createCurrency(String country) {
        return switch (country) {
            case "Russia" -> new Ruble();
            case "USA" -> new Dollar();
            case "German" -> new Euro();
            default -> throw new IllegalArgumentException();
        };
    }

    private static class Euro implements Currency {
        @Override
        public String getSymbol() {
            return "Евро";
        }
    }

    private static class Dollar implements Currency {
        @Override
        public String getSymbol() {
            return "Доллар";
        }
    }

    private static class Ruble implements Currency {
        @Override
        public String getSymbol() {
            return "Рубль";
        }
    }
}








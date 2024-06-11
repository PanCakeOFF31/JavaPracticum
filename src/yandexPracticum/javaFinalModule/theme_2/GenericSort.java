package yandexPracticum.javaFinalModule.theme_2;

import java.util.*;

public class GenericSort {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(List.of(
                new Product("Гречка", 91.6),
                new Product("Рис", 89.4),
                new Product("Пис", 89.4),
                new Product("Булгур", 124.)
        ));

        System.out.println("products = " + products);

        Collections.sort(products);
        System.out.println("products = " + products);

        System.out.println("Самый дорогой продукт: " + max(products));
        System.out.println("Самый дешевый продукт: " + min(products));
    }

    private static <T extends Comparable<T>> T max(Collection<T> objects) {
        if (objects.isEmpty())
            return null;

        Iterator<T> iterator = objects.iterator();
        T max = iterator.next();


        while (iterator.hasNext()) {
            T element = iterator.next();
            if (max.compareTo(element) < 0) {
                max = element;
            }
        }

        return max;
    }

    private static <T extends Comparable<T>> T min(Collection<T> objects) {
        if (objects.isEmpty())
            return null;

        Iterator<T> iterator = objects.iterator();
        T min = iterator.next();


        while (iterator.hasNext()) {
            T element = iterator.next();
            if (min.compareTo(element) > 0) {
                min = element;
            }
        }

        return min;
    }
}

class Product implements Comparable<Product> {
    private final String name;
    private final Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Product anotherProduct) {
        int price = this.price.compareTo(anotherProduct.price);
        int name = this.name.compareTo(anotherProduct.name);

        if (price == 0) return name;
        return price;
    }

    @Override
    public String toString() {
        return name + " (" + price + " р.)";
    }
}

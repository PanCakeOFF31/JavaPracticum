package headFirst.chapter_9_iterator_composite.cafe_v1.item;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
public class MenuItem {
    @NonNull
    private String name;
    @NonNull
    @ToString.Exclude
    private String description;
    @NonNull
    private boolean vegetarian;
    @NonNull
    private double price;

    public void print() {
        System.out.print(" " + getName());
        if (isVegetarian()) {
            System.out.print("(v)");
        }
        System.out.println(", " + getPrice());
        System.out.println(" -- " + getDescription());
    }
}

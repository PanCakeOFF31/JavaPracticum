package headFirst.chapter_9_iterator_composite.cafe_v2.item;

import headFirst.chapter_9_iterator_composite.cafe_v2.component.MenuComponent;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
public class MenuItem extends MenuComponent {
    @NonNull
    private String name;
    @NonNull
    @ToString.Exclude
    private String description;
    @NonNull
    private boolean vegetarian;
    @NonNull
    private double price;

    @Override
    public void print() {
        System.out.print(" " + getName());
        if (isVegetarian()) {
            System.out.print("(v)");
        }
        System.out.println(", " + getPrice());
        System.out.println(" -- " + getDescription());
    }

}

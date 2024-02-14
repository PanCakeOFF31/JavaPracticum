package headFirst.chapter_9_iterator_composite.cafe_v2.container;

import headFirst.chapter_9_iterator_composite.cafe_v2.item.MenuItem;
import headFirst.chapter_9_iterator_composite.cafe_v2.iterator.DinnerIterator;
import headFirst.chapter_9_iterator_composite.cafe_v2.iterator.DinnerMenuIterator;
import headFirst.chapter_9_iterator_composite.cafe_v2.iterator.Iterator_;
import lombok.Getter;

import java.util.Iterator;

@Getter
public class DinerMenu {
    private static final int MAX_ITEMS = 6;
    private int numberOfItems = 0;
    private final MenuItem[] menuItems;

    public DinerMenu() {
        this.menuItems = new MenuItem[MAX_ITEMS];

        addItem("Vegetarian BLT",
                "(Fakin’) Bacon with lettuce & tomato on whole wheat",
                true,
                2.99);
        addItem("BLT",
                "Bacon with lettuce & tomato on whole wheat",
                false,
                2.99);
        addItem("Soup of the day",
                "Soup of the day, with a side of potato salad",
                false,
                3.29);
        addItem("Hotdog",
                "A hot dog, with saurkraut, relish, onions, topped with cheese",
                false,
                3.05);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems >= MAX_ITEMS)
            System.out.println("Menu is full!");
        else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems++;
        }
    }

    public Iterator_ createIterator() {
        return new DinnerMenuIterator(this.menuItems);
    }

    public Iterator<MenuItem> iterator() {
        return new DinnerIterator(this.menuItems);
    }
}

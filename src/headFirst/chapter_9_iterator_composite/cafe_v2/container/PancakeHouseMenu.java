package headFirst.chapter_9_iterator_composite.cafe_v2.container;

import headFirst.chapter_9_iterator_composite.cafe_v2.item.MenuItem;
import headFirst.chapter_9_iterator_composite.cafe_v2.iterator.BreakfastMenuIterator;
import headFirst.chapter_9_iterator_composite.cafe_v2.iterator.Iterator_;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class PancakeHouseMenu {
    @Getter
    private List<MenuItem> menuItems;

    public PancakeHouseMenu() {
        this.menuItems = new ArrayList<MenuItem>();

        addItem("K&B’s Pancake Breakfast",
                "Pancakes with scrambled eggs, and toast",
                true,
                2.99);
        addItem("Regular Pancake Breakfast",
                "Pancakes with fried eggs, sausage",
                false,
                2.99);
        addItem("Blueberry Pancakes",
                "Pancakes made with fresh blueberries",
                true,
                3.49);
        addItem("Waffles",
                "Waffles, with your choice of blueberries or strawberries",
                true,
                3.59);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    public Iterator_ createIterator() {
        return new BreakfastMenuIterator(this.menuItems);
    }

    public Iterator<MenuItem> iterator() {
        return menuItems.iterator();
    }
}

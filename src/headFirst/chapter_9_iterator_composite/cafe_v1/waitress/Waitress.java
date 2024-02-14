package headFirst.chapter_9_iterator_composite.cafe_v1.waitress;

import headFirst.chapter_9_iterator_composite.cafe_v1.container.Menu;
import headFirst.chapter_9_iterator_composite.cafe_v1.item.MenuItem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Waitress {
    private List<Menu> menus;
    private Menu pancakeHouseMenu;
    private Menu dinerMenu;
    private Menu cafeMenu;

    public Waitress(ArrayList<Menu> menus) {
        this.menus = menus;
    }

    public void printMenu() {
        for (Menu menu : menus) {
            printMenu(menu.iterator());
        }
    }

    private void printMenu(Iterator<MenuItem> iterator) {
        iterator.forEachRemaining(System.out::println);
    }
}

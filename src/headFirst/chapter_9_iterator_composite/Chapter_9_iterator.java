package headFirst.chapter_9_iterator_composite;

import headFirst.chapter_9_iterator_composite.cafe_v1.container.CafeMenu;
import headFirst.chapter_9_iterator_composite.cafe_v1.container.DinerMenu;
import headFirst.chapter_9_iterator_composite.cafe_v1.container.PancakeHouseMenu;
import headFirst.chapter_9_iterator_composite.cafe_v1.item.MenuItem;
import headFirst.chapter_9_iterator_composite.cafe_v1.iterator.Iterator_;
import headFirst.chapter_9_iterator_composite.cafe_v1.waitress.Waitress;
import headFirst.chapter_9_iterator_composite.cafe_v2.component.MenuComponent;
import headFirst.chapter_9_iterator_composite.cafe_v2.container.Menu;
import helpers.coloredString.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static helpers.Helpers.*;

public class Chapter_9_iterator {
    public static void chapter_9() {
        printArticle("Iterator Pattern");

//        program_1();
        program_2();


        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. Iterator");

        PancakeHouseMenu houseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();
        CafeMenu cafeMenu = new CafeMenu();

        {
            Logger.printMessage("House Menu");
            houseMenu.getMenuItems().forEach(System.out::println);

            Logger.printMessage("Diner Menu");
            Arrays.asList(dinerMenu.getMenuItems()).forEach(System.out::println);
        }

        {
            List<MenuItem> breakfastItems = houseMenu.getMenuItems();
            MenuItem[] dinerItems = dinerMenu.getMenuItems();
        }

        Logger.printMarkMessage("Кастомный итератор");
        {
            Iterator_ iterator1 = houseMenu.createIterator();
            Iterator_ iterator2 = dinerMenu.createIterator();

            Logger.printMessage("BreakfastIterator");
            while (iterator1.hasNext())
                System.out.println(iterator1.next());

            Logger.printMessage("DinerIterator");
            while (iterator2.hasNext())
                System.out.println(iterator2.next());
        }

        Logger.printMarkMessage("Стандартный итератор");
        {
            Iterator<MenuItem> iterator1 = houseMenu.iterator();
            Iterator<MenuItem> iterator2 = dinerMenu.iterator();

            Logger.printMessage("BreakfastIterator");
            while (iterator1.hasNext())
                System.out.println(iterator1.next());

            Logger.printMessage("DinerIterator");
            while (iterator2.hasNext())
                System.out.println(iterator2.next());
        }

        Logger.printMarkMessage("Waitress");
        {
            Waitress waitress = new Waitress(new ArrayList<>(List.of(houseMenu, dinerMenu, cafeMenu)));
            waitress.printMenu();
        }

        {
            List<Integer> list = new ArrayList<>();
            int[] ints = {1, 2, 3};
        }


        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. cafe_v2");

        MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
        MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
        MenuComponent dessertMenu = new Menu("DESSERT MENU", "Dessert of course!");

        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combiden");

        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        dinerMenu.add(new headFirst.chapter_9_iterator_composite.cafe_v2.item.MenuItem("Pasta", "Spaghettti", true, 3.89));
        dinerMenu.add(dessertMenu);

        var waitress = new headFirst.chapter_9_iterator_composite.cafe_v2.waitress.Waitress(allMenus);
        waitress.printMenu();

        printSectionEnding();
    }
}

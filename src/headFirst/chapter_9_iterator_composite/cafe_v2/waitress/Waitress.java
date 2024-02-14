package headFirst.chapter_9_iterator_composite.cafe_v2.waitress;

import headFirst.chapter_9_iterator_composite.cafe_v2.component.MenuComponent;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Waitress {
    private MenuComponent allMenus;

    public void printMenu() {
        allMenus.print();
    }
}

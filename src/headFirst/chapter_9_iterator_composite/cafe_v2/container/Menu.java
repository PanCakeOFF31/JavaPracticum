package headFirst.chapter_9_iterator_composite.cafe_v2.container;

import headFirst.chapter_9_iterator_composite.cafe_v2.component.MenuComponent;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Menu extends MenuComponent {
    private List<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
    @Getter
    @NonNull
    private String name;
    @Getter
    @NonNull
    private String description;

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("---------------------");

        for (MenuComponent menuComponent : menuComponents) {
            menuComponent.print();
        }
    }
}

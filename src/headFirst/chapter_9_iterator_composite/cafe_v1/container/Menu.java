package headFirst.chapter_9_iterator_composite.cafe_v1.container;

import headFirst.chapter_9_iterator_composite.cafe_v1.item.MenuItem;

import java.util.Iterator;

public interface Menu {
    Iterator<MenuItem> iterator();
}

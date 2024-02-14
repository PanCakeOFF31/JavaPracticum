package headFirst.chapter_9_iterator_composite.cafe_v2.iterator;

import headFirst.chapter_9_iterator_composite.cafe_v2.item.MenuItem;

public interface Iterator_ {
    boolean hasNext();

    MenuItem next();
}

package headFirst.chapter_9_iterator_composite.cafe_v1.iterator;

import headFirst.chapter_9_iterator_composite.cafe_v1.item.MenuItem;

public interface Iterator_ {
    boolean hasNext();

    MenuItem next();
}

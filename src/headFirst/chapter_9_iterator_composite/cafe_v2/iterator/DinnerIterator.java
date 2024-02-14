package headFirst.chapter_9_iterator_composite.cafe_v2.iterator;

import headFirst.chapter_9_iterator_composite.cafe_v2.item.MenuItem;

import java.util.Iterator;

public class DinnerIterator implements Iterator<MenuItem> {
    @Override
    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }

    @Override
    public MenuItem next() {
        MenuItem item = items[position];
        position++;
        return item;
    }

    private MenuItem[] items;
    private int position = 0;

    public DinnerIterator(MenuItem[] items) {
        this.items = items;
    }
}

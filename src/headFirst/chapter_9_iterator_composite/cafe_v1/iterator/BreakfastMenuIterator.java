package headFirst.chapter_9_iterator_composite.cafe_v1.iterator;

import headFirst.chapter_9_iterator_composite.cafe_v1.item.MenuItem;

import java.util.List;

public class BreakfastMenuIterator implements Iterator_ {
    private final MenuItem[] items;
    private int position = 0;

    public BreakfastMenuIterator(List<MenuItem> items) {
        this.items = items.toArray(new MenuItem[0]);
    }


    @Override
    public boolean hasNext() {
        return position < items.length;
//        Здесь может быть null, так как в DinerMen используется массив не заполненный
    }

    @Override
    public MenuItem next() {
        MenuItem item = items[position];
        position++;
        return item;
    }
}

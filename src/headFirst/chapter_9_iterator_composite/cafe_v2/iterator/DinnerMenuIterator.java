package headFirst.chapter_9_iterator_composite.cafe_v2.iterator;

import headFirst.chapter_9_iterator_composite.cafe_v2.item.MenuItem;

public class DinnerMenuIterator implements Iterator_ {
    private MenuItem[] items;
    private int position = 0;

    public DinnerMenuIterator(MenuItem[] items) {
        this.items = items;
    }


    public boolean hasNext() {
        return position < items.length && items[position] != null;
//        Здесь может быть null, так как в DinerMen используется массив не заполненный
    }

    public MenuItem next() {
        MenuItem item = items[position];
        position++;
        return item;
    }
}

package yandexPracticum.javaFinalModule.theme_1;

public class Practice_3 {
    public static void main(String[] args) {
        int[] arrayAsc = {1, 2, 5, 8, 12, 13, 20, 22, 24, 30, 32};
        int[] arrayDesc = {32, 30, 24, 22, 20, 13, 12, 8, 5, 2, 1};

        System.out.println("Индекс искомого элемента: " + searchBinaryAscending(arrayAsc, 30));
        System.out.println("Индекс искомого элемента: " + searchBinaryDescending(arrayDesc, 30));
        System.out.println("Индекс искомого элемента: " + searchBinary(arrayAsc, 30));
        System.out.println("Индекс искомого элемента: " + searchBinary(arrayDesc, 30));
    }

    private static int searchBinary(int[] array, int element) {
        // возвращает 1, если массив отсортирован по возрастанию, и -1, если по убыванию
        int sort = getSortRecursive(array, 0, 0);
        if (sort > 0) {
            System.out.println("Массив отсортирован по возрастанию");
            return searchBinaryAscending(array, element);
        } else if (sort < 0) {
            System.out.println("Массив отсортирован по убыванию");
            return searchBinaryDescending(array, element);
        } else {
            System.out.println("Массив не отсортирован");
            return -1;
        }
    }

    /**
     * Метод определяет рекурсивно <b>сортированность</b> списка
     *
     * @param array исходны массив
     * @param sort  хранит результат сортировки предыдущего вызова
     * @param next  начальный индекс проверки [next; array.length)
     * @return -1 - по убыванию; +1 - по возрастанию; 0 - несортированный
     * @throws ArrayIndexOutOfBoundsException если next индекс за пределами длины массива
     * @throws IllegalArgumentException       если next индекс за пределами длины массива
     * @see <a href="ya.ru">смотреть тут</a>
     * @since 1.0.0
     * @since 07/07/2024
     */
    private static int getSortRecursive(int[] array, int sort, int next) throws ArrayIndexOutOfBoundsException {
        // Несортированный, если массив пустой
        if (array.length == 0 || array.length == 1) return 0;

        if (sort == 0) {
            if (array[next] < array[next + 1])
                sort = 1;
            if (array[next] > array[next + 1])
                sort = -1;
        }

        if (next + 1 >= array.length)
            return sort;

        if (sort > 0 && array[next] < array[next + 1])
            return getSortRecursive(array, sort, ++next);

        if (sort < 0 && array[next] > array[next + 1])
            return getSortRecursive(array, sort, ++next);

        return 0;
    }

    private static int searchBinaryAscending(int[] array, int element) {
        if (array.length == 0) return -1;

        if (array.length == 1) {
            if (element == array[0])
                return 0;

            return -1;
        }

        return searchBinaryAscendingRecursive(array, element, 0, array.length - 1);
    }

    private static int searchBinaryDescending(int[] array, int element) {
        if (array.length == 0) return -1;

        if (array.length == 1) {
            if (element == array[0])
                return 0;

            return -1;
        }

        return searchBinaryDescendingRecursive(array, element, 0, array.length - 1);
    }

    private static int searchBinaryAscendingRecursive(int[] array, int element, int low, int high) {
        if (high < low) return -1;

        if (high == low) {
            if (element == array[low])
                return low;

            return -1;
        }

        int middle = low + (high - low) / 2;
        int middleElement = array[middle];

        if (middleElement == element)
            return middle;

        if (element < middleElement)
            return searchBinaryAscendingRecursive(array, element, low, middle);

        return searchBinaryAscendingRecursive(array, element, middle + 1, high);
    }

    private static int searchBinaryDescendingRecursive(int[] array, int element, int low, int high) {
        if (high < low) return -1;

        if (high == low) {
            if (element == array[low])
                return low;

            return -1;
        }

        int middle = low + (high - low) / 2;
        int middleElement = array[middle];

        if (middleElement == element)
            return middle;

        if (element < middleElement)
            return searchBinaryDescendingRecursive(array, element, middle + 1, high);

        return searchBinaryDescendingRecursive(array, element, low, middle);
    }

}

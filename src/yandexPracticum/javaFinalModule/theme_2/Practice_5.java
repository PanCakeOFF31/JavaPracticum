package yandexPracticum.javaFinalModule.theme_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice_5 {
    public static void main(String[] args) {
        List<Dog> unsortedDogs = Stream.of(
                        "Дружок", "Пушок", "Тузик", "Ромео",
                        "Белка", "Стрелка", "Бобик", "Афоня",
                        "Волчок")
                .map(Dog::new)
                .collect(Collectors.toList());

        // найдите Белку
        Dog dog = new Dog("Белка");
        String result = search(unsortedDogs, dog)
                .map(d -> "А вот и собака по кличке " + d + " нашлась")
                .orElseGet(() -> "Нет собаки по кличке " + dog + " :(");

        System.out.println(result);
    }

    private static <T extends Comparable<T>> Optional<T> search(List<T> unsortedList, T searchObject) {
        List<T> sortedList = mergeSortDescending(unsortedList);
        int idx = searchBinaryDescending(sortedList, searchObject);

        if (idx < 0)
            return Optional.empty();

        return Optional.of(sortedList.get(idx));
    }


    private static <T extends Comparable<T>> List<T> mergeSortDescending(List<T> unsortedList) {
        if (unsortedList.size() <= 1)
            return unsortedList;

        List<T> result = new ArrayList<>(unsortedList);

        List<T> leftPart = unsortedList.subList(0, unsortedList.size() / 2);
        List<T> left = mergeSortDescending(leftPart);

        List<T> rightPart = unsortedList.subList(unsortedList.size() / 2, unsortedList.size());
        List<T> right = mergeSortDescending(rightPart);

        int resultIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex).compareTo(right.get(rightIndex)) >= 0) {
                result.set(resultIndex, left.get(leftIndex));
                ++leftIndex;
            } else {
                result.set(resultIndex, right.get(rightIndex));
                ++rightIndex;
            }

            ++resultIndex;
        }

        while (leftIndex < left.size()) {
            result.set(resultIndex, left.get(leftIndex));
            leftIndex++;
            resultIndex++;
        }

        while (rightIndex < right.size()) {
            result.set(resultIndex, right.get(rightIndex));
            rightIndex++;
            resultIndex++;
        }

        return result;
    }

    private static <T extends Comparable<T>> int searchBinaryDescending(List<T> sortedList, T element) {
        if (sortedList.isEmpty()) return -1;

        if (sortedList.size() == 1) {
            if (element.equals(sortedList.get(0)))
                return 0;

            return -1;
        }

        return searchBinaryDescendingRecursive(sortedList, element, 0, sortedList.size() - 1);
    }

    private static <T extends Comparable<T>> int searchBinaryDescendingRecursive(List<T> sortedList, T element, int low, int high) {
        if (high < low) return -1;

        if (high == low) {
            if (element.equals(sortedList.get(low)))
                return low;

            return -1;
        }

        int middle = low + (high - low) / 2;
        T middleElement = sortedList.get(middle);

        if (middleElement.equals(element))
            return middle;

        if (element.compareTo(middleElement) < 0)
            return searchBinaryDescendingRecursive(sortedList, element, middle + 1, high);

        return searchBinaryDescendingRecursive(sortedList, element, low, middle);
    }
}

class Dog implements Comparable<Dog> {

    private final String nickname;

    public Dog(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return nickname;
    }

    @Override
    public int compareTo(Dog o) {
        return this.nickname.compareTo(o.nickname);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Dog dog = (Dog) obj;
        return this.nickname.equals(dog.nickname);
    }
}
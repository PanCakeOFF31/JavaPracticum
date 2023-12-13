package helpers.collectionUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;

public class CollectionUtil {
    private static <T> List<T> deepListCopy(List<T> list, UnaryOperator<T> operator) {
        List<T> newList = new ArrayList<>();

        for (T element : list) {
            newList.add(operator.apply(element));
        }

        return newList;
    }

    private static <K, V> Map<K, V> deepMapCopy(Map<K, V> map, UnaryOperator<V> operator) {
        Map<K, V> newMap = new HashMap<>();

        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = operator.apply(entry.getValue());
            newMap.put(key, value);
        }

        return newMap;
    }
}

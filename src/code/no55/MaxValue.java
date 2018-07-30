package code.no55;

import java.util.*;

public class MaxValue {

    public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
        if (c.isEmpty()) {
            return Optional.empty();
        } else {
            E result = null;
            for (E item : c) {
                if (result == null || item.compareTo(result) > 0) {
                    result = Objects.requireNonNull(item);
                }
            }
            return Optional.of(result);
        }
    }

    public static <E extends Comparable<E>> Optional<E> maxWithStream(Collection<E> c) {
        return c.stream().max(Comparator.naturalOrder());
    }
}

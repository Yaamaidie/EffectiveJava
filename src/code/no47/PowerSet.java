package code.no47;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PowerSet {
    public static void main(String[] args) {
        Collection<Set<Integer>> result = of(IntStream.range(1, 25).boxed().collect(Collectors.toSet()));
        System.out.println(result);
    }

    public static final <E> Collection<Set<E>> of(Set<E> s) {
        List<E> src = new ArrayList<>(s);
        if (src.size() > 30)
            throw new IllegalArgumentException("Set too big " + s);
        return new AbstractList<Set<E>>() {
            @Override public int size() {
                return 1 << src.size(); // 2 to the power srcSize
            }
            @Override public boolean contains(Object o) {
                return o instanceof Set && src.containsAll((Set)o);
            }
            @Override public Set<E> get(int index) {
                Set<E> result = new HashSet<>();
                for (int i = 0; index != 0; i++, index >>= 1)
                    if ((index & 1) == 1)
                        result.add(src.get(i));
                return result;
            }
        };
    }
}

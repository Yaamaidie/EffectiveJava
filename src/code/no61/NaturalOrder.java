package code.no61;

import java.util.Comparator;

public class NaturalOrder {
    public static void main(String[] args) {
        //broken comparator
        wrongComparator();
        //true comparator
        trueComparator();
    }

    public static void wrongComparator() {
        Comparator<Integer> naturalOrder = (i, j) -> i < j ? -1 : (i == j ? 0 : 1);
        System.out.println(naturalOrder.compare(
                new Integer(42), new Integer(42))); //1
    }

    public static void trueComparator() {
        Comparator<Integer> naturalOrder = (iBoxed, jBoxed) -> {
            int i = iBoxed, j = jBoxed;
            return i < j ? -1 : (i == j ? 0 : 1);
        };
        System.out.println(naturalOrder.compare(
                new Integer(42), new Integer(42))); //0
    }
}

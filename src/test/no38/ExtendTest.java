package test.no38;

import code.no38.ExtendedOperation;
import code.no38.Operation;

public class ExtendTest {
    public static void main(String[] args) {
        test(ExtendedOperation.class, 2.5, 2);
    }

    public static <T extends Enum<T> & Operation> void test(Class<T> opSet, double x, double y) {
        for (Operation op : opSet.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}

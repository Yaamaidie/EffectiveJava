package test.no16;

import code.no16.InstrumentedSet;

import java.util.HashSet;

/**
 * Created by HP-PC on 2018/6/25.
 */
public class InstrumentedSetTest {
    public static void main(String[] args) {
        InstrumentedSet<String> is = new InstrumentedSet<>(new HashSet<String>());
        for (int i = 0; i < 5; i++) {
            is.add(i + "");
        }
        System.out.println(is.getAddCount());
        is.addAll(is);
        System.out.println(is.getAddCount());
    }
}

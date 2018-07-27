package code.no48;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class Pi {

    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        pi((long) Math.pow(10, 7));
        System.out.println("cost: " + (System.currentTimeMillis() - t));

        t = System.currentTimeMillis();
        pi2((long) Math.pow(10, 7));
        System.out.println("cost: " + (System.currentTimeMillis() - t));
    }

    // Prime-counting stream pipeline - benefits from parallelization
    static long pi(long n) {
        return LongStream.rangeClosed(2, n)
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    static long pi2(long n) {
        return LongStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }
}

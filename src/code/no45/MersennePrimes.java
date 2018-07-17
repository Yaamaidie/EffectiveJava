package code.no45;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.*;

public class MersennePrimes {
    final static BigInteger TWO = BigInteger.valueOf(2L);
    public static void main(String[] args) {
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(mp -> System.out.println(mp.bitLength() + ": " + mp));
    }

    static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }
}

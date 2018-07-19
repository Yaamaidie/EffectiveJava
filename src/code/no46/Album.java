package code.no46;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.BinaryOperator;

import static java.util.stream.Collectors.toMap;

public class Album {
    final String name;
    final int sales;
    final String artist;

    public Album(String artist, String name, int sales) {
        this.artist = artist;
        this.name = name;
        this.sales = sales;
    }

    public String getArtist() {
        return artist;
    }

    public int getSales() {
        return sales;
    }

    @Override
    public String toString() {
        return "[" + artist + ", " + name + ", " + sales + "]";
    }

    public static void main(String[] args) {
        Album[] albums = new Album[]{
                new Album("smith", "black1", 11000),
                new Album("smith", "black2", 12000),
                new Album("tom", "magic1", 13000),
                new Album("tom", "magic2", 16000),
                new Album("jack", "forever love", 12300),
                new Album("jack", "my heart", 14400),
                new Album("jimmy", "look at me", 20000),
                new Album("jimmy", "kiss goodbye", 16000)
        };

        Map<String, Album> topHits = Arrays.stream(albums).collect(
                toMap(Album::getArtist, a -> a, BinaryOperator.maxBy(Comparator.comparing(Album::getSales)))
        );
        System.out.println(topHits);
    }
}

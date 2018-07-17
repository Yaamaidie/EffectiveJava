package code.no45;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    public enum Suit {
        HEART, SPADE, DIAMOND, CLUB
    }

    public enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    private final Suit suit;
    private final Rank rank;

    public Card (Suit suit, Rank rank) {
        this.suit = suit;
        this.rank =rank;
    }

    @Override
    public String toString() {
        return "("+ suit + "," + rank +")";
    }

    public static void main(String[] args) {
        System.out.println(newDeckByIteration());
        System.out.println(newDeckByStream());
    }

    //迭代生成52张牌
    private static List<Card> newDeckByIteration() {
        List<Card> result = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                result.add(new Card(suit, rank));
            }
        }
        return result;
    }

    //基于流生成52张牌
    private static List<Card> newDeckByStream() {
        return Stream.of(Suit.values())
                .flatMap(suit ->
                        Stream.of(Rank.values())
                                .map(rank -> new Card(suit, rank)))
                .collect(Collectors.toList());
    }
}

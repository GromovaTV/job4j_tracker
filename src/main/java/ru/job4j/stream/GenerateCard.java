package ru.job4j.stream;

import java.util.stream.Stream;

public class GenerateCard {
    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_6, V_7, V_8
    }

    public class Card {
        private Suit suit;
        private Value value;

        public Card(Suit suit, Value value) {
            this.suit = suit;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(valueS -> Stream.of(Value.values())
                        .map(valueV -> valueS + " " + valueV))
                .forEach(System.out::println);
    }
}

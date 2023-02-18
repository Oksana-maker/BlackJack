package org.itstep;

import java.util.Arrays;

import static org.itstep.Rank.*;
import static org.itstep.Suit.*;

public class Deck {
    public static class Card {
        private Suit suit;
        private Rank rank;
        private boolean faceUp;

        public Card(Suit suit, Rank rank) {
            this.suit = suit;
            this.rank = rank;
        }

        public Suit getSuit() {
            return suit;
        }

        public Rank getRank() {
            return rank;
        }

        public boolean isFaceUp() {
            return faceUp;
        }

        public void faceUp() {
            faceUp = true;
        }

        public void faceDown() {
            faceUp = false;
        }


        @Override
        public String toString() {
            String print;
            if (rank.getMeaning() > 10) {
                print = String.valueOf((char) rank.getMeaning());
            } else {
                print = String.valueOf(rank.getMeaning());
            }
            switch (suit) {
                case DIAMOND -> {
                    return print + "D";//String.valueOf((char)DIAMOND.getView());
                }
                case HEART -> {
                    return print + "H";//String.valueOf((char)HEART.getView());
                }
                case SPADE -> {
                    return print + "S";//String.valueOf((char)SPADE.getView());
                }
                default -> {
                    return print + "C";// String.valueOf((char)CLUB.getView());
                }
            }
        }
    }

    private Card[] carts = new Card[0];
    private static Suit[] suits = new Suit[]{HEART, DIAMOND, CLUB, SPADE};
    private static Rank[] ranks = new Rank[]{_2_, _3_, _4_, _5_, _6_, _7_, _8_, _9_, _10_, JACK, QUEEN, KING, ACE};

    public Deck() {
        buildCart();
    }

    private Card[] buildCart() {
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                carts = Arrays.copyOf(carts, carts.length + 1);
                carts[carts.length - 1] = new Card(suits[j], ranks[i]);
            }
        }
        return carts;
    }

    public Card[] getCarts() {
        return carts;
    }

    public Card getRenamed(int idx) {
        if (idx < carts.length) {
            return carts[idx];
        } else {
            return null;
        }
    }

    public void replace(int idx, Card carta) {
        carts[idx] = carta;
    }

    public int size() {
        int count = 0;
        for (Card c : carts) {
            count++;
        }
        return count;
    }

    public Card removeFromFront() {
        if (carts.length > 0) {
            Object o;
            o = carts[0];
            removeCart(carts[0]);
            Card carta = (Card) o;
            return carta;
        } else {
            return null;
        }

    }

    public void removeCart(Card carta) {
        Card[] carts1 = new Card[carts.length - 1];
        int idx = 0;
        for (Card c : carts) {
            if (!c.equals(carta)) {
                carts1[idx] = c;
                idx++;
            }
        }
        carts = carts1;
    }
}

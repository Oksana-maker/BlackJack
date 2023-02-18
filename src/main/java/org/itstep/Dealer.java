package org.itstep;

import java.util.Random;

public class Dealer extends Person {
    private Deck deck;

    public Dealer(String name, Deck deck) {
        super(name);
        this.deck = deck;
    }

    public void shuffle() {
        Random random = new Random();
        int num = deck.size();
        for (int i = 0; i < num; i++) {
            int idx = (int) (random.nextInt(0, num));
            Deck.Card cardI = (Deck.Card) deck.getRenamed(i);
            Deck.Card cardIdx = (Deck.Card) deck.getRenamed(idx);
            deck.replace(i, cardIdx);
            deck.replace(idx, cardI);
        }
    }

    public Deck.Card dealCard() {
        if (deck.size() > 0) {
            return deck.removeFromFront();
        }
        return null;
    }
}

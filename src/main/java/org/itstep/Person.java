package org.itstep;

import java.util.Arrays;

public abstract class Person {
    private int allScore;
    private int money;
    private String name;
    private Deck.Card[] cards = new Deck.Card[0];

    public Person(String name) {
        this.allScore = 1000;
        this.money = 1000;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCard(Deck.Card card) {
        cards = Arrays.copyOf(cards, cards.length + 1);
        cards[cards.length - 1] = card;
    }

    public Deck.Card[] getCards() {
        return cards;
    }

    public void newPlay() {
        cards = new Deck.Card[0];
    }

    public int getAllScore() {
        return allScore;
    }

    public int getMoney() {
        return money;
    }

    public int addScore() {
        this.allScore = getAllScore() + 100;
        return this.allScore;
    }

    public void subtractScore() {
        if (this.allScore <= 0) {
            this.allScore = 0;
        } else {
            this.allScore = getAllScore() - 100;
        }

    }

    public void addMoney() {
        this.money = getMoney() + 500;
    }

    public void subtractMoney() {
        this.money = getMoney() - 500;
    }
}

package org.itstep;

import java.util.Arrays;

import static org.itstep.Rank.*;
import static org.itstep.Suit.*;

public class CartReader {

    public static void main(String[] args) {
        Deck deck = new Deck();
        Deck.Card card = new Deck.Card(HEART, _10_);
        System.out.println(deck.size());
        Deck.Card[] cards = deck.getCarts();
//        deck.removeCart(cards[6]);
        Dealer dealer = new Dealer("John", deck);
        dealer.shuffle();
        dealer.dealCard();
        Player player = new Player("Sting");
        Computer computer = new Computer("Alisa");
        BlackJack blackJack = new BlackJack(player, dealer, computer);
        blackJack.startPlay();
    }
}

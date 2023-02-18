package org.itstep;

import java.util.Arrays;
import java.util.Scanner;

import static org.itstep.Rank.ACE;

public class BlackJack {
    private Player player;
    private Dealer dealer;
    private Computer computer;

    public BlackJack(Player player, Dealer dealer, Computer computer) {
        this.player = player;
        this.dealer = dealer;
        this.computer = computer;
    }

    public void startPlay() {
        dealer.shuffle();
        for (int i = 0; i < 2; i++) {
            computer.addCard(dealer.dealCard());
            player.addCard(dealer.dealCard());
        }
        continuation();
    }

    public int scoring(Deck.Card... cards) {
        int points = 0;
        for (Deck.Card c : cards) {
            if (cards.length > 2) {
                if (c.getRank() == ACE) {
                    points += 1;
                } else
                    points += c.getRank().getPoints();
            } else {
                points += c.getRank().getPoints();
            }

        }
        return points;
    }

    public void continuation() {
        System.out.println(Arrays.toString(player.getCards()));
        Scanner scanner = new Scanner(System.in);
        int stop = scanner.nextInt();
        while (stop != 0) {
            System.out.println("Would you like to take card?");
            System.out.println("[1] - take a card\n[2] - count points");
            int s = scanner.nextInt();
            switch (s) {
                case 1 -> {
                    player.addCard(dealer.dealCard());
                    System.out.println(Arrays.toString(player.getCards()));
                    if (scoring(player.getCards()) > 21) {
                        System.out.println("You lose (");
                        System.out.println("Player : " + scoring(player.getCards()));
                        System.out.println("Computer : " + scoring(computer.getCards()));
                        stop = 0;
                    }
                    break;
                }
                case 2 -> {
                    System.out.println("Player : " + scoring(player.getCards()));
                    System.out.println("Computer : " + scoring(computer.getCards()));
                    if (scoring(player.getCards()) <= 21 & scoring(computer.getCards()) <= 21) {
                        if (scoring(player.getCards()) > scoring(computer.getCards())) {
                            System.out.println("You won!!!");
                            player.addScore();
                            player.addMoney();
                            computer.subtractScore();
                            computer.subtractMoney();
                            stop = 0;
                            break;
                        } else if (scoring(player.getCards()) == scoring(computer.getCards())) {
                            System.out.println("Dead heat)");
                            stop = 0;
                            break;
                        } else {
                            player.subtractScore();
                            player.subtractMoney();
                            computer.addScore();
                            computer.addMoney();
                            System.out.println("You lose (");
                            stop = 0;
                            break;
                        }
                    } else if (scoring(player.getCards()) == scoring(computer.getCards())) {
                        System.out.println("Dead heat)");
                        stop = 0;
                        break;
                    } else if (scoring(player.getCards()) > 21) {
                        player.subtractScore();
                        player.subtractMoney();
                        computer.addScore();
                        computer.addMoney();
                        System.out.println("You lose (");
                        stop = 0;
                        break;
                    } else {
                        System.out.println("You won!!!");
                        player.addScore();
                        player.addMoney();
                        computer.subtractScore();
                        computer.subtractMoney();
                        stop = 0;
                        break;
                    }
                }
                default -> {
                    System.out.println("Choose an action!");
                    break;
                }
            }
        }
        System.out.println("Your money : " + player.getMoney());
        System.out.println("Your score : " + player.getAllScore());
        replay();

    }

    public void replay() {
        System.out.println("Game over!!!");
        System.out.println("Do you want to play again?");
        System.out.println("[1] - Yes\n[2] - No");
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        switch (p) {
            case 1 -> {
                player.newPlay();
                computer.newPlay();
                dealer.shuffle();
                startPlay();
                break;
            }
            case 2 -> {
                break;
            }
            default -> {
                System.out.println("Choose an action!");
                break;
            }
        }
    }
}

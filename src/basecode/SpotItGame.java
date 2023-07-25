/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basecode;

/**
 *
 * @author harma
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SpotItGame extends Game {
    private ArrayList<Card> deck;
    private GroupOfCards groupOfCards;

    public SpotItGame(String name) {
        super(name);
        deck = new ArrayList<>();
        groupOfCards = new GroupOfCards(4);
    }

    private void initializeDeck() {
        String[] symbols = {"Heart", "Star", "Smiley", "Moon", "Sun", "Triangle", "Square", "Circle", "Diamond", "Clover", "Cross", "Arrow"};
        for (String symbol : symbols) {
            deck.add(new SpotItCard(symbol));
        }
        Collections.shuffle(deck);
    }

    private void dealCards() {
        for (Player player : getPlayers()) {
            ArrayList<Card> playerCards = new ArrayList<>();
            for (int i = 0; i < groupOfCards.getSize(); i++) {
                playerCards.add(deck.remove(0));
            }
            ((SpotItPlayer) player).setCards(playerCards);
        }
    }

    private void playRound() {
        Card cardToMatch = deck.get(0);
        System.out.println("Card to match: " + cardToMatch);

        for (Player player : getPlayers()) {
            SpotItPlayer spotItPlayer = (SpotItPlayer) player;
            System.out.print(spotItPlayer.getName() + ", do you have this card? (yes or no): ");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.nextLine().trim().toLowerCase();

            while (!response.equals("yes") && !response.equals("no")) {
                System.out.print("Invalid response. Please enter 'yes' or 'no': ");
                response = scanner.nextLine().trim().toLowerCase();
            }

            if (response.equals("yes")) {
                if (spotItPlayer.getCards().contains(cardToMatch)) {
                    System.out.println("Correct! You get a point!");
                    spotItPlayer.incrementScore();
                } else {
                    System.out.println("Oops! You don't have this card.");
                }
            } else {
                if (spotItPlayer.getCards().contains(cardToMatch)) {
                    System.out.println("Oops! You have this card, but you said 'no'.");
                } else {
                    System.out.println("Correct! You don't have this card.");
                    spotItPlayer.incrementScore();
                }
            }
        }
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Spot It Game!");
        System.out.println("Rules: Each player will be given 4 cards. A card with a symbol will be revealed, and each player has to check if they have the same symbol in their cards.");
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name for Player " + (i + 1) + ": ");
            String playerName = scanner.nextLine();
            getPlayers().add(new SpotItPlayer(playerName));
        }

        initializeDeck();
        dealCards();

        boolean continueGame = true;
        while (continueGame) {
            groupOfCards.shuffle();
            playRound();

            System.out.print("Do you want to continue? (yes or no): ");
            String response = scanner.nextLine().trim().toLowerCase();

            while (!response.equals("yes") && !response.equals("no")) {
                System.out.print("Invalid response. Please enter 'yes' or 'no': ");
                response = scanner.nextLine().trim().toLowerCase();
            }

            continueGame = response.equals("yes");
        }

        declareWinner();
    }

    @Override
    public void declareWinner() {
        System.out.println("\nGame over! Final Scores:");
        for (Player player : getPlayers()) {
            SpotItPlayer spotItPlayer = (SpotItPlayer) player;
            System.out.println(spotItPlayer.getName() + ": " + spotItPlayer.getScore());
        }
    }
}


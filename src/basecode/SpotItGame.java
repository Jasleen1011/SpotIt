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
import java.util.Scanner;
import java.util.Collections;

public class SpotItGame {
    private ArrayList<SpotItPlayer> players;
    private ArrayList<SpotItCard> cardDeck; // Deck for both center card and player's cards
    private SpotItCard centerCard;
    private int currentRound;
    private static final int MAX_ROUNDS = 6;

    public SpotItGame(String spot_It_Game) {
        players = new ArrayList<>();
        cardDeck = new ArrayList<>();
        centerCard = null;
        currentRound = 0;
        initializeDeck();
    }

    private void initializeDeck() {
        // Initialize card deck with 10 copies of each symbol
        for (int i = 0; i < 10; i++) {
            for (String symbol : SpotItCard.SYMBOLS) {
                cardDeck.add(new SpotItCard(symbol));
            }
        }
        Collections.shuffle(cardDeck);
    }

    private void generateCenterCard() {
        if (!cardDeck.isEmpty()) {
            centerCard = cardDeck.remove(0);
        } else {
            System.out.println("Card deck is empty. No more cards available.");
        }
    }

    public ArrayList<SpotItPlayer> getPlayers() {
        return players; // Return the list of SpotItPlayers
    }

    private void playRound() {
        currentRound++;
        System.out.println("\n--- Round " + currentRound + " ---");
        generateCenterCard();

        System.out.println("Center Card: " + centerCard);

        for (SpotItPlayer player : players) {
            SpotItPlayer spotItPlayer = (SpotItPlayer) player;

            // Generate new cards for the player in each round
            spotItPlayer.generateCards(cardDeck); // Use the single cardDeck

            ArrayList<SpotItCard> playerCards = spotItPlayer.getCards();
            System.out.println(spotItPlayer.getName() + "'s Cards: " + playerCards);

            System.out.print(spotItPlayer.getName() + ", do you have a matching card? (yes or no): ");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.nextLine().trim().toLowerCase();

            while (!response.equals("yes") && !response.equals("no")) {
                System.out.print("Invalid response. Please enter 'yes' or 'no': ");
                response = scanner.nextLine().trim().toLowerCase();
            }

            boolean hasMatchingCard = spotItPlayer.hasMatchingCard(centerCard);
            if ((response.equals("yes") && hasMatchingCard) || (response.equals("no") && !hasMatchingCard)) {
                System.out.println("Correct! You get a point!");
                spotItPlayer.incrementScore();
            } else {
                System.out.println("Oops! You don't have a matching card.");
            }

            System.out.println("--- Round End ---");
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Spot It Game!");
        System.out.println("Rules: Each player will be given 4 cards. A card with a symbol will be revealed, and each player has to check if they have the same symbol in their cards.");
        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        // Initialize the players ArrayList
        players.clear();
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter name for Player " + (i + 1) + ": ");
            String playerName = scanner.nextLine();
            players.add(new SpotItPlayer(playerName));
        }

        boolean continueGame = true;
        while (continueGame && currentRound < MAX_ROUNDS) {
            for (SpotItPlayer player : players) {
                player.generateCards(cardDeck); // Generate cards from the card deck
                playRound(); // Call the playRound method without passing arguments
            }

            System.out.print("Do you want to continue to the next round? (yes or no): ");
            String response = scanner.nextLine().trim().toLowerCase();

            while (!response.equals("yes") && !response.equals("no")) {
                System.out.print("Invalid response. Please enter 'yes' or 'no': ");
                response = scanner.nextLine().trim().toLowerCase();
            }
            continueGame = response.equals("yes");
        }

        System.out.println("\nGame over! Final Scores:");
        for (SpotItPlayer player : players) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
    }

    public static void main(String[] args) {
        SpotItGame game = new SpotItGame("Spot It Game");
        game.play();
    }
}

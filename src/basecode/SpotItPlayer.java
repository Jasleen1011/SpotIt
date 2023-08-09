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

public class SpotItPlayer extends Player {
    private final ArrayList<SpotItCard> cards;
    private int score;

    public SpotItPlayer(String name) {
        super(name);
        cards = new ArrayList<>();
        score = 0;
    }

    public ArrayList<SpotItCard> getCards() {
        return cards;
    }

    public void generateCards(ArrayList<SpotItCard> playerCardDeck) {
        if (playerCardDeck.size() >= 4) {
            cards.clear();
            for (int i = 0; i < 4; i++) {
                cards.add(playerCardDeck.remove(0));
            }
        } else {
            System.out.println("Insufficient cards in the player's card deck.");
        }
    }

    public boolean hasMatchingCard(SpotItCard centerCardSymbol) {
        for (SpotItCard card : cards) {
            if (card.hasSymbolOnCard(centerCardSymbol)) {
                return true;
            }
        }
        return false;
    }

    public void incrementScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

    @Override
    public void play() {
        // Implement the play method here if needed
    }
}

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
    private ArrayList<Card> cards;
    private int score;

    public SpotItPlayer(String name) {
        super(name);
        cards = new ArrayList<>();
        score = 0;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
    
    public void setCards(ArrayList<Card> cards) {
    this.cards.addAll(cards);
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++;
    }

    @Override
    public void play() {
        // No additional play logic needed here
    }
}


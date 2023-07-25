/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basecode;

/**
 *
 * @author harma
 */
public class SpotItCard extends Card{

    private String symbol;

    public SpotItCard(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Returns the symbol of the SpotItCard.
     *
     * @return the symbol of the card.
     */
    @Override
    public String toString() {
        return symbol;
    }
}

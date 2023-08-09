/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basecode;

/**
 *
 * @author harma
 */
public class SpotItCard {
    // Define an array of symbols for SpotItCard
    public static final String[] SYMBOLS = {
        "heart", "triangle", "rectangle", "circle", "spade", 
        "dot", "diamond", "moon", "star", "club"
    };

    private String symbol;

    public SpotItCard(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }


    public boolean hasSymbolOnCard(SpotItCard symbol) {
        return this.symbol.equals(symbol);
    }

    @Override
    public String toString() {
        return symbol;
    }
}

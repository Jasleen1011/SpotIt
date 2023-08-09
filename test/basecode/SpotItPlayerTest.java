/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package basecode;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author harma
 */
public class SpotItPlayerTest {
    
    public SpotItPlayerTest() {
    }
    
  /*  @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }*/
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getCards method, of class SpotItPlayer.
     */
    @Test
    public void testGetCardsgood() {
        System.out.println("getCards");
        SpotItPlayer instance = null;
        ArrayList<Card> expResult = null;
        ArrayList<Card> result = instance.getCards();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }
    
    

    /**
     * Test of setCards method, of class SpotItPlayer.
     */
    @Test
    public void testSetCards() {
        System.out.println("setCards");
        ArrayList<Card> cards = null;
        SpotItPlayer instance = null;
        instance.setCards(cards);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getScore method, of class SpotItPlayer.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        SpotItPlayer instance = null;
        int expResult = 0;
        int result = instance.getScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of incrementScore method, of class SpotItPlayer.
     */
    @Test
    public void testIncrementScore() {
        System.out.println("incrementScore");
        SpotItPlayer instance = null;
        instance.incrementScore();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of play method, of class SpotItPlayer.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        SpotItPlayer instance = null;
        instance.play();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

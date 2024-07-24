package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import versions.Version1;

/**
 * Unit test for simple App.
 */
public class Tests
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void Version2()
    {
    	Version1 game = new Version1();
    	game.setSeed(0);
    	game.initializeGame();
        assertEquals( "Player 1 wins the game.", game);
    }
}
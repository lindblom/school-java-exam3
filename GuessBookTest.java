

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GuessBookTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GuessBookTest
{
    /**
     * Default constructor for test class GuessBookTest
     */
    public GuessBookTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testCountAfterAddingGuess()
    {
        GuessBook gb = new GuessBook();
        Word word = new Word("hej", "hello");
        gb.addGuess(word, "test");
        assertTrue(gb.countGuesses(word) == 1);
    }
    
    @Test
    public void testCountAfterAddingAnotherGuess()
    {
        GuessBook gb = new GuessBook();
        Word word = new Word("hej", "hello");
        gb.addGuess(word, "test");
        gb.addGuess(word, "test2");
        assertTrue(gb.countGuesses(word) == 2);
    }
    
    @Test
    public void testGetGuessesWithOneWord()
    {
        GuessBook gb = new GuessBook();
        Word word = new Word("hej", "hello");
        gb.addGuess(word, "test");
        assertTrue(gb.getGuesses(word).equals("test"));
    }
}

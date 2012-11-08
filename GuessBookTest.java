import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GuessBookTest.
 *
 * @author Christopher Lindblom 
 * @version 2012-11-08
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
    
    /**
     * Test: Check to see that the first guess counts.
     */
    @Test
    public void testCountAfterAddingGuess()
    {
        GuessBook gb = new GuessBook();
        Word word = new Word("hej", "hello");
        gb.addGuess(word, "test");
        assertTrue(gb.countGuesses(word) == 1);
    }
    
    /**
     * Test: Check to see that the later words count.
     */
    @Test
    public void testCountAfterAddingAnotherGuess()
    {
        GuessBook gb = new GuessBook();
        Word word = new Word("hej", "hello");
        gb.addGuess(word, "test");
        gb.addGuess(word, "test2");
        assertTrue(gb.countGuesses(word) == 2);
    }
    
    /**
     * Test: Check to see that getGuesses returns the correct format (one word)
     */
    @Test
    public void testGetGuessesWithOneWord()
    {
        GuessBook gb = new GuessBook();
        Word word = new Word("hej", "hello");
        gb.addGuess(word, "test");
        assertTrue(gb.getGuesses(word).equals("test"));
    }
    
    /**
     * Test: Check to see that getGuesses returns the correct format (2+ word)
     */
    @Test
    public void testGetGuessesWithMoreWords()
    {
        GuessBook gb = new GuessBook();
        Word word = new Word("hej", "hello");
        gb.addGuess(word, "test");
        gb.addGuess(word, "test2");
        assertTrue(gb.getGuesses(word).equals("test, test2"));
    }
    
    /**
     * Test: Check to see that the wasCorrect returns true if the correct guess was among the guesses.
     */
    @Test
    public void testWasCorrect()
    {
        GuessBook gb = new GuessBook();
        Word word = new Word("hej", "hello");
        gb.addGuess(word, "test");
        gb.addGuess(word, "hello");
        assertTrue(gb.wasCorrect(word));
    }
    
    /**
     * Test: Check to see that the wasCorrect returns false if the correct guess wasn't among the guesses.
     */
    @Test
    public void testWasntCorrect()
    {
        GuessBook gb = new GuessBook();
        Word word = new Word("hej", "hello");
        gb.addGuess(word, "test");
        gb.addGuess(word, "y0");
        assertFalse(gb.wasCorrect(word));
    }
}

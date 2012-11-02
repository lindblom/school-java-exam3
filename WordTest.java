

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WordTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WordTest
{
    /**
     * Default constructor for test class WordTest
     */
    public WordTest()
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
    public void testIsCorrect()
    {
        Word word = new Word("hej", "hello");
        assertTrue(word.isCorrect("hello"));
    }
    
    @Test
    public void testIsNotCorrectWhenWrong()
    {
        Word word = new Word("hej", "hello");
        assertFalse(word.isCorrect("hej"));
    }
    
    @Test
    public void testIsCorrectWithDifferentCase()
    {
        Word word = new Word("hej", "hello");
        assertTrue(word.isCorrect("HELLO"));
    }
}


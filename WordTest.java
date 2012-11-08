import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WordTest.
 *
 * @author Christopher Lindblom 
 * @version 2012-11-08
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

    /**
     * Test: that the isCorrect method works when correct is given.
     */
    @Test
    public void testIsCorrect()
    {
        Word word = new Word("hej", "hello");
        assertTrue(word.isCorrect("hello"));
    }
    
    /**
     * Test: that the isCorrect method works when correct is not given.
     */
    @Test
    public void testIsNotCorrectWhenWrong()
    {
        Word word = new Word("hej", "hello");
        assertFalse(word.isCorrect("hej"));
    }
    
    /**
     * Test: test that isCorrect isn't case sentitive.
     */
    @Test
    public void testIsCorrectWithDifferentCase()
    {
        Word word = new Word("hej", "hello");
        assertTrue(word.isCorrect("HELLO"));
    }
    
    /**
     * Test: that toString returns the correct format.
     */
    @Test
    public void testToStringReturnsWordAndAnswer()
    {
        Word word = new Word("hej", "hello");
        assertTrue(word.toString().equals("hej - hello"));
    }
}


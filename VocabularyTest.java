

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VocabularyTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class VocabularyTest
{
    /**
     * Default constructor for test class VocabularyTest
     */
    public VocabularyTest()
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
    public void testNewVocabulariesHaveNoWords()
    {
        Vocabulary vocabulary = new Vocabulary();
        assertEquals("New vocabulary should not contain any words.", 0, vocabulary.wordCount());
    }
    
    @Test
    public void testAddingWordToVocabularyShouldCount()
    {
        Vocabulary vocabulary = new Vocabulary();
        vocabulary.addWord("hej", "hello");
        assertEquals("When a word has been added it should show.", 1, vocabulary.wordCount());
    }
    
    @Test
    public void testRemovingWordUsingWord()
    {
        Vocabulary vocabulary = new Vocabulary();
        vocabulary.addWord("hej", "hello");
        vocabulary.removeWord("hej");
        assertEquals("Word should have been removed.", 0, vocabulary.wordCount());
    }
    
    @Test
    public void testRemoveRandom()
    {
        Vocabulary voc = new Vocabulary();
        voc.addWord("hej", "hello");
        voc.removeRandomWord();
        assertTrue(voc.wordCount() == 0);
    }
}

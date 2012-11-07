

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VocabularyTest.
 *
 * @author Christopher Lindblom 
 * @version 2012-11-08
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
    public void testAddingWordToVocabularyShouldReturnWordAsString()
    {
        Vocabulary vocabulary = new Vocabulary();
        String result = vocabulary.addWord("hej", "hello");
        assertTrue(result.equals("hej - hello"));
    }
    
    @Test
    public void testRemovingWord()
    {
        Vocabulary vocabulary = new Vocabulary();
        vocabulary.addWord("hej", "hello");
        String result = vocabulary.removeWord(0);
        assertTrue(result.equals("hej - hello"));
    }
    
    @Test
    public void testRemovingWordThatDoesntExist()
    {
        Vocabulary vocabulary = new Vocabulary();
        String result = vocabulary.removeWord(0);
        assertNull(result);
    }
    
    @Test
    public void testRemoveRandom()
    {
        Vocabulary voc = new Vocabulary();
        voc.addWord("hej", "hello");
        voc.removeRandomWord();
        assertTrue(voc.wordCount() == 0);
    }
    
    @Test
    public void testGetWordsArray()
    {
        Vocabulary voc = new Vocabulary();
        voc.addWord("hej", "hello");
        Word[] wordArray = voc.getWordsArray();
        assertTrue(wordArray.length == 1);
    }
}

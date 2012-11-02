

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestVocabularyTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestVocabularyTest
{
    /**
     * Default constructor for test class TestVocabularyTest
     */
    public TestVocabularyTest()
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
    public void testLoadShouldBeTrueWhenTenWordsIsInTheVocabulary()
    {
        Vocabulary voc = getVocabularyWithWords(10);
        
        TestVocabulary test = new TestVocabulary();
        assertTrue(test.load(voc));
    }
    
    @Test
    public void testLoadShouldBeFalseWhenLessThanTenWordsIsInTheVocabulary()
    {
        Vocabulary voc = getVocabularyWithWords(5);
        
        TestVocabulary test = new TestVocabulary();
        assertFalse(test.load(voc));
    }
    
    @Test
    public void testLoadShouldBeTrueWhenMoreThanTenWordsIsInTheVocabulary()
    {
        Vocabulary voc = getVocabularyWithWords(25);
        
        TestVocabulary test = new TestVocabulary();
        assertTrue(test.load(voc));
    }
    
    private Vocabulary getVocabularyWithWords(int inWords)
    {
        Vocabulary voc = new Vocabulary();
        for(int i = 1; i <= inWords; i++)
        {
            voc.addWord("hej" + i, "hello" + i);
        }
        
        return voc;
    }
}

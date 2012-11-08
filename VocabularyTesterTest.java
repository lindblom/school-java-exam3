import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TestVocabularyTest.
 *
 * @author Christopher Lindblom 
 * @version 2012-11-08
 */
public class VocabularyTesterTest
{
    /**
     * Default constructor for test class TestVocabularyTest
     */
    public VocabularyTesterTest()
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
     * Test: that load is true when ten words is in the vocabulary
     */
    @Test
    public void testLoadShouldBeTrueWhenTenWordsIsInTheVocabulary()
    {
        Vocabulary voc = getVocabularyWithWords(10);
        
        VocabularyTester tester = new VocabularyTester();
        assertTrue(tester.load(voc));
    }
    
    /**
     * Test: that load is false when less than ten words is in the vocabulary
     */
    @Test
    public void testLoadShouldBeFalseWhenLessThanTenWordsIsInTheVocabulary()
    {
        Vocabulary voc = getVocabularyWithWords(5);
        
        VocabularyTester tester = new VocabularyTester();
        assertFalse(tester.load(voc));
    }
    
    /**
     * Test: that load is true when 10+ words is in the vocabulary
     */
    @Test
    public void testLoadShouldBeTrueWhenMoreThanTenWordsIsInTheVocabulary()
    {
        Vocabulary voc = getVocabularyWithWords(25);
        
        VocabularyTester tester = new VocabularyTester();
        assertTrue(tester.load(voc));
    }
    
    /**
     * A factory for creating vocabularies for the tests.
     * 
     * @params  int     the number of words you want in the vocabulary
     * @return          the newly created vocabulary
     */
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


/**
 * Write a description of class TestVocabulary here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestVocabulary
{
    // instance variables - replace the example below with your own
    private Vocabulary mVoc;

    /**
     * Constructor for objects of class TestVocabulary
     */
    public TestVocabulary()
    {
        // initialise instance variables
        mVoc = new Vocabulary();
    }
    
    public boolean load(Vocabulary inVoc)
    {
        if(inVoc.wordCount() >= 10)
        {
            mVoc = inVoc;
        } 
        
        while(mVoc.wordCount() > 10)
        {
            mVoc.removeRandomWord();
        }
        
        return mVoc.wordCount() == 10;
    }
}

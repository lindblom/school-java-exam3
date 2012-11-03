
/**
 * Write a description of class VocabularyTrainerUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VocabularyTrainerProgram
{
    // instance variables - replace the example below with your own
    private VocabularyTester mTester;
    private Vocabulary mVoc;

    /**
     * Constructor for objects of class VocabularyTrainerUI
     */
    public VocabularyTrainerProgram()
    {
        // initialise instance variables
        mTester = new VocabularyTester();
        mVoc = new Vocabulary();
        seedVocabulary();
    }
    
    public void run()
    {
        VocabularyTrainerState state = VocabularyTrainerState.RUNNING;
        
        while(state != VocabularyTrainerState.EXIT)
        {
            state = VocabularyTrainerState.EXIT;
        }
    }
    
    private void seedVocabulary()
    {
        // ten often misspelled words.
        mVoc.addWord("andas", "breathe");
        mVoc.addWord("garantera", "guarantee");
        mVoc.addWord("försvinna", "disappear");
        mVoc.addWord("kommer", "coming");
        mVoc.addWord("genera", "embarrass");
        mVoc.addWord("överdriva", "exaggerate");
        mVoc.addWord("kyrkogård", "cemetery");
        mVoc.addWord("ensamhet", "loneliness");
        mVoc.addWord("innertak", "ceiling");
        mVoc.addWord("entreprenör", "entrepreneur");
    }
}

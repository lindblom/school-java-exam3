
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
        //mManager = new VocabularyManager();
        mVoc = new Vocabulary();
        seedVocabulary();
    }
    
    public void run()
    {
        VocabularyTrainerState state;
        
        state = runMainMenu();
        
        while(state != VocabularyTrainerState.EXIT)
        {
            state = runState(state);
        }
    }
    
    private VocabularyTrainerState runMainMenu()
    {
        printMainMenu();
        return handleMainMenuInput(InputHandler.get());
    }
    
    private void printMainMenu()
    { 
        System.out.println("Huvudmenyn");   
    }
    
    private VocabularyTrainerState handleMainMenuInput(String inUserInput)
    {
        VocabularyTrainerState newState = VocabularyTrainerState.MAIN_MENU;
        
        if(inUserInput.equals("test"))
        {
            newState = VocabularyTrainerState.RUN_TEST;
        }
        else if(inUserInput.equals("hantera"))
        {
            newState = VocabularyTrainerState.MANAGE_VOCABULARY;
        }
        else if(inUserInput.equals("avsluta"))
        {
            newState = VocabularyTrainerState.EXIT;
        }
        else
        {
            System.out.println("Ogiltig inmatning");
        }
        
        return newState;
    }
    
    private VocabularyTrainerState runState(VocabularyTrainerState inState)
    {
        VocabularyTrainerState newState = VocabularyTrainerState.MAIN_MENU;
        
        switch(inState)
        {
            case MAIN_MENU:
                newState = runMainMenu();
                break;
            case MANAGE_VOCABULARY:
                mVoc = new VocabularyManager(mVoc).manage();
                break;
            case RUN_TEST:
                if(mTester.load(mVoc))
                {
                    System.out.println("Perfekt nu kör vi testet.");
                    //mTester.run();
                }
                else
                {
                    System.out.println("Det måste finnas minst 10 glosor i glosboken.");
                    newState = VocabularyTrainerState.MANAGE_VOCABULARY;
                }
                
                break;
        }
        
        return newState;
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


/**
 * Write a description of class VocabularyTrainerUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VocabularyTrainerProgram
{
    // instance variables - replace the example below with your own
    private Vocabulary mVoc;

    /**
     * Constructor for objects of class VocabularyTrainerUI
     */
    public VocabularyTrainerProgram()
    {
        // initialise instance variables
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
    
    private void printWelcomeMessage()
    {
        System.out.println("Hej och välkommen till glosövningsprogrammet VocabularyTrainer!");
        System.out.println("Programmet är förladdat med svensk-engelska glosor för");
        System.out.println("några ord som ofta felstavas.\n";
    }
    
    private VocabularyTrainerState runMainMenu()
    {
        printMainMenu();
        return handleMainMenuInput(InputHandler.get());
    }
    
    private void printMainMenu()
    { 
        System.out.println("Vad vill du göra?");
        System.out.println("test    : för köra ett glostest.");
        System.out.println("hantera : för att lägga till/ta bort/lista glosor.");
        System.out.println("avsluta : för att avsluta programmet.");
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
                VocabularyTester tester = new VocabularyTester();
                if(tester.load(mVoc))
                {
                    tester.run();
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

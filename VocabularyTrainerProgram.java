
/**
 * VocabularyTrainerProgram is a program to test word spelling.
 * 
 * @author Christopher Lindblom 
 * @version 2012-11-08
 */
public class VocabularyTrainerProgram
{
    // instance variable to hold the vocabulary
    private Vocabulary mVoc;

    /**
     * Constructor for objects of class VocabularyTrainerProgram
     */
    public VocabularyTrainerProgram()
    {
        // initialise the vocabulary
        mVoc = new Vocabulary();
        
        // seed the vocabulary with some seed data
        seedVocabulary();
    }
    
    /**
     * The metod to start running the VocabularyTrainer program.
     */
    public void run()
    {
        VocabularyTrainerState state;
        
        printWelcomeMessage();
        
        state = runMainMenu();
        
        while(state != VocabularyTrainerState.EXIT)
        {
            state = runState(state);
        }
    }
    
    /**
     * Prints a welcome message.
     */
    private void printWelcomeMessage()
    {
        System.out.println("Hej och välkommen till glosövningsprogrammet VocabularyTrainer!");
        System.out.println("Programmet är förladdat med svensk-engelska glosor för");
        System.out.println("några ord som ofta felstavas.");
    }
    
    /**
     * Run main menu.
     * 
     * @return  the new state after the menu
     */
    private VocabularyTrainerState runMainMenu()
    {
        printMainMenu();
        return handleMainMenuInput(InputHandler.get());
    }
    
    /**
     * Prints the main menu.
     */
    private void printMainMenu()
    { 
        System.out.println("\nHuvudmenyn - Vad vill du göra?");
        System.out.println("test    : för köra ett glostest.");
        System.out.println("hantera : för att lägga till/ta bort/lista glosor.");
        System.out.println("avsluta : för att avsluta programmet.");
    }
    
    /**
     * Handles input from the main menu.
     * 
     * @param   String  the users input
     */
    private VocabularyTrainerState handleMainMenuInput(String inUserInput)
    {
        // MAIN_MENU is the default new state
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
    
    /**
     * Runs the selected state.
     * 
     * @param   VocabularyTrainerState  the state to run
     * @return                          the new state after the input state has been ran
     */
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
                
                // loads and checks if the vocabulary is valid
                if(tester.load(mVoc))
                {
                    tester.run();
                }
                else
                {
                    // show user a message and send user to management menu
                    System.out.println("Det måste finnas minst 10 glosor i glosboken.");
                    newState = VocabularyTrainerState.MANAGE_VOCABULARY;
                }
                
                break;
        }
        
        return newState;
    }
    
    /**
     * Seeds the vocabulary with ten often misspelled words.
     */
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

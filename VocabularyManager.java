
/**
 * Write a description of class VocabularyManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VocabularyManager
{
    // instance variables - replace the example below with your own
    private Vocabulary mVoc;
    /**
     * Constructor for objects of class VocabularyManager
     */
    public VocabularyManager(Vocabulary inVoc)
    {
        // initialise instance variables
        mVoc = inVoc;
    }

    public Vocabulary manage()
    {
        VocabularyManagerState state = VocabularyManagerState.MAIN_MENU;
        
        while(state != VocabularyManagerState.EXIT)
        {
            state = runState(state);
        }
        return mVoc;
    }
    
    private VocabularyManagerState runMainMenu()
    {
        printMainMenu();
        return handleMainMenuInput(InputHandler.get());
    }
    
    private void printMainMenu()
    {
        System.out.println("Hantera glosboken");
    }
    
    private VocabularyManagerState handleMainMenuInput(String inUserInput)
    {
        VocabularyManagerState newState = VocabularyManagerState.MAIN_MENU;
        if(inUserInput.equals("lägg till"))
        {
            newState = VocabularyManagerState.ADD_WORD;
        }
        else if(inUserInput.equals("ta bort"))
        {
            newState = VocabularyManagerState.REMOVE_WORD;
        }
        else if(inUserInput.equals("lista"))
        {
            newState = VocabularyManagerState.LIST_WORDS;
        }
        else if(inUserInput.equals("tillbaka"))
        {
            newState = VocabularyManagerState.EXIT;
        }
        else
        {
            System.out.println("Ogiltigt val");
        }
        
        return newState;
    }
    
    private VocabularyManagerState runState(VocabularyManagerState inState)
    {
        VocabularyManagerState newState = VocabularyManagerState.MAIN_MENU;
        
        switch(inState)
        {
            case MAIN_MENU:
                newState = runMainMenu();
                break;
                
            case ADD_WORD:
                addAWord();
                break;
                
            case REMOVE_WORD:
                removeAWord();
                break;
                
            case LIST_WORDS:
                printWordList();
                break;
        }
        
        return newState;
    }
    
    private void printWordList()
    {
        System.out.println("Här är alla glosor:");
        System.out.print(mVoc.getWords());
    }
    
    private void listWords()
    {
        System.out.println("Här är alla glosor:");
        printWordList();
    }
    
    private void removeAWord()
    {
        boolean done = false;
        String userInput;
        
        while(!done)
        {
            System.out.println("Vilken glosa vill du ta bort.");
            
            printWordList();
            System.out.println("0: Ångra");
            done = removeAWordInputHandler(InputHandler.get());
        }
        
        
    }
    
    private boolean removeAWordInputHandler(String inUserInput)
    {
        boolean done = false;
        int selected = -1;
        
        try
        {
            selected = Integer.parseInt(inUserInput);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Felaktig inmatning!");
        }
        
        if(selected == 0)
        {
            done = true;
        }
        else
        {
            String removed = mVoc.removeWord(selected - 1);
            if(removed != null)
            {
                System.out.println("Glosan '" + removed + "' är borttagen!");
                done = true;
            }
        }
        
        return done;
    }
    
    private void addAWord()
    {
        System.out.println("Lägg till ett ord.");
    }
}
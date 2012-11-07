
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
        System.out.println("\nHantera glosboken - Vad vill du göra?");
        System.out.println("lista     : för att lista orden i ordboken.");
        System.out.println("lägg till : för att lägga till ord.");
        System.out.println("ta bort   : för att ta bort ett ord.");
        System.out.println("tillbaka  : gå tillbaka till huvudmenyn.");
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
                addAWordDialog();
                break;
                
            case REMOVE_WORD:
                removeAWordDialog();
                break;
                
            case LIST_WORDS:
                listWords();
                break;
        }
        
        return newState;
    }
    
    private void printWordList()
    {
        System.out.print(mVoc.getWords());
    }
    
    private void listWords()
    {
        System.out.println("\nHär är alla glosor:");
        printWordList();
    }
    
    private void removeAWordDialog()
    {
        boolean done = false;
        String userInput;
        
        while(!done)
        {
            System.out.println("\nVilken glosa vill du ta bort.");
            
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
    
    private void addAWordDialog()
    {
        String word, answer, newWord;
        
        
        word = "";
        while(word.length() == 0)
        {
            System.out.println("Hur stavas ordet på svenska?");
            word = InputHandler.get();
        }
        
        answer = "";
        while(answer.length() == 0)
        {
            System.out.println("Hur stavas det på engelska?");
            answer = InputHandler.get();
        }
        
        newWord = mVoc.addWord(word, answer);
        System.out.println("Glosan '" + newWord + "' har lagts till!");
    }
}

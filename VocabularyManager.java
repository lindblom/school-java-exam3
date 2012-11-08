
/**
 * VocabularyManager manages a vocabulary.
 * 
 * @author Christopher Lindblom 
 * @version 2012-11-08
 */
public class VocabularyManager
{
    // instance variable
    private Vocabulary mVoc;
    
    /**
     * Constructor for objects of class VocabularyManager.
     * 
     * @param   Vocabulary  the vocabulary you want to manage
     */
    public VocabularyManager(Vocabulary inVoc)
    {
        // initialise instance variable with paramter
        mVoc = inVoc;
    }
    
    /**
     * Call this method to manage the vocabulary
     * 
     * @return      the resulting vocabulary 
     */
    public Vocabulary manage()
    {
        // sets the starting state
        VocabularyManagerState state = VocabularyManagerState.MAIN_MENU;
        
        // run until state is EXIT
        while(state != VocabularyManagerState.EXIT)
        {
            // Run the state
            state = runState(state);
        }
        
        // return the managed vocabulary
        return mVoc;
    }
    
    /**
     * Run-method for manager main menu.
     * 
     * @return      the new state
     */
    private VocabularyManagerState runMainMenu()
    {
        printMainMenu();
        return handleMainMenuInput(InputHandler.get());
    }
    
    /**
     * Prints the manager main menu.
     */
    private void printMainMenu()
    {
        System.out.println("\nHantera glosboken - Vad vill du göra?");
        System.out.println("lista     : för att lista orden i ordboken.");
        System.out.println("lägg till : för att lägga till ord.");
        System.out.println("ta bort   : för att ta bort ett ord.");
        System.out.println("tillbaka  : gå tillbaka till huvudmenyn.");
    }
    
    /**
     * Handles input from the manager main menu.
     * 
     * @return      the user selected state
     */
    private VocabularyManagerState handleMainMenuInput(String inUserInput)
    {
        // new state defaults to MAIN_MENU
        VocabularyManagerState newState = VocabularyManagerState.MAIN_MENU;
        
        // Set the new state depending on the user input
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
    
    /**
     * Runs the vocabulary manager state.
     * 
     * @param   VocabularyManagerState  the state to be run
     * @return                          the new state
     * 
     */
    private VocabularyManagerState runState(VocabularyManagerState inState)
    {
        // new state defaults to MAIN_MENU
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
    
    /**
     * Prints the word list.
     */
    private void printWordList()
    {
        System.out.print(mVoc.getWords());
    }
    
    /**
     * Prints the list of words with a header.
     */
    private void listWords()
    {
        System.out.println("\nHär är alla glosor:");
        printWordList();
    }
    
    /**
     * The dialog for removing a word.
     */
    private void removeAWordDialog()
    {
        boolean done = false;
        String userInput;
        
        // runs until you have correctly removed a word or have aborted with 0
        while(!done)
        {
            System.out.println("\nVilken glosa vill du ta bort.");
            
            printWordList();
            System.out.println("0: Ångra");
            done = removeAWordInputHandler(InputHandler.get());
        }
        
        
    }
    
    /**
     * Handles input from the remove word dialog.
     * 
     * @return  boolean     true if input was correct
     */
    private boolean removeAWordInputHandler(String inUserInput)
    {
        boolean done = false;
        int selected = -1;
        
        // catch error if user inputs something else than a number
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
            // removeWord returns 0 if selected - 1 was invalid
            String removed = mVoc.removeWord(selected - 1);
            
            if(removed != null)
            {
                System.out.println("Glosan '" + removed + "' är borttagen!");
                done = true;
            }
        }
        
        return done;
    }
    
    /**
     * The dialog for adding a word.
     */
    private void addAWordDialog()
    {
        String word, answer, newWord;
        
        // require word to have at least 1 character
        word = "";
        while(word.length() == 0)
        {
            System.out.println("Hur stavas ordet på svenska?");
            word = InputHandler.get();
        }
        
        // require answer to have at least 1 character
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

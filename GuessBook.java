import java.util.HashMap;
import java.util.Arrays;
/**
 * GuessBook keep track of guesses.
 * 
 * @author Christopher Lindblom 
 * @version 2012-11-08
 */
public class GuessBook
{
    // instance variable
    private HashMap<Word, String[]> mGuesses;

    /**
     * Constructor for objects of class GuessBook
     */
    public GuessBook()
    {
        // initialise instance variable
        mGuesses = new HashMap<Word, String[]>();
    }
    
    /**
     * Get the number of guesses on a word
     * 
     * @param   Word    the word you want to know the guesses for
     * @return          the number of guesses
     */
    public int countGuesses(Word word)
    {
        int result = 0;
        String[] guesses = mGuesses.get(word);
        
        if(guesses != null)
        {
            result = guesses.length;
        }
        
        return result;
    }
    
   /**
    * Add a guess to a word
    * 
    * @param    Word    the word you want to add the guess to
    * @param    String  the guess
    */ 
    public void addGuess(Word inWord, String inGuess)
    {
        String[] currentGuesses = mGuesses.get(inWord);
        String[] guesses = { inGuess };
        
        if(currentGuesses != null)
        {
            guesses = Arrays.copyOf(currentGuesses, currentGuesses.length + 1);
            guesses[guesses.length - 1] = inGuess;
        }
        
        mGuesses.put(inWord, guesses);
    }
    
    /**
     * Get the guesses as a comma separated string.
     * Returns an empty String if the word doen't have any guesses.
     * 
     * @param   Word    the word you want the guesses for
     * @return          the guesses as a comma separated String
     */
    public String getGuesses(Word inWord)
    {
        String[] currentGuesses = mGuesses.get(inWord);
        String result = "";
        
        if(currentGuesses != null)
        {
            for(String guess : currentGuesses)
            {
                if(result.length() == 0)
                {
                    result += guess;
                }
                else
                {
                    result += ", " + guess;
                }
            }
        }
        
        return result;
    }
    
    /**
     * Check to see if there are a correct guess for a word
     * 
     * @param   Word    the word you want to check
     * @return          true if there were a correct guess
     */
    public boolean wasCorrect(Word inWord)
    {
        String[] currentGuesses = mGuesses.get(inWord);
        boolean correct = false;
        for(String guess : currentGuesses)
        {
            correct = correct || inWord.isCorrect(guess);
        }
        
        return correct;
    }
}

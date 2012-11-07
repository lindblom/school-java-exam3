import java.util.HashMap;
import java.util.Arrays;
/**
 * Write a description of class GuessBook here.
 * 
 * @author Christopher Lindblom 
 * @version 2012-11-08
 */
public class GuessBook
{
    // instance variables - replace the example below with your own
    private HashMap<Word, String[]> mGuesses;

    /**
     * Constructor for objects of class GuessBook
     */
    public GuessBook()
    {
        // initialise instance variables
        mGuesses = new HashMap<Word, String[]>();
    }
    
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

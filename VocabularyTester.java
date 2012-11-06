import java.util.HashMap;
import java.util.Arrays;

/**
 * Write a description of class VocabularyTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VocabularyTester
{
    // instance variables - replace the example below with your own
    private Vocabulary mVoc;
    private HashMap<Word, String[]> mGuesses;

    /**
     * Constructor for objects of class TestVocabulary
     */
    public VocabularyTester()
    {
        // initialise instance variables
        mVoc = new Vocabulary();
        mGuesses = new HashMap<Word, String[]>();
    }
    
    public void run()
    {
        System.out.println("Väkommen till glostestet.");
        Word[] testWords = mVoc.getWordsArray();
        for(Word word : testWords)
        {
            askWord(word);
        }
        
        for(Word word : testWords)
        {
            System.out.println("Ordet var: " + word.getWord());
            boolean correct = false;
            
            System.out.print("Du gissade: ");
            for(String guess : mGuesses.get(word))
            {
                System.out.print(guess + " ");
                correct = word.isCorrect(guess);
            }
            
            if(correct)
            {
                System.out.print("-- Vilket var rätt!");
            }
            else
            {
                System.out.print("-- Rätt svar var " + word.getAnswer());
            }
        }
    }
    
    private void askWord(Word word)
    {
        int guesses = 1;
        String guess = "";
        
        while(guesses <= 3 && !word.isCorrect(guess))
        {
            System.out.println("Hur stavas '" + word.getWord() + "' på engelska?");
            guess = InputHandler.get();
            addGuess(word, guess);
            printAnswerFeedback(word.isCorrect(guess));
            guesses++;
        }
        
        if(!word.isCorrect(guess))
        {
            System.out.println("Det rätta svaret var: " + word.getAnswer());
        }
    }
    
    private void addGuess(Word inWord, String inGuess)
    {
        String[] currentGuesses = mGuesses.get(inWord);
        if(currentGuesses == null)
        {
            String[] guesses = { inGuess };
            mGuesses.put(inWord, guesses);
        }
        else
        {
            String[] guesses = Arrays.copyOf(currentGuesses, currentGuesses.length + 1);
            guesses[guesses.length - 1] = inGuess;
        }
    }
    
    private void printAnswerFeedback(boolean correct)
    {
        if(correct)
        {
            System.out.println("rätt!");
        }
        else
        {
            System.out.println("fel, försök igen!");
        }
    }
    
    public boolean load(Vocabulary inVoc)
    {
        if(inVoc.wordCount() >= 10)
        {
            mVoc = inVoc;
            mVoc.shuffleWords();
        }
        
        while(mVoc.wordCount() > 10)
        {
            mVoc.removeRandomWord();
        }
        
        return mVoc.wordCount() == 10;
    }
}

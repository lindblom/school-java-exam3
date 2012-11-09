/**
 * Write a description of class VocabularyTester here.
 * 
 * @author Christopher Lindblom 
 * @version 2012-11-08
 */
public class VocabularyTester
{
    // instance variables
    private Vocabulary mVoc;
    private GuessBook mGuessBook;

    /**
     * Constructor for objects of class TestVocabulary
     */
    public VocabularyTester()
    {
        // initialise instance variables
        mVoc = new Vocabulary();
        mGuessBook = new GuessBook();
    }
    
    /**
     * Run the vocabulary test.
     */
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
            printSummary(word);
        }
    }
    
    /**
     * Prints a summary of the test.
     */
    private void printSummary(Word inWord)
    {
        System.out.println("\nOrdet var: " + inWord.getWord());
        
        System.out.print("Du gissade: ");
        
        System.out.print(mGuessBook.getGuesses(inWord));
        
        if(mGuessBook.wasCorrect(inWord))
        {
            System.out.println(" -- Vilket var rätt!");
        }
        else
        {
            System.out.println(" -- Rätt svar var " + inWord.getAnswer());
        }
    }
    
    /**
     * Asks a word.
     * 
     * @param   Word    the word to be asked
     */
    private void askWord(Word word)
    {
        int thisGuess = 1;
        String guess = "";
        
        // lets user guess until user finds guesses correct or miss three times
        while(thisGuess <= 3 && !word.isCorrect(guess))
        {
            System.out.println("Hur stavas '" + word.getWord() + "' på engelska?");
            guess = InputHandler.get();
            
            // add guess to guessbook
            mGuessBook.addGuess(word, guess);
            // print feeback to user
            printAnswerFeedback(word.isCorrect(guess));
            
            thisGuess++;
        }
        
        // prints the correct word unless it was given
        if(!word.isCorrect(guess))
        {
            System.out.println("Det rätta svaret var: " + word.getAnswer());
        }
    }
    
    /**
     * Prints feedback whether the word was correct.
     */
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
    
    /**
     * Loads the test vocabulary
     * 
     * @params  Vocabulary  the vocabulary to get words from
     * @return              true if words were added correctly
     */
    public boolean load(Vocabulary inVoc)
    {
        if(inVoc.wordCount() >= 10)
        {
            mVoc = inVoc.copy();
            mVoc.shuffleWords();
        }
        
        while(mVoc.wordCount() > 10)
        {
            mVoc.removeRandomWord();
        }
        
        return mVoc.wordCount() == 10;
    }
}

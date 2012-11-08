
/**
 * Write a description of class Word here.
 * 
 * @author Christopher Lindblom 
 * @version 2012-11-08
 */
public class Word
{
    // instance variables
    private String mWord;
    private String mAnswer;
    
    /**
     * Constructor for objects of class Word.
     * 
     * @param   String  the word (question)
     * @param   String  the translation (answer)
     */
    public Word(String inWord, String inAnswer)
    {
        mWord = inWord;
        mAnswer = inAnswer;
    }
    
    /**
     * Check to see if an answer is correct.
     * 
     * @param   String  guess
     * @return          true if it is correct
     */
    public boolean isCorrect(String inGuess)
    {
        return mAnswer.equalsIgnoreCase(inGuess);
    }
    
    /**
     * Overridden toString().
     * 
     * @return  "word - answer" format
     */
    public String toString()
    {
        return mWord + " - " + mAnswer;
    }
    
    /**
     * Accessor for answer.
     * 
     * @return the answer
     */
    public String getAnswer()
    {
        return mAnswer;
    }
    
    /**
     * Accessor for word.
     * 
     * @return the word
     */
    public String getWord()
    {
        return mWord;
    }
}


/**
 * Write a description of class Word here.
 * 
 * @author Christopher Lindblom 
 * @version 2012-11-08
 */
public class Word
{

    private String mWord;
    private String mAnswer;
    
    /**
     * Constructor for objects of class Word
     */
    public Word(String inWord, String inAnswer)
    {
        mWord = inWord;
        mAnswer = inAnswer;
    }
    
    public boolean isCorrect(String answer)
    {
        return mAnswer.equalsIgnoreCase(answer);
    }
    
    public String toString()
    {
        return mWord + " - " + mAnswer;
    }
    
    public String getAnswer()
    {
        return mAnswer;
    }
    
    public String getWord()
    {
        return mWord;
    }
}


/**
 * Write a description of class Word here.
 * 
 * @author Christopher Lindblom
 * @version (a version number or a date)
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
}

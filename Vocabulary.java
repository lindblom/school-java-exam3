import java.util.ArrayList;

/**
 * Write a description of class Vocabulary here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vocabulary
{
    // instance variables - replace the example below with your own
    private ArrayList<Word> mWords;

    /**
     * Constructor for objects of class Vocabulary
     */
    public Vocabulary()
    {
        mWords = new ArrayList<Word>();
    }
    
    public int wordCount()
    {
        return mWords.size();
    }
    
    public void addWord(String inWord, String inAnswer)
    {
        mWords.add(new Word(inWord, inAnswer));
    }
}

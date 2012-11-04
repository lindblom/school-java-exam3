import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

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
    
    public String getWords()
    {
        String words = "";
        int i = 1;
        for(Word word : mWords)
        {
            words += i + ": " + word + "\n";
            i++;
        }
        return words;
    }
    
    public void addWord(String inWord, String inAnswer)
    {
        mWords.add(new Word(inWord, inAnswer));
    }
    
    public String removeWord(int inIndex)
    {
        String result = null;
        
        try
        {
            result = mWords.get(inIndex).toString();
            mWords.remove(inIndex);
        }
        catch(IndexOutOfBoundsException e)
        {
            
        }
        
        return result;
    }
    
    public void removeRandomWord()
    {
        mWords.remove(new Random().nextInt(mWords.size()));
    }
}

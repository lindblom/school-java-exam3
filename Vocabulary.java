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
    
    public void addWord(String inWord, String inAnswer)
    {
        mWords.add(new Word(inWord, inAnswer));
    }
    
    public void removeWord(String inWord)
    {
        Word foundWord = null;
        Iterator<Word> wordIterator = mWords.iterator();
        while(wordIterator.hasNext() && foundWord == null)
        {
            Word word = wordIterator.next();
            if(word.getWord().equals(inWord))
            {
                foundWord = word;
            }
        }
        
        if(foundWord != null)
        {
            mWords.remove(foundWord);
        }
    }
    
    public void removeRandomWord()
    {
        mWords.remove(new Random().nextInt(mWords.size()));
    }
}

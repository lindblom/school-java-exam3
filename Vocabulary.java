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
    
    public String addWord(String inWord, String inAnswer)
    {
        Word newWord = new Word(inWord, inAnswer);
        mWords.add(newWord);
        return newWord.toString();
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
        mWords.remove(getRandomWord());
    }
    
    private Word getRandomWord()
    {
        return mWords.get(new Random().nextInt(mWords.size()));
    }
    
    private void shuffleOne()
    {
        Word word = getRandomWord();
        mWords.remove(word);
        mWords.add(word);
    }
}

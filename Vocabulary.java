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
    private int mDefaultShuffleFactor;

    /**
     * Constructor for objects of class Vocabulary
     */
    public Vocabulary()
    {
        mWords = new ArrayList<Word>();
        mDefaultShuffleFactor = 4;
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
    
    public Word[] getWordsArray()
    {
        return mWords.toArray(new Word[0]);
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
    
    private void shuffleOneWord()
    {
        Word word = getRandomWord();
        mWords.remove(word);
        mWords.add(word);
    }
    
    public void shuffleWords()
    {
        shuffleWords(mDefaultShuffleFactor);
    }
    
    public void shuffleWords(int inShuffleFactor)
    {
        for(int i = 1; i < wordCount() * inShuffleFactor; i++)
        {
            shuffleOneWord();
        }
    }
}

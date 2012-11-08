import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Write a description of class Vocabulary here.
 * 
 * @author Christopher Lindblom 
 * @version 2012-11-08
 */
public class Vocabulary
{
    // instance variables
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
    
    /**
     * Word count of the vocabulary.
     * 
     * @return  the word count of the vocabulary
     */
    public int wordCount()
    {
        return mWords.size();
    }
    
    /**
     * Get the words as a numbered list.
     * 
     * @return  the words as a numbered list(String)
     */
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
    
    /**
     * Get the words as an array of Word objects.
     * 
     * @return the array of Word objects
     */
    public Word[] getWordsArray()
    {
        return mWords.toArray(new Word[0]);
    }
    
    /**
     * Add a word to the vocabulary.
     * 
     * @param   String  word
     * @param   String  answer
     * @return          the newly created word as a String
     */
    public String addWord(String inWord, String inAnswer)
    {
        Word newWord = new Word(inWord, inAnswer);
        mWords.add(newWord);
        return newWord.toString();
    }
    
    /**
     * Remove a word from the vocabulary.
     * Returns null if invalid index is given.
     * 
     * @param   int     index of the word to be removed
     * @return          a string representation of the removed word
     */
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
            // do nothing
        }
        
        return result;
    }
    
    /**
     * Remove random word from vocabulary.
     */
    public void removeRandomWord()
    {
        mWords.remove(getRandomWord());
    }
    
    /**
     * Get random word from vocabulary.
     * 
     * @return  the a random word
     */
    private Word getRandomWord()
    {
        return mWords.get(new Random().nextInt(mWords.size()));
    }
    
    /**
     * Suffle one word.
     */
    private void shuffleOneWord()
    {
        Word word = getRandomWord();
        mWords.remove(word);
        mWords.add(word);
    }
    
    /**
     * Suffle words by the default factor.
     */
    public void shuffleWords()
    {
        shuffleWords(mDefaultShuffleFactor);
    }
    
    /**
     * Suffle word by selected factor.
     * 
     * @params  int     suffle factor
     */
    public void shuffleWords(int inShuffleFactor)
    {
        for(int i = 1; i < wordCount() * inShuffleFactor; i++)
        {
            shuffleOneWord();
        }
    }
}

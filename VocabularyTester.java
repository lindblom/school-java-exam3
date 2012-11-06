
/**
 * Write a description of class VocabularyTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VocabularyTester
{
    // instance variables - replace the example below with your own
    private Vocabulary mVoc;

    /**
     * Constructor for objects of class TestVocabulary
     */
    public VocabularyTester()
    {
        // initialise instance variables
        mVoc = new Vocabulary();
    }
    
    public void run()
    {
        System.out.println("Väkommen till glostestet.");
        Word[] testWords = mVoc.getWordsArray();
        for(Word word : testWords)
        {
            askWord(word);
        }
        // print summary!
    }
    
    private void askWord(Word word)
    {
        int thisTry = 1;
        String answer = "";
        String[] answers = new String[3];
        
        while(thisTry <= 3 && !word.isCorrect(answer))
        {
            System.out.println("Hur stavas '" + word.getWord() + "' på engelska?");
            answer = InputHandler.get();
            answers[thisTry - 1] = answer;
            printAnswerFeedback(word.isCorrect(answer));
            thisTry++;
        }
        
        if(!word.isCorrect(answer))
        {
            System.out.println("Det rätta svaret var: " + word.getAnswer());
        }
    }
    
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
    
    public boolean load(Vocabulary inVoc)
    {
        if(inVoc.wordCount() >= 10)
        {
            mVoc = inVoc;
            mVoc.shuffleWords();
        }
        
        while(mVoc.wordCount() > 10)
        {
            mVoc.removeRandomWord();
        }
        
        return mVoc.wordCount() == 10;
    }
}

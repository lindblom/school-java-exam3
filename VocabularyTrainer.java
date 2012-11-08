
/**
 * This is the "boot-up" class for the VocabularyTrainer software.
 * 
 * @author Christopher Lindblom 
 * @version 2012-11-08
 */
public class VocabularyTrainer
{
    /**
     * Constructor for objects of class VocabularyTrainer, but don't use it.
     * Just call the static method run.
     */
    public VocabularyTrainer()
    {
        // empty constructor
    }
    
    /**
     * The method to call when you want to start the VocabularyTrainer software.
     */
    public static void main(String[] args)
    {
        // run program
        VocabularyTrainerProgram trainerProgram = new VocabularyTrainerProgram();
        trainerProgram.run();
    }
}

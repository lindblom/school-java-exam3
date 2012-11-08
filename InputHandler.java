import java.util.Scanner;
/**
 * InputHandler handles the input from the user.
 * 
 * @author Christopher Lindblom 
 * @version 2012-11-08
 */
public class InputHandler
{
    // Our static variables
    private static Scanner mScanner = new Scanner(System.in);
    private static String mCursor = "> ";
    
    /**
     * Constructor for objects of class InputHandler, but should not be used.
     * Use the static method get instead.
     */
    public InputHandler()
    {
        // empty constructor
    }

    /**
     * Prints a cursor, gets input from the user and transforms it to the right format.
     * 
     * @return  String  the transformed input from the user
     */
    public static String get()
    {
        printCursor();
        
        String input = mScanner.nextLine();
        return input.toLowerCase();
    }
    
    /**
     * Prints the cursor.
     */
    private static void printCursor()
    {
        System.out.print(mCursor);
    }
}

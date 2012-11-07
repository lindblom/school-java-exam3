import java.util.Scanner;
/**
 * Write a description of class InputHandler here.
 * 
 * @author Christopher Lindblom 
 * @version 2012-11-08
 */
public class InputHandler
{
    // instance variables - replace the example below with your own
    private static Scanner mScanner = new Scanner(System.in);
    
    /**
     * Constructor for objects of class InputHandler
     */
    public InputHandler()
    {
    }

    public static String get()
    {
        System.out.print("> ");
        String input = mScanner.nextLine();
        return input.toLowerCase();
    }
}

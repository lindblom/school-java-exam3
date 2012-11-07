import java.util.Scanner;
/**
 * Write a description of class InputHandler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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

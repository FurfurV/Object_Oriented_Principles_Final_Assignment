import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 🦄
 *
 * @author Viktoria Cseke
 * R00180598 Dec 2019
 */
//code from the lecture notes
public abstract class ErrorMess {
    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ check if string ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
    public static String getString(){

        boolean ok = false;
        String s = null;
        while(!ok)
        {
            byte[] b = new byte[512];
            try
            {
                System.in.read(b);
                s = new String(b);
                s = s.trim();
                ok = true;
            }
            catch(IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
        return s;
    }

    //▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚ check if int ▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚▚
    public static int getInt()
    {
        int i = 0;
        boolean ok = false;
        String s ;
        while(!ok)
        {
            byte[] b = new byte[512];
            try
            {
                System.in.read(b);
                s = new String(b);
                i = Integer.parseInt(s.trim());
                ok = true;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Make sure you enter an integer");
            }
            catch(IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
        return i;
    }
}

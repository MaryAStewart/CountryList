import java.util.Scanner;

public class Validator
{
    public static String getLine(Scanner keyboard, String prompt)
    {
        System.out.print(prompt);
        String s = keyboard.nextLine();        // read the whole line
        return s;
    }

    public static String getString(Scanner keyboard, String prompt)
    {
        System.out.print(prompt);
        String s = keyboard.next();        // read the first string on the line
        keyboard.nextLine();               // discard the rest of the line
        return s;
    }

    public static int getInt(Scanner keyboard, String prompt)
    {
        boolean isValid = false;
        int i = 0;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (keyboard.hasNextInt())
            {
                i = keyboard.nextInt();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            keyboard.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

    public static int getInt(Scanner keyboard, String prompt,
    int min, int max)
    {
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            i = getInt(keyboard, prompt);
            if (i <= min)
                System.out.println(
                    "Error! Number must be greater than " + min);
            else if (i >= max)
                System.out.println(
                    "Error! Number must be less than " + max);
            else
                isValid = true;
        }
        return i;
    }

    public static double getDouble(Scanner keyboard, String prompt)
    {
        boolean isValid = false;
        double d = 0;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (keyboard.hasNextDouble())
            {
                d = keyboard.nextDouble();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            keyboard.nextLine();  // discard any other data entered on the line
        }
        return d;
    }

    public static double getDouble(Scanner keyboard, String prompt,
    double min, double max)
    {
        double d = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            d = getDouble(keyboard, prompt);
            if (d <= min)
                System.out.println(
                    "Error! Number must be greater than " + min);
            else if (d >= max)
                System.out.println(
                    "Error! Number must be less than " + max);
            else
                isValid = true;
        }
        return d;
    }

}


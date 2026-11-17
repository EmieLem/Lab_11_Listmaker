import java.util.Scanner;

/** Input helpers used by the ListMaker program. */
public class SafeInput
{
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        while(true)
        {
            System.out.print(prompt + ": ");
            String value = pipe.nextLine().trim();
            if(!value.isEmpty())
            {
                return value;
            }
            System.out.println("Please enter at least one non-space character.");
        }
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        if(low > high)
        {
            throw new IllegalArgumentException("low must not be greater than high");
        }

        while(true)
        {
            System.out.print(prompt + " (" + low + "-" + high + "): ");
            String input = pipe.nextLine().trim();
            try
            {
                int value = Integer.parseInt(input);
                if(value >= low && value <= high)
                {
                    return value;
                }
                System.out.println("Please enter a number from " + low + " to " + high + ".");
            }
            catch(NumberFormatException ex)
            {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        while(true)
        {
            System.out.print(prompt + " (Y/N): ");
            String answer = pipe.nextLine().trim();
            if(answer.equalsIgnoreCase("y"))
            {
                return true;
            }
            if(answer.equalsIgnoreCase("n"))
            {
                return false;
            }
            System.out.println("Please enter Y or N.");
        }
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        while(true)
        {
            System.out.print(prompt + ": ");
            String input = pipe.nextLine().trim();
            if(input.matches(regEx))
            {
                return input;
            }
            System.out.println("Invalid input. Please try again.");
        }
    }
}

import java.util.Scanner;

public class lab6
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int myNumber = scan.nextInt();
        int myOutput = recursiveFunction(myNumber);
        System.out.println(myOutput);
    }

    public static int recursiveFunction(int myNumber)
    {
        if (myNumber == 1)
        {
            return 0;
        } else
        {
            if (myNumber%2==0)
            {
                myNumber = myNumber/2;
            }else
            {
                myNumber = (myNumber*3)+1;
            }
            return 1 + recursiveFunction(myNumber);
        }
    }
}
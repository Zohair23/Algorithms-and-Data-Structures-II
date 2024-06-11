import java.util.Scanner;
import java.util.Random;

public class lab1_cs211_array {
    public static void main (String [] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of traitors: ");
        int numtraitors = scan.nextInt();
        scan.close();
        int numfaithful = 22-numtraitors;

        char [] choices = new char[22];

        for(int j = 0;j < numtraitors;j++)
        {
            choices[j] = 'T';
        }

        for(int i = numtraitors; i < 22;i++)
        {
            choices[i] = 'F';
        }
        
        int simulations = 1000000;

        int elim1 = 0;
        int elim2 = 0;
        int choicesSize = 22;
        double traitorWins = 0;

        for(int i = 0;i < simulations;i++)
        {
            for(int j = 0;j < 10;j++)
            {
                do{
                    elim1 = (int)(Math.random()*choicesSize);
                    elim2 = (int)(Math.random()*choicesSize);
                }
                while((elim1 == elim2) && (choices[elim1] != 'e') && (elim2 != 'e'));

                choices[elim1] = 'e';
                choices[elim2] = 'e';
            }
            int fCount = 0;
            for(int k = 0; k < 22; k++)
            {
                if (choices[k] == 'F')
                {
                    fCount++;
                }
            }

            if(fCount != 2)
            {
                traitorWins++;
            }

        }
        System.out.println(traitorWins);
        System.out.println("The probability the traitors win, given n traitors is: " + (traitorWins/simulations));
    }
}
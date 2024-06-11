import java.util.Scanner;
import java.util.Random;

public class lab1_cs211 {
    public static void main (String [] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of traitors: ");
        int numtraitors = scan.nextInt();
        scan.close();
        int numfaithful = 22-numtraitors;

        String temp = "";

        for(int i = 0; i < numfaithful;i++)
        {
            temp = temp + "F";
        }

        for(int j = 0;j < numtraitors;j++)
        {
            temp = temp + "T";
        }
        
        int simulations = 1000000;

        
        
        double traitorWins = 0;

        for(int i = 0;i < simulations;i++)
        {
            String choices = temp;
            int choicesSize = 22;
            int elim1 = 0;
            int elim2 = 0;
            for(int j = 0;j < 10;j++)
            {
                elim1 = (int)(Math.random()*choicesSize);

                choices = choices.substring(0,elim1) + choices.substring(elim1+1);
                choicesSize--;

                elim2 = (int)(Math.random()*choicesSize);

                choices = choices.substring(0,elim2) + choices.substring(elim2+1);
                choicesSize--;
            }

            if (!choices.equals("FF"))
            {
                traitorWins++;
            }
        }

        System.out.println("The probability the traitors win, given" + numtraitors +" traitors is: " + (traitorWins/simulations));
    }
}
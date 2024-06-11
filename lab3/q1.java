import java.util.Scanner;

public class q1 {
    public static void main (String []args)
    {   
        Scanner scan = new Scanner(System.in);
        String word1 = "";
        String word2 = "";

        do{
            System.out.println("Enter word1: ");
            word1 = scan.nextLine();
            System.out.println("Enter word2: ");
            word2 = scan.nextLine();
        }
        while (word1.length() < 1 || word2.length() > 100 || word2.length() < 1 || word1.length() > 100);
        
        int i = 0;
        int stop = 0;
        if (word1.length() > word2.length())
        {
            stop = word2.length();
        }else
        {
            stop = word1.length();
        }
        String myOutput = mergeWords(word1,word2,stop,i);
        System.out.println("Merged word: ");
        System.out.println(myOutput);
    }

    public static String mergeWords(String word1,String word2,int stop,int i)
    {

        if (i == stop)
        {
            if (word1.length() > word2.length())
            {
                return word1.substring(i);
            }else
            {
                return word2.substring(i);  
            }
        } else
        {
            return word1.substring(i,i+1) + word2.substring(i,i+1) + mergeWords(word1,word2,stop,i+1);
        }
        
    }

}
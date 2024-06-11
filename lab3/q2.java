import java.util.Scanner;

public class q2 {
    public static void main (String []args)
    {   
        Scanner scan = new Scanner(System.in);
        String word1 = "";
        String word2 = "";
        

        //constraint
        do{
            System.out.println("Enter word1: ");
            word1 = scan.nextLine();
            System.out.println("Enter word2: ");
            word2 = scan.nextLine();
        }
        while (word1.length() < 1 || word2.length() > 100 || word2.length() < 1 || word1.length() > 100);

        
        String myOutput = mergeWords(word1,word2,0,0);
        System.out.println(myOutput);
    }

    public static String mergeWords(String word1,String word2,int i,int j)
    {
        int stop = (word1.length() + word2.length())-2;
        if (i+j == stop)
        {
            return "";   
        } else if(i == word1.length())
        {
            return word2.substring(j);
        } else if(j == word2.length())
        {
            return word1.substring(i);
        } else
        {
            if(word1.charAt(i) < word2.charAt(j))
            {
                return word1.substring(i,i+1) + mergeWords(word1,word2,i+1,j);
            }else
            {
                return word2.substring(j,j+1) + mergeWords(word1,word2,i,j+1);
            }
        }
        
    }

}
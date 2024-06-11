import java.util.Scanner;

public class lab4{
    public static void main (String []args)
    {
        Scanner scan = new Scanner(System.in);
        String userInput = "";
        boolean finish = false;
        int count = 0;
        Stack myLinkedList = new Stack();

        while(finish == false)
        {
            System.out.print("Enter a word: ");
            userInput = scan.nextLine();
            if(userInput.equals("END"))
            {
                System.out.println("Output:");
                for(int i = 0; i < count;i++)
                {
                    System.out.println(myLinkedList.pop());
                }
                finish = true;
                scan.close();
            }else
            {
                myLinkedList.push(userInput);
                count++;
            }
        }
    }
}
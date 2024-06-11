import java.util.Scanner;

public class lab2_cs211_part2_alt{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter record to check: ");
        String userInput = scan.nextLine();
        scan.close();
        String myDup = userInput;
        String myoutput = courseRecord(userInput,false,0,myDup);
        System.out.println(myoutput);
    }

    public static String courseRecord(String myinput,boolean consecutiveLate,int absenceCount,String myinputDup)
    {
        int mylength = myinput.length();
        if(mylength == 1)
        {
            if(myinput.charAt(0) == 'A')
            {
                absenceCount++;
            }
            for(int i = 0; i < (myinputDup.length()-2);i++)
            {
                if("LLL".equals(myinputDup.substring(i,i+3)))
                {
                    consecutiveLate = true;
                }
            }
            if(absenceCount < 2 && consecutiveLate == false)
            {
                return "PASS";
            }else
            {
                return "FAIL";
            }
        } else
        {
            if(myinput.charAt(mylength-1) == 'A')
            {
                return courseRecord(myinput.substring(0,mylength-1),consecutiveLate,absenceCount+1,myinputDup);
            }else
            {
                return courseRecord(myinput.substring(0,mylength-1),consecutiveLate,absenceCount,myinputDup);
            }
    }
}
}
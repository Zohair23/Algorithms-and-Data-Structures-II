import java.util.Scanner;

public class lab2_cs211_part2{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter record to check: ");
        String userInput = scan.nextLine();
        scan.close();
        String myoutput = courseRecord("00"+userInput);
        System.out.println(myoutput.substring(2));
    }

    public static String courseRecord(String myinput)
    {
        int absenceCount = Integer.parseInt(String.valueOf(myinput.charAt(0)));
        int consecutiveLate = Integer.parseInt(String.valueOf(myinput.charAt(1)));
        myinput = myinput.substring(2);
        int mylength = myinput.length();
        if (mylength == 0)
        {
            if((absenceCount >= 2) || (consecutiveLate >= 1))
            {
                return "FAIL";
            }else{
                return "PASS";
            }
        }else
        {
            if (mylength == 1)
            {
                if(myinput.charAt(mylength-1) == 'A')
                {
                return courseRecord((absenceCount+1) + (consecutiveLate + ""));
                }
                return courseRecord(absenceCount + ((consecutiveLate) + ""));
            }
            if((myinput.substring(mylength-3)).equals("LLL"))
            {
                return courseRecord(absenceCount + ((consecutiveLate+1) + myinput.substring(0,mylength-3)));
            }else if(myinput.charAt(mylength-1) == 'A')
            {
                return courseRecord((absenceCount+1) + (consecutiveLate + myinput.substring(0,mylength-1)));
            }
            return courseRecord(absenceCount + (consecutiveLate + myinput.substring(0,mylength-1)));

        }
    }

}
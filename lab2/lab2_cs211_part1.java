import java.util.Scanner;

public class lab2_cs211_part1 {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter initial loan: ");
        double initialLoan = scan.nextDouble();
        System.out.println("Enter interest rate: ");
        double interestRate = scan.nextDouble();
        System.out.println("Enter monthly repayment: ");
        double monthlyRepayment = scan.nextDouble();
        double myOutput = myLoan(initialLoan,interestRate,monthlyRepayment);
        System.out.println("It will take: " + myOutput + "months"); //rounded up
    }

    public static double myLoan(double toPayOff,double interestRate,double monthlyRepayment)
    {
        if ((toPayOff - monthlyRepayment*12) <= 0.0)
        {
            for(int i = 0; i < 12; i++)
            {
                toPayOff = toPayOff - monthlyRepayment;
                if (toPayOff <= 0.0)
                {
                    return i+1.0;
                }
            }
            return 0.0;
        }else
        {
            toPayOff = toPayOff + ((toPayOff/100)*interestRate); //might need to reposition if interest counts on the first year
            toPayOff = toPayOff - (monthlyRepayment*12);
            return 12.0 + myLoan(toPayOff, interestRate, monthlyRepayment);
        }
    }
}

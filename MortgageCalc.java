import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalc {
    // defining const variables
    final static byte MONTHS_IN_YR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {

        // input of principal
        int principal = (int) readNumber("Principal: ", 1000,1_000_000);
        // input of rate
        float rate = (float) readNumber("Annual Interest Rate: ", 1, 30);
        // input of period (in yrs)
        int yrs = (int) readNumber("Period (years): ", 1, 30);
        // to display as currency
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        // to display Mortgage
        displayMortgage(principal, rate, yrs , currency);
        // to display Payment Schedule
        displayPaymentSchedule(yrs, principal, rate, currency);
    }

    public static void displayMortgage(int principal, float rate, int yrs, NumberFormat currency) {
        // calculate and display mortgage
        double mortgage = calculateMortgage(principal, rate, yrs);
        System.out.println("\n" +
                "MORTGAGE\n" + "--------\n" +
                "Monthly Payments: " + currency.format(mortgage));
    }

    public static void displayPaymentSchedule(int yrs, int principal, float rate, NumberFormat currency) {
        // to calculate and display balance
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for(short month = 1; month <= yrs * MONTHS_IN_YR; month++){
            double balance = calculateBalance(principal, rate, yrs,month);
            System.out.println(currency.format(balance));
        }
    }

    // to validate the input from the user
    public static double readNumber(
            String prompt,
            double min,
            double max){
        Scanner scanner = new Scanner(System.in);
        double value; // to take input
        while(true){
            System.out.print(prompt);
            value = scanner.nextDouble();
            if(value >= min && value <= max){
                return value;
            }
            System.out.println("Enter a value between " + (int)min + " and " + (int)max);
        }
    }


    // to calculate mortgage
    public static double calculateMortgage(
            int principal,
            float rate,
            int yrs){

        // calculate mortgage
        double monthlyInterestRate = (rate / PERCENT) / MONTHS_IN_YR;
        int numOfPayments = yrs * MONTHS_IN_YR;

        double onePlusRTon = Math.pow(1 + monthlyInterestRate,numOfPayments);
        return principal * ((monthlyInterestRate * onePlusRTon) / (onePlusRTon - 1));

    }

    // to calculate remaining balance for each month
    public static double calculateBalance(
            int principal,
            float rate,
            int yrs,
            short numberOfPaymentsMade) {

        double monthlyInterestRate = (rate / PERCENT) / MONTHS_IN_YR;
        int numOfPayments = yrs * MONTHS_IN_YR;

        double onePlusCtoN = Math.pow(1+monthlyInterestRate,numOfPayments);
        return principal
                * (onePlusCtoN - Math.pow(1+monthlyInterestRate,numberOfPaymentsMade))
                / (onePlusCtoN - 1);
    }
}

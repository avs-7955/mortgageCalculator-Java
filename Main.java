public class Main {

    public static void main(String[] args) {

        // input of principal
        int principal = (int) Console.readNumber("Principal: ", 1000,1_000_000);
        // input of rate
        float rate = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        // input of period (in yrs)
        int yrs = (int) Console.readNumber("Period (years): ", 1, 30);

        var calculator = new MortgageCalculator(principal, rate, yrs);
        var report = new MortgageReport(calculator);

        report.displayMortgage();
        report.displayPaymentSchedule();
    }

}

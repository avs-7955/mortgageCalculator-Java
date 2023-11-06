import java.text.NumberFormat;

public class MortgageReport {
    private final NumberFormat currency;
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void displayMortgage() {
        // calculate and display mortgage
        double mortgage = calculator.calculateMortgage();
        System.out.println("\n" +
                "MORTGAGE\n" + "--------\n" +
                "Monthly Payments: " + currency.format(mortgage));
    }

    public void displayPaymentSchedule() {
        // to calculate and display balance
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");

        for(double balance : calculator.getRemainingBalances()){
            System.out.println(currency.format(balance));
        }
    }
}

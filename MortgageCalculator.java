public class MortgageCalculator {
    // defining const variables
    private final static byte MONTHS_IN_YR = 12;
    private final static byte PERCENT = 100;
    private int principal;
    private float rate;
    private int yrs;


    public MortgageCalculator(int principal, float rate, int yrs) {
        this.principal = principal;
        this.rate = rate;
        this.yrs = yrs;
    }

    // to calculate mortgage
    public double calculateMortgage() {
        // calculate mortgage
        double monthlyInterestRate = getMonthlyInterestRate();
        int numOfPayments = getNumOfPayments();

        double onePlusRTon = Math.pow(1 + monthlyInterestRate, numOfPayments);
        return principal * ((monthlyInterestRate * onePlusRTon) / (onePlusRTon - 1));
    }


    // to calculate remaining balance for each month
    public double calculateBalance(short numberOfPaymentsMade) {

        double monthlyInterestRate = getMonthlyInterestRate();
        int numOfPayments = getNumOfPayments();

        double onePlusCtoN = Math.pow(1 + monthlyInterestRate, numOfPayments);
        return principal
                * (onePlusCtoN - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade))
                / (onePlusCtoN - 1);
    }

    public double[] getRemainingBalances(){
        var balances = new double[getNumOfPayments()];
        for (short month = 1; month <= balances.length ; month++)
            balances[month - 1] = calculateBalance(month);
        return balances;
    }

    private int getNumOfPayments() {
        return yrs * MONTHS_IN_YR;
    }

    private float getMonthlyInterestRate() {
        return (rate / PERCENT) / MONTHS_IN_YR;
    }
}

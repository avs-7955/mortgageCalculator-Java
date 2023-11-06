import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);
    // to validate the input from the user
    public static double readNumber(
            String prompt,
            double min,
            double max) {
        double value; // to take input
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Enter a value between " + (int) min + " and " + (int) max);
        }
    }
}

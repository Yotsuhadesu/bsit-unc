import java.util.Scanner;

public class Activity21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Whole Number: ");
        int wholeNumber = scanner.nextInt();
        System.out.print("Exponent: ");
        int exponent = scanner.nextInt();

        int result = wholeNumber;
        for (int i = 1; i < exponent; i++) {
            result *= wholeNumber;
        }
        System.out.println("Result: " + result);

        scanner.close();
    }
}

import java.util.Scanner;

public class Activity5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("First Integer: ");
        int n1 = sc.nextInt();
        System.out.print("Second Integer: ");
        int n2 = sc.nextInt();

        System.out.println("Sum: " + (n1 + n2));
        System.out.println("Difference: " + (n1 - n2));
        System.out.println("Product: " + (n1 * n2));
        System.out.println("Quotient: " + (n1 / n2));
        System.out.println("Remainder: " + (n1 % n2));

        sc.close();
    }
}

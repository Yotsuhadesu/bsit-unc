import java.util.Scanner;

public class Activity12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Purchase amount: ");
        double amount = sc.nextDouble();
        System.out.print("Is member (true/false): ");
        boolean isMember = sc.nextBoolean();

        if (amount >= 1000 || isMember) {
            System.out.println("You will get a free shipping.");
        } else {
            System.out.println("You will not get a free shipping.");
        }

        sc.close();
    }
}

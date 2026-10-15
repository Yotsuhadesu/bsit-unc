import java.util.Scanner;

public class Activity10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        System.out.print("Filipino Citizen (true/false): ");
        boolean citizen = sc.nextBoolean();

        if (age >= 18) {
            if (citizen) {
                System.out.println("Eligible to Vote");
            }
            else {
                System.out.println("Not Eligible to Vote");
            }
        } else {
            System.out.println("Not Eligible to Vote");
        }

        sc.close();
    }
}

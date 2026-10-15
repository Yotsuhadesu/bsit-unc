import java.util.Scanner;

public class Activity8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your grade: ");
        int grade = sc.nextInt();

        if (grade >= 75) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

        sc.close();
    }
}

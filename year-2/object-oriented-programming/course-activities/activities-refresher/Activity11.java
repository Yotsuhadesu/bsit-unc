import java.util.Scanner;

public class Activity11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Average grade: ");
        double average = sc.nextDouble();
        System.out.print("Attendance grade: ");
        double attendance = sc.nextDouble();

        if (average >= 90 && attendance >= 95) {
            System.out.println("You are qualified for the scholarship.");
        } else {
            System.out.println("You are not qualified for the scholarship.");
        }

        sc.close();
    }
}

import java.util.Scanner;

public class Activity9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your grade: ");
        int grade = sc.nextInt();
        
        if (grade >= 90 && grade <= 100) {
            System.out.println("Excellent");
        } else if (grade >= 85 && grade <= 89) {
            System.out.println("Very Good");
        } else if (grade >= 80 && grade <= 84) {
            System.out.println("Good");
        } else if (grade >= 75 && grade <= 79) {
            System.out.println("Fair");
        } else {
            System.out.println("Failed");
        }

        sc.close();
    }
}

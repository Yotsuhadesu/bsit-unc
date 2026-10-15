import java.util.Scanner;

public class Activity20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number of Students: ");
        int studentCount = scanner.nextInt();

        // counter variables
        int passCount = 0;
        int failCount = 0;
        int sum = 0;
        for (int i = 1; i <= studentCount; i++) {
            System.out.print("Student " + i + " grade: ");
            int grade = scanner.nextInt();
            sum+=grade;

            if (grade >= 75) {
                passCount++;
                System.out.print("Passed");
            } else {
                failCount++;
                System.out.print("Failed");
            }
            System.out.println();
        }

        int average = sum/studentCount;
        System.out.println("Number of Passed Students: " + passCount);
        System.out.println("Number of Failed Students: " + failCount);
        System.out.println("Class Average: " + average);

        scanner.close();
    }
}

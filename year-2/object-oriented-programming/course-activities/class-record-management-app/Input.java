import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static void showMenu(ClassRecord classRecord) {
        System.out.println("=".repeat(50));
        System.out.printf(
            "\t%s\n" +
            "\tClass Record Management System\n", classRecord.getInstitutionName().toUpperCase());
        System.out.println("=".repeat(50));
        System.out.println();
        System.out.println("""
                === MAIN MENU ===
                [1] Assign College & Program Details
                [2] Assign Subject / Course Details
                [3] Set / Update Assigned Instructor
                [4] Add Enrolled Student
                [5] Remove Student by ID
                [6] Display Enrolled Students (Unsorted / Sorted)
                [7] Display Full Class Record
                [8] Save Class Record to File
                [9] Load Class Record from File
                [0] Exit""");
    }

    // static input validation methods
    public static String acceptString(String prompt) {
        String input;
        do {
            System.out.print(prompt + " ");
            input = scanner.nextLine();
            if (input == null || input.isBlank()) {
                System.out.println(">> Please enter a valid input.");
            } else {
                break;
            }
        } while(input == null || input.isBlank());
        return input;
    }
    public static int acceptInt(String prompt) {
        System.out.print(prompt + " ");
        while (!scanner.hasNextInt()) {
            System.out.println(">> Please enter a valid number.");
            System.out.print(prompt + " ");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }
    public static boolean acceptBoolean(String prompt) {
        System.out.print(prompt + " ");
        while (!scanner.hasNextBoolean()) {
            System.out.println(">> Please only enter true or false.");
            System.out.print(prompt + " ");
            scanner.next();
        }
        boolean bool = scanner.nextBoolean();
        scanner.nextLine();
        return bool;
    }
}
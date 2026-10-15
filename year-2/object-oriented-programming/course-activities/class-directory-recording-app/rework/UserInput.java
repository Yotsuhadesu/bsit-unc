import java.util.Scanner;

public class UserInput {
    private static final Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.print("""
                           === SCHOOL CLASS DIRECTORY SYSTEM ===
                           [1] View Class Directory
                           [2] Assign/Update Adviser
                           [3] Add Student
                           [4] Update Student by LRN
                           [5] Save Directory to File
                           [6] Load Directory from File
                           [7] Exit
                           """);
    }

    public static int pickAction() {
        System.out.print("Select an option: ");
        return acceptInt();
    }

    public static Student addStudent() {
        System.out.print("Enter LRN: ");
        long lrn = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Middle Name: ");
        String middleName = scanner.nextLine();
        System.out.print("Enter Gender:");
        String gender = scanner.nextLine();
        System.out.print("Enter Birthdate (YYYY-MM-DD): ");
        String birthDate = scanner.nextLine();
        System.out.print("Enter Contact Number: ");
        long contactNumber = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Enter Home Address: ");
        String address = scanner.nextLine();

        return new Student(lrn, address, lastName, firstName, middleName, 
            gender, birthDate, contactNumber);
    }

    public static String acceptString() { 
        String in;
        do {
            in = scanner.nextLine();
            if (in == null || in.isBlank()) {
                System.out.println("Invalid input!");
            } else {
                break;
            }
        } while (scanner.hasNextLine());
        return in; 
    }

    public static char acceptChar() { return scanner.next().toUpperCase().charAt(0); }

    public static long acceptLong() { 
        while (!scanner.hasNextLong()) {
           System.out.println("Invalid Input!");
           scanner.next();
        }
        long lo = scanner.nextLong();
        scanner.nextLine();
        return lo;
    }

    public static int acceptInt() { 
        while (!scanner.hasNextInt()) {
           System.out.println("Invalid Input!");
           scanner.next();
        }
        int in =  scanner.nextInt();
        scanner.nextLine();
        return in;
     }
}
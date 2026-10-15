import java.math.BigDecimal;
import java.util.Scanner;

/**
 * A class that can be called directly to validate user inputs.
 * Holds one private static Scanner object to accept inputs within the class.
*/
public class InputHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("""
                ------------------- MENU --------------------
                [1] ADD NEW TRANSACTION RECORD
                [2] UPDATE TRANSACTION RECORD
                [3] DELETE TRANSACTION RECORD
                [4] VIEW TRANSACTION RECORD
                [5] VIEW TRANSACTION LIST
                [6] VIEW TOTAL SALES
                [7] VIEW PENDING TRANSACTIONS
                [0] EXIT APPLICATION""");
    }

    public static void showHeadTable() {
        System.out.printf(
            "%-3s %-10s %-15s %-15s %-11s %-25s %-10s %-10s %-6s %-6s %-11s %-10s %-10s\n",
            "ID", "Date", "Last Name", "First Name",
            "Contact", "Address", "Item", "Quantity", 
            "Price", "Fee", "Total", "Method", "Status"
        );
    }

    public static String acceptString(String prompt) {
        String str;
        do {
            System.out.print(prompt + ": ");
            str = scanner.nextLine();

            if (str != null && !str.isBlank() && !str.contains("\t")) {
                break;
            } else {
                System.out.println(">> Please enter a valid input.");
            }
        } while (true);
        return str;
    }

    public static int acceptInt(String prompt) {
        System.out.print(prompt + ": ");
        while (!scanner.hasNextInt()) {
            System.out.println(">> Please enter a valid number.");
            System.out.print(prompt + ": ");
            scanner.next();
        }
        int num = scanner.nextInt();
        scanner.nextLine();
        return  num;
    }

    public static BigDecimal acceptBigDecimal(String prompt) {
        BigDecimal bDecimal = null;
        while (bDecimal == null) {
            System.out.print(prompt + ": ");
            if (scanner.hasNextBigDecimal()) {
                bDecimal = scanner.nextBigDecimal();
            } else {
                System.out.println(">> Please enter a valid amount.");
                scanner.next();
            }
        }
        scanner.nextLine();
        return  bDecimal;
    }

    public static int acceptId() {
        int lastTranId = FileHandler.getLastTranId();
        if (lastTranId == 0) {
            return -1;
        }
        int num = 0;
        do {
            System.out.print("Enter ID: ");
            while (!scanner.hasNextInt()) {
                System.out.println(">> Please enter a valid transaction ID.");
                System.out.print("Enter ID: ");
                scanner.next();
            }
            num = scanner.nextInt();
            scanner.nextLine();
        
            if (num <= 0 || num > lastTranId) {
                System.out.println(">> Transaction ID doesn't exist");
            }
        } while (num <= 0 || num > lastTranId);
        return  num;
    }

    public static boolean acceptBoolean(String prompt) {
        System.out.print(prompt + ": ");
        while (!scanner.hasNextBoolean()) {
            System.out.println(">> Please enter a valid bool value.");
            System.out.print(prompt + ": ");
            scanner.next();
        }
        boolean bool = scanner.nextBoolean();
        scanner.nextLine();
        return bool;
    }
}
import java.util.Scanner;

public class Elano_Jethro_Task8 {
    public static boolean validateAccountNo(String accountNo) {
        String[] sections = accountNo.split("-");   // split to sections
        boolean isValid = true;
        if (sections.length != 3) {    // if the entered account number doesn't have three sections
            isValid = false;
        }
        for (int i = 0; i < sections.length; i++) {
            for (int j = 0; j < sections[i].length(); j++) {
                if (!Character.isDigit(sections[i].charAt(j)))  // if the characters aren't digit
                    isValid = false;
            }
        }
        if (isValid) {  // length per section validation
            if (sections[0].length() != 3)
                isValid = false;
            if (sections[1].length() != 2)
                isValid = false;
            if (sections[2].length() != 4)
                isValid = false;
        }
        return isValid;
    }
    public static String getZone(String accountNo) {
        String[] sections = accountNo.split("-");
        return sections[0]; // return first section
    }
    public static void getClassification(String accountNo) {
        String[] sections = accountNo.split("-");   // split to sections
        char firstDigit = sections[1].charAt(0);    // get second section, first digit
        System.out.print("Classification: ");
        if (firstDigit == '1') {
            System.out.println("Residential");
        }
        else if (firstDigit == '2') {
            System.out.println("Commercial");
        }
        else if (firstDigit == '3') {
            System.out.println("Industrial");
        }
        else if (firstDigit == '4') {
            System.out.println("Government");
        } else {
            System.out.println("Unclassified.");
        }
    }
    public static String getPipeSize(String accountNo) {
        String[] sections = accountNo.split("-");
        char secondDigit = sections[1].charAt(1);
        String pipeSize = "";
        switch (secondDigit) {
            case '1' -> pipeSize += "1/2";
            case '2' -> pipeSize += "3/4";
            case '3' -> pipeSize += "1";
            case '4' -> pipeSize += "2";
            default -> pipeSize += "Unknown";
        }
        return pipeSize;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many inputs? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            // input
            System.out.print("Enter Account Number: ");
            String accountNumber = sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Address: ");
            String address = sc.nextLine();
            boolean isValid = validateAccountNo(accountNumber); // assign validator flag

            if (!isValid) {
                System.out.println("Invalid account number format.");
            } else {
                System.out.println();
                System.out.println("----- ACCOUNT INFORMATION -----");
                System.out.println("Name: " + name);
                System.out.println("Address: " + address);
                System.out.println("Account Number: " + accountNumber);
                System.out.println();
                System.out.println("Zone: " + getZone(accountNumber));
                getClassification(accountNumber);
                System.out.println("Pipe Size: " + getPipeSize(accountNumber));
            }
            System.out.println();
        }
        sc.close();
    }
}

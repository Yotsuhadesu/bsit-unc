import java.io.*;
import java.util.Scanner;

public class Elano_Jethro_Task9 {
    static File file = new File("accounts.txt");
    public static boolean validateAccountNo(String accountNo) {
        String[] sections = accountNo.split("-");   // split to sections
        boolean isValid = sections.length == 3;   // three section validator

        for (String section : sections) {
            for (int j = 0; j < section.length(); j++) {
                if (!Character.isDigit(section.charAt(j)))  // if the characters aren't digit
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

        // prevent duplicate account numbers
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = br.readLine()) != null) { // read line by line
                if(line.contains(accountNo)) {  // specific number search
                    isValid = false;
                }
            }
        } catch (IOException e) {
            System.out.println("Cannot read the file.");
        }
        return isValid;
    }
    public static String getZone(String accountNo) {
        String[] sections = accountNo.split("-");
        return sections[0]; // return first section
    }
    public static String getClassification(String accountNo) {
        String[] sections = accountNo.split("-");   // split to sections
        char firstDigit = sections[1].charAt(0);    // get second section, first digit

        switch(firstDigit) {    // return corresponding class
            case '1' -> { return "Residential"; }
            case '2' -> { return "Commercial"; }
            case '3' -> { return "Industrial"; }
            case '4' -> { return "Government"; }
            default -> { return "Unclassified"; }
        }
    }
    public static String getPipeSize(String accountNo) {
        String[] sections = accountNo.split("-");
        char secondDigit = sections[1].charAt(1);   // get second section, second digit
        switch (secondDigit) {  // return corresponding pie size
            case '1' -> { return "1/2"; }
            case '2' -> { return "3/4"; }
            case '3' -> { return "1"; }
            case '4' -> { return "2"; }
            default -> { return "Unknown"; }
        }
    }
    public static void createFile(boolean exists) {
        if(!exists) {   // create the file if it doesn't exist yet
            try {
                if(file.createNewFile()) {
                System.out.println("File " + file.getName() + " created.");
                } else {
                    System.out.println("There is an error while creating the file.");
                }
            } catch(IOException e) {
                System.out.println("Cannot create the file.");
            }
        }
    }
    public static void accountNumberSearch(String accountNo) {
        if(!file.exists()) {
            System.out.println("Record file does not exist.");
            return;
        }
        boolean exists = false;
        int accountLineNo = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = br.readLine()) != null) { // read line by line
                accountLineNo++;
                if(line.equals("Account Number: " + accountNo)) {  // specific account number search
                    exists = true;
                }
                if(exists)
                    break;
            }
        } catch (IOException e) {
            System.out.println("Cannot read the file.");
        }
        if(!exists) {
            System.out.println("Account number does not exist.");
            return;
        }
        int start = accountLineNo - 2;
        int end = accountLineNo + 3;
        int lineNo = 0;
        System.out.println("- - - - - - - - - - - - - - - - - - - -");
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = br.readLine()) != null) {
                lineNo++;
                if(lineNo >= start && lineNo <= end) {
                    System.out.println(line);   // print the account number holder's credentials
                }
            }
        } catch (IOException e) {
            System.out.println("Cannot read the file.");
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - -");
    }
    public static void main(String[] args) {
        createFile(file.exists());  // create file first
        Scanner sc = new Scanner(System.in);
        int n = 0;
        // menu driven program
        while(n != 6) {
            System.out.println("""
                    Menu:
                    1. Add Account Record
                    2. View All Records
                    3. View File Information
                    4. Delete File
                    5. Account Search
                    6. Exit""");
            System.out.print("Choice: ");
            if(!sc.hasNextInt()) {  // if the user entered a non digit symbol
                System.out.println("Invalid choice. Please enter a number.");
                sc.nextLine();  // consume line
                continue;   // jump back at the start of the loop
            }
            n = sc.nextInt();   // consume validated choice
            sc.nextLine();  // consume leftover line

            switch(n) {
                case 1:
                    // get credentials
                    String accountNumber;
                    boolean isValid;
                    do {
                        System.out.print("Enter Account Number (XXX-XX-XXXX): ");
                        accountNumber = sc.nextLine().trim();

                        isValid = validateAccountNo(accountNumber); // assign validator flag
                        if(!isValid)
                            System.out.println("Invalid account number. Please try again.");
                    } while(!isValid);  // loop until the user enters a valid account number

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    // save the credentials to the text file
                    try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {   // append file content
                        bw.write("Name: " + name + "\n");
                        bw.write("Address: " + address + "\n");
                        bw.write("Account Number: " + accountNumber + "\n");
                        bw.write("Zone: " + getZone(accountNumber) + "\n");
                        bw.write("Classification: " + getClassification(accountNumber) + "\n");
                        bw.write("Pipe Size: " + getPipeSize(accountNumber) + "\n");
                        bw.write("- - - - - - - - - - - - - - -" + "\n");
                    } catch (IOException e) {
                        System.out.println("Error saving the data.");
                    }
                    break;
                case 2:
                    // read the text file
                    if(file.exists()) {
                        System.out.println("----- ACCOUNT INFORMATION -----");
                        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                            String line;
                            while ((line = br.readLine()) != null) {    // terminates if readLine reaches the end of the File
                                System.out.println(line);   // print line by line
                            }
                        } catch (IOException e) {
                            System.out.println("Cannot read the file");
                        }
                    } else {
                        System.out.println("Cannot locate the file. Please restart the program.");
                    }
                    break;
                case 3:
                    System.out.println("----- FILE INFORMATION -----");
                    System.out.println("File Name: " + file.getName());
                    System.out.println("File Path: " + file.getAbsolutePath());
                    System.out.println("File Size: " + file.length());
                    System.out.println("Readable: " + file.canRead());
                    System.out.println("Writable: " + file.canWrite());
                    break;
                case 4:
                    System.out.print("Delete file " + file.getName() + " (Y/N): "); // confirmation
                    char confirm = sc.next().toLowerCase().charAt(0);
                    if(confirm == 'y') {
                        if(file.exists()) {
                            if(file.delete()) {
                                System.out.println("File deleted.");
                            } else {
                                System.out.println("Could not delete the file.");
                            }
                        } else {
                            System.out.println("Cannot locate the file.");
                        }
                    } else {
                        System.out.println("File not deleted.");
                    }
                    break;
                case 5:
                    System.out.print("Enter account number: ");
                    accountNumberSearch(sc.nextLine());
                    break;
                default:
                    System.out.println("Exiting the program..."); // exit the program properly
                    break;
            }
        }
        sc.close(); // close scanner object
    }
}

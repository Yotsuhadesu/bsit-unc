import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Elano_Jethro_Task10 {
    public static void manageGuestbook() {
        File file = new File("guestbook.txt");

        if (!file.exists()) {   // check if the file exists
            try {
                if (file.createNewFile()) { // create the file if it doesn't exist
                    System.out.println("Status: New guestbook initialized.");
                } else {
                    System.out.println("Failed to create the file.");
                }
            } catch (IOException e) {
                System.out.println("Failed to create the file.");
            }
        } else {
            try (   // add a guest if it exists
                    BufferedWriter writer = new BufferedWriter(new FileWriter("guestbook.txt", true));  // append
                    Scanner scanner = new Scanner(System.in)    // accept console input
            ) {
                System.out.print("Enter guest name to sign in: ");
                writer.write(scanner.nextLine());   // add name to file
                writer.newLine();   // write on new line
                System.out.println("Success: Name saved to guestbook.");
            } catch (IOException e) {
                System.out.println("Failed writing to file.");
            }
        }
    }
    public static void viewGuestList() {
        try (BufferedReader reader = new BufferedReader(new FileReader("guestbook.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {    // run until the line is empty
                System.out.println(line);   // print the contents of the line
            }
        } catch (IOException e) {
            System.out.println("Could not read the file.");
        }
    }
    public static void performAudit() {
        int lineCount = 0;  // line counter
        int errorCount = 0; // error occurrence counter
        try (BufferedReader reader = new BufferedReader(new FileReader("document.txt"))) {
            System.out.println("Audit Results for document.txt:");
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                if (line.contains("Error"))
                    errorCount++;
            }
            System.out.println("Total Lines: " + lineCount);
            System.out.println("Error Count: " + errorCount);
        } catch (FileNotFoundException e) {
            System.out.println("Please ensure document.txt is in the project folder.");
        } catch (IOException e) {
            System.out.println("Could not read the file.");
        }
    }
    public static void main(String[] args) {
        System.out.println("--- MODULE 1: GUESTBOOK ---");
        manageGuestbook();
        System.out.println("\n--- CURRENT GUEST LIST ---");
        viewGuestList();
        System.out.println("\n--- MODULE 2: SYSTEM AUDIT ---");
        performAudit();
    }
}

/*
    Title: Occurrence Counter
    Date: 16 February 2026
    Description: A Java program that counts how many times a character shows up.
 */
import java.util.Scanner;

public class OccurrenceCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // assign the matrix's dimensions
        System.out.print("Rows: ");
        int rows = sc.nextInt();
        System.out.print("Columns: ");
        int cols = sc.nextInt();

        char[][] letters = new char[rows][cols];

        // element assignment
        for (int row = 0; row < letters.length; row++) {
            for (int col = 0; col < letters[row].length; col++) {
                System.out.print("Enter a character (Row  " + row + ", column " + col +"): ");
                letters[row][col] = sc.next().charAt(0);
            }
        }

        int count = 0;  // counter variable
        System.out.print("Target: ");   // ask which character to track
        char target = sc.next().charAt(0);

        for (int row = 0; row < letters.length; row++) {
            for (int col = 0; col < letters[row].length; col++) {
                if (letters[row][col] == target) {  // if the element matches the target
                    count++;    // increment counter
                }
            }
        }

        System.out.println("Character appearance: " + count + " times");

        sc.close();
    }
}


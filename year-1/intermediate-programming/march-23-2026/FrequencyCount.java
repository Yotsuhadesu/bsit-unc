/*
    Title: Frequency Counter
    Date: 23 March 2026
    Description: A Java program that counts the occurrences of a character in a string.
 */
import java.util.Scanner;

public class FrequencyCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input Text: ");
        String str = sc.nextLine();
        System.out.print("Input Character: ");
        char target = sc.next().charAt(0);
        int count = 0;  // counter variable
        for(char c : str.toCharArray()) {
            if(c == target) // if the current character matches the target
                count++;
        }
        System.out.println("Frequency count: " + count);
    }
}

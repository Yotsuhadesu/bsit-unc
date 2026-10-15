/*
    Title: Toggle Case
    Date: 23 March 2026
    Description: A Java program that prints lowercase characters into uppercase, and vice versa.
 */

import java.util.Scanner;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input: ");
        String str = sc.nextLine();

        System.out.print("Output: ");
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {  // print uppercase characters to lowercase
                System.out.print(str.toLowerCase().charAt(i));
            } else if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {   // print lowercase characters to uppercase
                System.out.print(str.toUpperCase().charAt(i));
            } else {
                System.out.print(str.charAt(i));    // print symbols
            }
        }
    }
}

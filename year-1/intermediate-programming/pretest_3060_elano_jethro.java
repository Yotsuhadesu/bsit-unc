/*
    Title: PARKING FEE CALCULATOR
    Date: 19 January 2026
    Description: A Java program that calculates parking fees for multiple vehicles based on specific rules.
 */

import java.util.*;

public class pretest_3060_elano_jethro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    // Scanner object

        // Iteration (Outer Loop): Ask the user how many vehicles they want to process.
        System.out.print("How many vehicles do you want to process? ");    // ask
        int number = sc.nextInt();

        // Use a for loop to repeat the calculation process for that number of vehicles.
        for (int i = 1; i <= number; i++) {
            char type;
            int stay;
            double total;

            do {
                // Selection (switch or if-else): Inside the loop, prompt the user for the vehicle
                // type (M for motorcycle, C for car, T for truck).
                System.out.println(" ");
                System.out.println("Vehicle " + i + ":");
                System.out.println("Vehicle Types:\nM - motorcycle\nC - car\nT - truck");
                System.out.print("Choice: ");
                type = sc.next().toUpperCase().charAt(0);

                if (type != 'M' && type != 'C' && type != 'T') {
                    System.out.println("Invalid car type. Please try again.");
                }
            } while (type != 'M' && type != 'C' && type != 'T');

            // Input Validation: Use a while or do-while loop to ensure the hours entered are a positive number.
            do {
                System.out.print("Parking hours: ");
                stay = sc.nextInt();

                if (stay < 0) {
                    System.out.println("Invalid stay time. Please try again.");
                }
            } while (stay < 0);

            // calculations and print calculated fee (surcharge for long stay)
            switch (type) {
                case 'M':
                    if (stay < 8) {
                        System.out.println("Calculated Fee:  ₱"+ stay * 2);
                    } else {
                        total = stay * 2;
                        System.out.printf("Calculated Fee:  ₱"+ (total + (total * .2)));
                    }
                    break;
                case 'C':
                    if (stay < 8) {
                        System.out.println("Calculated Fee:  ₱n" + stay * 5);
                    } else {
                        total = stay * 5;
                        System.out.println("Calculated Fee:  ₱" + (total + (total * .2)));
                    }
                    break;
                case 'T':
                    if (stay < 8) {
                        System.out.println("Calculated Fee:  ₱" + stay * 10);
                    } else {
                        total = stay * 10;
                        System.out.println("Calculated Fee:  ₱" + (total + (total * .2)));
                    }
                    break;
            }
        }
        sc.close();    
    }
}

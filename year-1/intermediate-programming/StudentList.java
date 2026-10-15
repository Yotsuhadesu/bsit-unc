/*
    Title: STUDENT LIST
    Date: 23 February 2026
    Description: A command line interface Java program that allows the user to add, view, search, update, and remove student in an ArrayList.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println();
            System.out.println("STUDENT RECORD MANAGER");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Remove Student");
            System.out.println("6. Exit Student");
            System.out.print("Enter Choice: "); // ask
            choice = sc.nextInt();  // get the input

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    list.add(sc.next());    // use next for one-liner declaration
                    System.out.println("Student added!");
                    break;
                case 2:
                    System.out.println("Student list: ");
                    if (list.isEmpty()) {
                        System.out.println("No students!");
                    } else {
                        for (String l : list) { // print
                            System.out.println(l);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter name to search: "); // tell name
                    boolean found = list.contains(sc.next());
                    if (found) {
                        System.out.println("Student found!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter index to update: ");
                    int i = sc.nextInt();
                    System.out.print("Enter new name: ");
                    list.set(i, sc.next()); // index based replacement
                    System.out.println("Student updated!");
                    break;
                case 5:
                    System.out.print("Enter index to remove: ");
                    list.remove(sc.nextInt());  // index based removal
                    System.out.println("Student removed!");
                    break;
                case 6:
                    System.out.println("Program ended!");
                    break;
                default:
                    System.out.println("Invalid choice!");  // for unidentified choices
            }
        } while (choice != 6);

        sc.close();
    }
}

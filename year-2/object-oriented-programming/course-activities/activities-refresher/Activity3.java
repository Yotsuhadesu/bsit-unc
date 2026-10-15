import java.util.Scanner;

public class Activity3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Student Number: ");
        String num = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Course: ");
        String course = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();

        System.out.printf("Student Number: %s\nName: %s\nCourse: %s\nAge: %d", num, name, course, age);
        sc.close();
    }
}

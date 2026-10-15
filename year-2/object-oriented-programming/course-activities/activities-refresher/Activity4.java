import java.util.Scanner;

public class Activity4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Address: ");
        String add = sc.nextLine();
        System.out.print("Fav Food: ");
        String food = sc.nextLine();
        System.out.print("Fav Color: ");
        String color = sc.nextLine();

        System.out.printf("My name is %s.\nI am %d years old.\nI live in %s.\nMy favorite food is %s.\nMy favorite color is %s.", name, age, add, food, color);

        sc.close();
    }
}

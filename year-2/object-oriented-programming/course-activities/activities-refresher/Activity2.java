import java.util.Scanner;

public class Activity2 {
    public static void greeting (String name) {
        System.out.println("Hello " + name + ". Welcome to Java Programming!");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Name: ");
        greeting(sc.nextLine());

        sc.close();
    }
}

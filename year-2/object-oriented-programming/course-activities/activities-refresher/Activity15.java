import java.util.Scanner;

public class Activity15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many numbers? ");
        int num = sc.nextInt();

        int i = 1;
        int sum = 0;
        while (i <= num) {
            System.out.print("Input " + (i++) + ": ");
            sum += sc.nextInt();
        }
        System.out.println("Sum: " + sum);

        sc.close();
    }
}

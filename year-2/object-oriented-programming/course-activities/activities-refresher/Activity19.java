import java.util.Scanner;

public class Activity19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many numbers? ");
        int num = sc.nextInt();

        int odd = 0;
        int even = 0;
        int sum = 0;

        for (int i = 1; i <= num; i++) {
            System.out.print("Input " + i + ": ");
            int input = sc.nextInt();
            if (input % 2 == 0) {
                even++;
            } else {
                odd++;
            }
            sum += input;
        }
        System.out.println("Odd count: " + odd);
        System.out.println("Even Count: " + even);
        System.out.println("Total: " + sum);

        sc.close();
    }
}

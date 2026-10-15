import java.util.Scanner;

public class Activity14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input: ");
        int i = sc.nextInt();

        int j = 1;
        while (j <= i) {
            System.out.println(j++);
        }

        sc.close();
    }
}

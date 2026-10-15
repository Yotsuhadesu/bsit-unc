import java.util.Scanner;

public class Activity6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Average Computer");
        System.out.print("English: ");
        double eng = sc.nextInt();
        System.out.print("Mathematics: ");
        double math = sc.nextInt();
        System.out.print("Science: ");
        double sci = sc.nextInt();

        double average = (eng + math + sci) / 3;

        System.out.printf("Average: %.2f", average);

        sc.close();
    }
}

import java.util.Scanner;

public class ME_SET_B_ELANO_JETHRO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input moisture
        System.out.print("Moisture count: ");
        int n = sc.nextInt();

        // initialize array length
        int[] moisture = new int[n];

        // input moisture
        System.out.print("Input moisture: ");
        for(int i = 0; i < n; ++i) {
            moisture[i] = sc.nextInt(); // moisture assignment
        }

        System.out.print("Input dryThreshold: ");
        int dryThresh = sc.nextInt();

        boolean isOn = false;   // sprinkler on/off detector for recovery mode
        int min = 0;    // timer
        int aboveThresh = 0;    // count if the sprinkler is on and the moisture hits above threshold
        for (int i = 0; i < n; i++) {
            if (moisture[i] >= dryThresh) {  // above threshold
                if (moisture[i] > dryThresh) {
                    if (isOn) {
                        aboveThresh++;
                        if (aboveThresh == 1) { // recovery mode validation
                            min++;
                            System.out.println(moisture[i] + ": Strictly greater than threshold. (Potential shut-off...) Sprinkler stays ON for this minute. (Minutes: " + min + ")");
                        } else {
                            System.out.println(moisture[i] + ": Strictly greater than threshold. Sprinkler is OFF (Minutes: " + min + ")");
                        }
                    } else {
                        System.out.println(moisture[i] + ": Above threshold. Sprinkler is OFF. (This minute does not count).");
                    }
                } else {    // equal to threshold
                    aboveThresh = 0;    // reset above threshold
                    isOn = true;
                    min++;  // add a minute
                    System.out.println(moisture[i] + ": Equal to threshold. Sprinkler stays ON (Recovery Mode). (Minutes: " + min + ")");
                }
            } else {    // below threshold
                aboveThresh = 0;    // reset above threshold
                isOn = true;
                min++;  // add a minute
                System.out.println(moisture[i] + ": Below threshold! Sprinkler turns ON. (Minutes: " + min + ")");
            }
        }

        System.out.println("Final result: " + min); // show result


        sc.close();
    }
}

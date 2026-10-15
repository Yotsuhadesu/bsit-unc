import java.util.ArrayList;
import java.util.Scanner;

/**
 * The program that calls all of the classes and runs the interface.
 * 
 * @author Jethro Elano (jethro.elano@unc.edu.ph)
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Floor floor = new Floor();
        ArrayList<Tile> tiles = new ArrayList<>();

        floor.enterFloorDimensions(scanner);
        floor.computeFloorArea();
        double floorArea = floor.getFloorArea();
        char choice;
        int i = 0;  // counter variable
        do {
            // ask for each tile's information
            System.out.println("\n------ Enter Tile Option " + (i + 1) + " ------");
            System.out.print("Tile Brand/Name: ");
            String tileBrand = scanner.nextLine();
            System.out.print("Tile Length (in cm): ");
            double tileLength = scanner.nextDouble();
            System.out.print("Tile Width (in cm): ");
            double tileWidth = scanner.nextDouble();
            System.out.print("Cost per Tile (in PHP): ");
            double tileCost = scanner.nextDouble();

            tiles.add(new Tile(tileBrand, tileLength, tileWidth, tileCost));    // assign the inputted values to a tile object inside the ArrayList

            // compute the tiles needed and total cost and assign it to a variable
            tiles.get(i).computeTilesNeeded(floorArea);
            int tilesNeeded = tiles.get(i).getTilesNeeded();
            tiles.get(i).computeTotalCost(tilesNeeded);
            double totalCost = tiles.get(i).getTotalCost();
            
            System.out.println("\nResult:");
            System.out.println("- Tiles Needed: " + tilesNeeded + " tiles");
            System.out.printf("- Total Cost: ₱%,.2f\n", totalCost);

            System.out.print("\nDo you want to enter another tile option? (Y/N): ");  
            choice = scanner.next().toUpperCase().charAt(0);
            scanner.nextLine();
            i++;
        } while(choice == 'Y');

        // get the tile with the highest cost
        int highIndex = 0;
        for (int j = 1; j < tiles.size(); j++) {
            if (tiles.get(j).getTotalCost() > tiles.get(highIndex).getTotalCost()) {
                highIndex = j;
            }
        }
        String highBrand = tiles.get(highIndex).getBrandName();
        double highCost = tiles.get(highIndex).getTotalCost();

        // get the tile with the lowest cost
        int lowIndex = 0;
         for (int j = 1; j < tiles.size(); j++) {
            if (tiles.get(j).getTotalCost() < tiles.get(lowIndex).getTotalCost()) {
                lowIndex = j;
            }
        }
        String lowBrand = tiles.get(lowIndex).getBrandName();
        double lowCost = tiles.get(lowIndex).getTotalCost();

        System.out.println("\n" + "=".repeat(12) + " SUMMARY " + "=".repeat(12));
        System.out.println("Highest Budget Needed:");
        System.out.printf("- Brand: %s (₱%,.2f total)\n", highBrand, highCost);
        System.out.println("Lowest Budget Needed:");
        System.out.printf("- Brand: %s (₱%,.2f total)\n", lowBrand, lowCost);
        System.out.println("=".repeat(34));

        scanner.close();
    }
}

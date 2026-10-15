import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarRental carRental = new CarRental();
        ArrayList<CarRental> carRentals = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CAR RENTAL COST CALCULATOR ===");
        System.out.print("Enter Total Kilometers Planned: ");
        int driveDistance = scanner.nextInt();
        carRental.setDriveDistance(driveDistance);
        scanner.nextLine();

        int i = 0;
        int choice;
        do {
            carRentals.add(new CarRental());
            CarRental carRentalChoice = carRentals.get(i);
            System.out.println();
            System.out.println("--- Enter Rental Company " + (i + 1) + " ---");
            carRentalChoice.setDriveDistance(driveDistance);
            System.out.print("Company Name: ");
            carRentalChoice.setCompanyName(scanner.nextLine());
            System.out.print("Base Rental Price (PHP): ");
            carRentalChoice.setRentalPrice(scanner.nextDouble());
            System.out.print("Included Kilometers: ");
            carRentalChoice.setIncludedDistance(scanner.nextInt());
            System.out.print("Excess Rate per KM (PHP): ");
            carRentalChoice.setExcessRate(scanner.nextDouble());
            System.out.println();

            carRentalChoice.setExcessDistance();
            int excessDistance = carRentalChoice.getExcessDistance();

            carRentalChoice.setExcessCharge();
            double excessCharge = carRentalChoice.getExcessCharge();

            carRentalChoice.setTotalCost();
            double totalCost = carRentalChoice.getTotalCost();

            System.out.println("Result: ");
            System.out.printf("- Excess KM: %d km\n", excessDistance);
            System.out.printf("- Excess Charge: ₱%,.2f\n", excessCharge);
            System.out.printf("- Total Cost: ₱%,.2f\n", totalCost);
            System.out.println();

            System.out.print("Do you want to enter another company? (Y/N) ");
            choice = scanner.next().toUpperCase().charAt(0);
            scanner.nextLine();
            i++;
        } while (choice == 'Y');
        
        int highIndex = 0;
        for (int j = 1; j < carRentals.size(); j++) {
            if (carRentals.get(highIndex).getTotalCost() < carRentals.get(j).getTotalCost()) {
                highIndex = j;
            }
        }

        CarRental highCarRental = carRentals.get(highIndex);
        String highCompanyname = highCarRental.getCompanyname();
        double highTotalCost = highCarRental.getTotalCost();

        int lowIndex = 0;
        for (int j = 1; j < carRentals.size(); j++) {
            if (carRentals.get(lowIndex).getTotalCost() > carRentals.get(j).getTotalCost()) {
                lowIndex = j;
            }
        }

        CarRental lowCarRental = carRentals.get(lowIndex);
        String lowCompanyName = lowCarRental.getCompanyname();
        double lowTotalCost = lowCarRental.getTotalCost();

        System.out.println();
        System.out.println("=".repeat(10) + " SUMMARY " + "=".repeat(10));
        System.out.println("Highest Total Cost: ");
        System.out.printf("- Company: %s (₱%,.2f total)\n", highCompanyname, highTotalCost);
        System.out.println();
        System.out.println("Lowest Total Cost: ");
        System.out.printf("- Company: %s (₱%,.2f total)\n", lowCompanyName, lowTotalCost);
        System.out.println("=".repeat(30));

        scanner.close();
    }
}
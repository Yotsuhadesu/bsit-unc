import java.util.Scanner;

/**
 * The Floor class is used to create a floor object that will hold the floor's dimensions and compute the area.
 * 
 * @author Jethro Elano (jethro.elano@unc.edu.ph)
 */

public class Floor {
    // encapsulated fields
    private double floorLength;
    private double floorWidth;
    private double floorArea;

    /**
     * constructors
     * 
     * @param floorLength
     * @param floorWidth
     */
    public Floor(double floorLength, double floorWidth) {
        this.floorLength = floorLength;
        this.floorWidth = floorWidth;
    }
    public Floor() {    // to use the class without parameters
        this(0.0, 0.0);
    }

    // setters for each field for initialization or value assignment
     public void setFloorLength(double floorLength) {
        this.floorLength = floorLength;
    }
    public void setFloorWidth(double floorWidth) {
        this.floorWidth = floorWidth;
    }
    
    // getters for returning the values of each field
    public double getFloorLength() {
        return this.floorLength;
    }
    public double getFloorWidth() {
        return this.floorWidth;
    }
    public double getFloorArea() {
        return this.floorArea;
    }
    
    
    // miscellaneous methods
    public void enterFloorDimensions(Scanner scanner) { // prompting the user to enter the floor's dimensions
        System.out.println("==== FLOOR TILING CALCULATOR ====");
        System.out.print("Enter Floor Length (in meters): ");
        setFloorLength(scanner.nextDouble());
        System.out.print("Enter Floor Width (in meters): ");
        setFloorWidth(scanner.nextDouble());
        scanner.nextLine();
    }
    public void computeFloorArea() {
        this.floorArea = this.floorLength * this.floorWidth; 
    }
}

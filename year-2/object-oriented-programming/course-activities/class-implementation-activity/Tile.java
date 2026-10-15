/**
 * The Tile class is used to create tile objects that will hold their dimensions and access utility methods.
 * 
 * @author Jethro Elano (jethro.elano@unc.edu.ph)
 */

public class Tile {
    // encapsulated fields
    private String brandName;
    private double tileLength;
    private double tileWidth;
    private double tileCost;
    private int tilesNeeded;
    private double totalCost;
    
    /**
     * constructors
     * 
     * @param brandName
     * @param tileLength
     * @param tileWidth
     * @param tileCost
     */
    public Tile(String brandName, double tileLength, double tileWidth, double tileCost) {
        this.brandName = brandName;
        this.tileLength = tileLength;
        this.tileWidth = tileWidth;
        this.tileCost = tileCost;
    }

    // setters for each field for initialization or value assignment
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    public void setTileLength(double tileLength) {
        this.tileLength = tileLength;
    }
    public void setTileWidth(double tileWidth) {
        this.tileWidth = tileWidth;
    }
    public void setTileCost(double tileCost) {
        this.tileCost = tileCost;
    }

    // getters that returns each field's value
    public String getBrandName() {
        return this.brandName;
    }
    public double getTileArea() {
        return (this.tileLength / 100) * (this.tileWidth / 100);    // get tile area in meters
    }
    public void computeTilesNeeded(double floorArea) {
        this.tilesNeeded = (int) Math.ceil(floorArea / getTileArea());  // divide the floor area to tile area in square meters and round up to the nearest whole number
    }
    public int getTilesNeeded() {
        return this.tilesNeeded;   
    }
    public void computeTotalCost(double tilesNeeded) {
        this.totalCost = this.tileCost * tilesNeeded;   // assign the value to the totalCost field
    }
    public double getTotalCost() {
        return this.totalCost;
    }
}


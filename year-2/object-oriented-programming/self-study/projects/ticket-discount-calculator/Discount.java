import java.util.Scanner;

public class Discount {
    private int attendeesCount;
    private boolean hasDiscount;
    private double discountAmount;

    public Discount() {
        this.attendeesCount = 0;
        this.hasDiscount = false;
    }
    
    public void setHasDiscount() {
        this.hasDiscount = this.attendeesCount >= 10;
    }
    public void setDiscountAmount(double subTotal, double discountRate) {
        this.discountAmount = (this.hasDiscount) ? subTotal * (discountRate) / 100 : subTotal;
    }

    public int getAttendeesCount() {
        return this.attendeesCount;
    }
    public boolean getHasDiscount() {
        return this.hasDiscount = this.attendeesCount >= 10;
    }
    public double getDiscountAmount() {
        return this.discountAmount;
    }

    public void askAttendeesCount(Scanner scanner) {
        System.out.println("=== EVENT TICKET CALCULATOR ===");
        System.out.print("Enter number of attendees: ");
        this.attendeesCount = scanner.nextInt();
    }
}

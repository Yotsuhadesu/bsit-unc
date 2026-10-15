public class Ticket {
    private String packageName;
    private double pricePerTicket;
    private double discountRate;
    private double subTotal;
    private double finalTotal;

    public Ticket(String packagename, double pricePerTicket, double discountRate) {
            this.packageName = packagename;
            this.pricePerTicket = pricePerTicket;
            this.discountRate = discountRate;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
    public void setPricePerticket(int pricePerTicket) {
        this.pricePerTicket = pricePerTicket;
    }
    public void setSubTotal(int attendeesCount) {
        this.subTotal = this.pricePerTicket * attendeesCount;
    }
    public void setFinalTotal(double discountAmount) {
        this.finalTotal = this.subTotal - discountAmount;
    }

    public String getPackageName() {
        return this.packageName;
    }
    public double getSubTotal() {
        return this.subTotal;
    }
    public double getFinalTotal() {
        return this.finalTotal;
    }

    public void askPackageOptions() {
        
    }

    public void displaySummary() {
        System.out.println("=".repeat(10) + " SUMMARY " + "=".repeat(10));
        System.out.println("Most Savings: ");
        System.out.print("- Package: %s (%,.2f)\n");
        System.out.println("Least Savings: ");
        System.out.print("- Package: %s (%,.2f)");
    }
}

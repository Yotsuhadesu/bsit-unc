import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Represents one transaction in the Transactions.tsv file.
 * The data stored are encapsulated, and quantity, price, and delivery fee 
 * are checked before they are accepted.
 */
public class Transaction implements Record, IPersistable {
    private int tranID;
    private LocalDate tranDate;
    private String cusLastName;
    private String cusFirstName;
    private String cusConNum;
    private String delAddress;
    private String item;
    private int itemQuantity;
    private BigDecimal itemPrice;
    private BigDecimal delFee;
    private BigDecimal totAmount;
    private String payMethod;
    private String tranStatus;

    public Transaction(int tranID, LocalDate tranDate, String cusLastName, String cusFirstName, String cusConNum, String delAddress, String item, int itemQuantity, BigDecimal itemPrice, BigDecimal delFee, BigDecimal totAmount, String payMethod, String tranStatus) {
        this.tranID = tranID;
        this.tranDate = tranDate;
        this.cusLastName = cusLastName;
        this.cusFirstName = cusFirstName;
        this.cusConNum = cusConNum;
        this.delAddress = delAddress;
        this.item = item;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
        this.delFee = delFee;
        this.totAmount = totAmount;
        this.payMethod = payMethod;
        this.tranStatus = tranStatus;
    }
    public Transaction() {
        
    }
    
    @Override 
    public int getRecordID() {
        return this.tranID;
    }
    @Override 
    public ArrayList<Object> getRecordData() {
        ArrayList<Object> transactionData = new ArrayList<>();
        transactionData.add(this.tranID);
        transactionData.add(this.tranDate);
        transactionData.add(this.cusLastName);
        transactionData.add(this.cusFirstName);
        transactionData.add(this.cusConNum);
        transactionData.add(this.delAddress);
        transactionData.add(this.item);
        transactionData.add(this.itemQuantity);
        transactionData.add(this.itemPrice);
        transactionData.add(this.delFee);
        transactionData.add(this.totAmount);
        transactionData.add(this.payMethod);
        transactionData.add(this.tranStatus);
        return transactionData;
    }
    @Override 
    public String toFileLine() {
        ArrayList<Object> recordData = getRecordData();
        ArrayList<String> stringRecordData = new ArrayList<>();
		
        for (Object data : recordData) {
			stringRecordData.add(String.valueOf(data));
        }

        return String.join("\t", stringRecordData);
    }
    @Override 
    public void fromFileLine(String line) {
        String[] lineParts = line.split("\t");
		this.tranID = Integer.parseInt(lineParts[0]); 
		this.tranDate = LocalDate.parse(lineParts[1]); 
		this.cusLastName = lineParts[2]; 
		this.cusFirstName = lineParts[3]; 
		this.cusConNum = lineParts[4]; 
		this.delAddress = lineParts[5]; 
		this.item = lineParts[6]; 
		this.itemQuantity = Integer.parseInt(lineParts[7]); 
		this.itemPrice = new BigDecimal(lineParts[8]); 
		this.delFee = new BigDecimal(lineParts[9]); 
		this.totAmount = new BigDecimal(lineParts[10]); 
		this.payMethod = lineParts[11]; 
		this.tranStatus = lineParts[12];
    }
    
    public void setTranID(int tranID) {
        this.tranID = tranID;
    }
    public void setTranDate(LocalDate tranDate) {
        this.tranDate = tranDate;
    }
    public void setCusLastName(String cusLastName) {
        this.cusLastName = cusLastName;
    }
    public void setCusFirstName(String cusFirstName) {
        this.cusFirstName = cusFirstName;
    }
    public void setCusConNum(String cusConNum) {
        this.cusConNum = cusConNum;
    }
    public void setDelAddress(String delAddress) {
        this.delAddress = delAddress;
    }
    public void setItem(String item) {
        this.item = item;
    }
    /**
     * Set the item's quantity.
     * 
     * @param itemQuantity the item quantity
     * @throws InvalidQuantityException if the quantity is less than or equal to zero
     */
    public void setItemQuantity(int itemQuantity) throws InvalidQuantityException {
        if (itemQuantity <= 0) {
            throw new InvalidQuantityException(">> Invalid item quantity.");
        } else {
            this.itemQuantity = itemQuantity;
        }
    }
    /**
     * Sets the item's price.
     * 
     * @param itemPrice the price of the item
     * @throws InvalidPriceException if the item price is less than or equal to zero
     */
    public void setItemPrice(BigDecimal itemPrice) throws InvalidPriceException {
        if (itemPrice.compareTo(BigDecimal.ZERO) < 0 || itemPrice.compareTo(BigDecimal.ZERO) == 0) {
            throw new InvalidPriceException(">> Invalid item price.");
        } else {
            this.itemPrice = itemPrice;
        }
    }
    /**
     * Sets the delivery fee.
     * 
     * @param delFee the delivery fee
     * @throws InvalidTransactionException if the delivery fee is less than zero
     */
    public void setDelFee(BigDecimal delFee) throws InvalidTransactionException {
        if (delFee.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidTransactionException(">> Invalid delivery fee.");
        } else {
            this.delFee = delFee;
        }
    }
    public void setTotAmount(BigDecimal totAmount) {
        this.totAmount = totAmount;
    }
     public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }
    public void setTranStatus(String tranStatus) {
        this.tranStatus = tranStatus;
    }
   
    public LocalDate getTranDate() {
        return this.tranDate;
    }
    public String getCusLastName() {
        return this.cusLastName;
    }
    public String getCusFirstName() {
        return this.cusFirstName;
    }
    public String getCusConNum() {
        return this.cusConNum;
    }
    public String getDelAddress() {
        return this.delAddress;
    }
    public String getItem() {
        return this.item;
    }
    public int getItemQuantity() {
        return this.itemQuantity;
    }
    public BigDecimal getItemPrice() {
        return this.itemPrice;
    }
    public BigDecimal getDelFee() {
        return this.delFee;
    }
    /**
     * This computes the total amount by multiplying the item price and quantity, 
     * and then adding the delivery fee.
     * Call this only after the price, quantity, and delivery fee are set.
     */
    public void compTotAmount() {
        this.totAmount = this.itemPrice.multiply(new BigDecimal(String.valueOf(this.itemQuantity))).add(this.delFee);
    }
     public BigDecimal getTotAmount() {
        return this.totAmount;
    }
    public String getPayMethod() {
        return this.payMethod;
    }
    public String getTranStatus() {
        return this.tranStatus;
    }
}
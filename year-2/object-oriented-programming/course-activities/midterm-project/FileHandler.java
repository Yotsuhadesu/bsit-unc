import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * A class that can be called directly to perform file operations.
 * Contains one private static File object that represents Transactions.tsv.
 */
public class FileHandler {
    private static File file = new File("Transactions.tsv");

	private static void exCheck() {
		if (!file.exists()) {
			try {
				System.out.println(">> Transaction file doesn't exist.");
				file.createNewFile();
				System.out.println(">> Transaction file created successfully.");
			} catch (Exception e) {
				System.out.println(">> An error occurred while trying to create the transaction file.");
			}
		}
	}

    // Transaction_ID	Date	Last_Name	First_Name	Contact_Number	Delivery_Address	Item    Quantity    Item_Price  Delivery_Fee    Total_Amount	Payment_Method	Status
    public static int getLastTranId() {
		exCheck();
        int maxId = 0;
		if (file.length() == 0) {
			System.out.println(">> There are no transaction records.");
			return maxId;
		}

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                int currentId = Integer.parseInt(line.split("\t")[0]);  
                if (currentId > maxId) {
                    maxId = currentId;
                } else if (currentId == maxId) {
                    System.out.println(">> Identical transaction ids detected: " + currentId);
                }
            }

            System.out.println(">> Last transaction id found.");
        } catch (Exception e) {
            System.out.println(">> An error occurred while finding the last transaction id.");
            e.printStackTrace();
        }
        
        return maxId;
    }

	public static boolean saveTransactions(ArrayList<Transaction> transactions) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			for (Transaction transaction : transactions) {
				writer.write(transaction.toFileLine());
				writer.newLine();
			}
			return true;
		} catch (Exception e) {
			System.out.println(">> An error occurred while saving transactions to file.");
			e.printStackTrace();
			return false;
		}
	}

	public static ArrayList<Transaction> loadTransactions() {
		if (file.length() == 0) {
			System.out.println(">> There are no transaction records.");
			return new ArrayList<>();
		}
		ArrayList<Transaction> transactions = new ArrayList<>();
		String line;
		int lineNum = 1;
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			while ((line = reader.readLine()) != null) {
				try {
					Transaction transaction = new Transaction();
					transaction.fromFileLine(line);
					transactions.add(transaction);
				} catch (Exception e) {
					System.out.println(">> Corrupted transaction record found at line " + lineNum + ".");
					System.out.println(">> Please exit the program to avoid transaction omission.");
				}
				lineNum++;
			}
		} catch (Exception e) {
			System.out.println(">> An error occurred while loading transactions.");
			e.printStackTrace();
		}
		return transactions;
	}
}
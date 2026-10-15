package FInalsPractice;

public class ArrayString {
    public static void main(String[] args) {
        String[][] words = {
                {"Tani", "Banana", "Oats", "Cain"},
                {"Perseus", "Medusa", "Chrome", "Suika"},
                {"Hayai", "Naomi", "Apple", "Ephemeral"},
                {"Naoka", "Kaori", "Nishi", "Ririr"}
        };
        for (String[] row : words) {
            for (String column : row) {
                StringBuffer sb = new StringBuffer(column);
                String reverse = sb.reverse().toString();
                if (column.equalsIgnoreCase(reverse)) {
                    System.out.println("The word " + column + " is a palindrome.");
                    return;
                }
            }
        }
        System.out.println("No palindromes found.");
    }
}

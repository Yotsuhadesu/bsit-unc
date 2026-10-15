package FInalsPractice;

import java.util.ArrayList;
import java.util.Comparator;

public class ArrayArrayListString {
    public static void main(String[] args) {
        String[][] words = {
                {"pen", "men", "nen", "heal"},
                {"papa", "sister", "near", "spear"},
                {"meal", "pray", "May", "nice"}
        };
        ArrayList<String> longWords = new ArrayList<>();
        for (String[] row : words) {
            for (String column: row) {
                int wordLength = column.length();
                if (wordLength > 4) {
                    longWords.add(column);
                }
            }
        }
        longWords.sort(Comparator.naturalOrder());
        for (String word : longWords) {
            System.out.println(word);
        }
    }
}

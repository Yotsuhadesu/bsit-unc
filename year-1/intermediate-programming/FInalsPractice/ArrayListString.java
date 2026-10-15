package FInalsPractice;

import java.util.ArrayList;

public class ArrayListString {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Mango");
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Avocado");
        fruits.add("Orange");
        fruits.remove(2);   // remove Apple
        for (String fruit : fruits) {
            System.out.println(fruit.toUpperCase());
        }
    }
}

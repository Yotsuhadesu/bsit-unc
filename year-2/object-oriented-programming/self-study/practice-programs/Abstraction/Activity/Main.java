package Abstraction.Activity;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.describe();  // concrete method from the abstract class
        circle.area();  // abstract method from the abstract class
        circle.play();  // abstract method from the interface class
    }
}

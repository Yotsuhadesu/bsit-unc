package Abstraction.Activity;

public abstract class Shape {   // abstract class
    public void describe() {    // concrete method
        System.out.println("This is a shape. But what shape is it?");
    }
    abstract public void area();    // abstract method
}

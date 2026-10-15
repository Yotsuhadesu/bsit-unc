package Polymorphism;
public class Student extends Person {
    public void sleep() {   
        super.sleep();  // overriding method
        System.out.println("The student sleeps for 6 hours due to online games.");
    }
}

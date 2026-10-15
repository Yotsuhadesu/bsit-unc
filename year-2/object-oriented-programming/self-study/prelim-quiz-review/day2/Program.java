package day2;

/**
 * @title Day 2 Sample Program
 * @description A sample program for day 2 of reviewing java fundamentals.
 * @author Elano, Jethro B.
 */
public class Program {  // a public class with the same name as the source file (PascalCase)
    public static void main(String[] args) {    // main method
        int x = 123_456;
        System.out.println(x);
        char a = '\u0456';
        System.out.println(a);
        int y = 0;
        System.out.println(y++);
        String archonAge = 250 + 250 + "Lesser" + "Lord" + "Kusanali" + ":";   
        System.out.println(archonAge);
    }
}

class AnotherClass {    // another class (breaks the one-class-per-file convention)

}
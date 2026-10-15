package Abstraction.Interface;

public class Main {
    public static void main(String[] args) {
        Rat rat = new Rat();
        Eagle eagle = new Eagle();
        Cat cat = new Cat();
        eagle.chase();
        rat.flee();
        cat.chase();
        cat.flee();
    }
}

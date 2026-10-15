package Abstraction.Activity;

public class Circle extends Shape implements Playable{
    @Override
    public void area() {
        System.out.println("This shape has an area without straight sides.");
    }
    @Override
    public void play() {
        System.out.println("*The circle is rolling.*");
    }
}

package Abstraction.Interface;

public class Cat implements Prey, Predator{
    @Override
    public void flee() {
        System.out.println("*The cat is fleeing.*");
    }
    @Override
    public void chase() {
        System.out.println("*The cat is hunting.*");
    }
}
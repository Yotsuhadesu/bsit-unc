package Abstraction.Interface;

public class Rat implements Prey {
    @Override
    public void flee() {
        System.out.println("*The rat is running.*");
    }
}

package Abstraction.Interface;

public class Eagle implements Predator{
    @Override
    public void chase() {
        System.out.println("*The eagle is chasing.*");
    }
}

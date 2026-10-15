package programs;
public class Knight extends ChessPiece {
    public Knight(String color, String position) {
        super(color, position);
    }

    @Override 
    public void move() {
        System.out.println("Knight moved on an L-shaped path.");
    }

    public void knightSpecificMethod() {
        System.out.println("This is a method unique to the Knight class.");
    }
}

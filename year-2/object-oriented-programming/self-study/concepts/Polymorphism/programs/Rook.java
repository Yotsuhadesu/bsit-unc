package programs;
public class Rook extends ChessPiece {
    public Rook(String color, String position) {
        super(color, position);
    }

    @Override 
    public void move() {
        System.out.println("Rook moved on a straight line.");
    }

    public void rookSpecificMethod() {
        System.out.println("This is a method unique to the Rook class.");
    }
}

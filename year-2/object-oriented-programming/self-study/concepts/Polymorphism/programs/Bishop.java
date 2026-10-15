package programs;
public class Bishop extends ChessPiece {
    public Bishop(String color, String position) {
        super(color, position);
    }

    @Override 
    public void move() {
        System.out.println("Bishop moved diagonally.");
    }

    public void bishopSpecificMethod() {
        System.out.println("This is a method unique to the Bishop class.");
    }
}

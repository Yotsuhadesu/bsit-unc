package programs;
public class Pawn extends ChessPiece {
    public Pawn(String color, String position) {
        super(color, position);
    }

    @Override 
    public void move() {
        System.out.println("Pawn moves one square in front and 2 squares infront if it hasn't moved yet.");
    }

    public void pawnSpecificMethod() {
        System.out.println("This is a method unique to the Pawn class.");
    }
}

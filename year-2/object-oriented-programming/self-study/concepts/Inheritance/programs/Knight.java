package programs;
public class Knight extends ChessPiece {
    public Knight(String color, String position) {
        super(color, position);
    }
    @Override
    public void move() {
        System.out.println("The knight moves in an L-shaped path.");
    }
}
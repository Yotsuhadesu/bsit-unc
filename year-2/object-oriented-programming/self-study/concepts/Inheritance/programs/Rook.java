package programs;
public class Rook extends ChessPiece {
    public Rook(String color, String position) {
        super(color, position);
    }
    @Override
    public void move() {
        super.move();
        System.out.println("The rook moves horizontally or vertically.");
    }
}
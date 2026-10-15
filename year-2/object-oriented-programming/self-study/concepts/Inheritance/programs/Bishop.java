package programs;
public class Bishop extends ChessPiece {
    public Bishop(String color, String position) {
        super(color, position);
    }
    @Override
    public void move() {
        System.out.println("The bishop moves diagonally.");
    }
}
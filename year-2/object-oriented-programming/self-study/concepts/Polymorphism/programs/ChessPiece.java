package programs;
public class ChessPiece {
    String color;
    String position;

    public ChessPiece(String color, String position) {
        this.color = color;
        this.position = position;
    }

    public void move() {
        System.out.println("An unknown piece doesn't move.");
    }
}
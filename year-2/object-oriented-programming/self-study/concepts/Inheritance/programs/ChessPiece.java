package programs;
public class ChessPiece {
    protected String color;
    protected String position;

    public ChessPiece(String color, String position) {
        this.color = color;
        this.position = position;
    }

    public void move() {
        System.out.println("Unknown piece");
    }
}
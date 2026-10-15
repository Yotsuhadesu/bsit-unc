package programs;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<ChessPiece> chessPieces = new ArrayList<>();

        chessPieces.add(new Knight("black", "b8"));
        chessPieces.add(new Bishop("white", "c1"));
        chessPieces.add(new Rook("black", "a8"));
        chessPieces.add(new Pawn("white", "a2"));

        for (ChessPiece chessPiece : chessPieces) {
            chessPiece.move();
        }

        // it would be something like this without polymorphism
        for (int i = 0; i < chessPieces.size(); i++) {
            ChessPiece chessPiece = chessPieces.get(i);
            if (chessPiece instanceof Knight) {
                Knight knight = (Knight) chessPiece;
                knight.knightSpecificMethod();
            }
            else if (chessPiece instanceof Bishop) {
                Bishop bishop = (Bishop) chessPiece;
                bishop.bishopSpecificMethod();
            }
            else if (chessPiece instanceof Rook) {
                Rook rook = (Rook) chessPiece;
                rook.rookSpecificMethod();
            }
            else if (chessPiece instanceof Pawn) {
                Pawn pawn = (Pawn) chessPiece;
                pawn.pawnSpecificMethod();
            }
        }
    }
}

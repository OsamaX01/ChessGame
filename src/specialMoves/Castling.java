package specialMoves;

import board.Board;
import generalComponents.Square;

public class Castling {
    public static void perform(Board board, Square kingSquare, Square rookSquare) {
        if (board == null || kingSquare == null || rookSquare == null) {
            throw new IllegalArgumentException("NullPointer argument");
        }

        board.getPieceAt(kingSquare).getOwner().setHasCastled(true);

        if (rookSquare.getColumn() == 0) {
            board.move(rookSquare, new Square(rookSquare.getRow(), 3));
        } else {
            board.move(rookSquare, new Square(rookSquare.getRow(), 5));
        }
    }
}

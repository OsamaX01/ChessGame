package general;

import board.StandardChessBoard;
import pieces.Piece;

public class GameState {
    public boolean isStillInCheck(StandardChessBoard board, Square from, Square to) {
        board.removePiece(board.getPieceAt(to));
        Piece currentPiece = board.getPieceAt(from);
        board.removePiece(currentPiece);
        currentPiece.setLocation(to);
        board.addPiece(currentPiece);
        return isCheck(board);
    }

    public boolean isCheck(StandardChessBoard board) {
        return true;
    }

    public boolean isCheckMate() {
        return true;
    }
}

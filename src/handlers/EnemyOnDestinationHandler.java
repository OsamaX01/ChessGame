package handlers;

import board.Board;
import generalComponents.Square;
import pieces.Piece;

public class EnemyOnDestinationHandler extends BaseHandler {

    @Override
    protected boolean isValid(Board board, Square from, Square to) {
        Piece toPiece = board.getPieceAt(to);
        return (toPiece != null && !toPiece.getOwner().equals(board.getPieceAt(from).getOwner()));
    }
}

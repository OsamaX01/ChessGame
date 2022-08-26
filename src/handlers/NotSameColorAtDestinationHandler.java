package handlers;

import board.Board;
import generalComponents.Square;
import pieces.Piece;

public class NotSameColorAtDestinationHandler extends BaseHandler {

    @Override
    protected boolean isValid(Board board, Square from, Square to) {
        Piece piece = board.getPieceAt(to);
        return (piece == null || piece.getOwner() != board.getPieceAt(from).getOwner());
    }
}
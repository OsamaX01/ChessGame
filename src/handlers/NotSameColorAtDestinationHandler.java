package handlers;

import board.Board;
import pieces.Piece;
import general.Location;

public class NotSameColorAtDestinationHandler extends BaseHandler {

    @Override
    protected boolean isValid(Board board, Location from, Location to) {
        Piece piece = board.getPieceAt(to);
        return (piece == null || piece.getOwner() != board.getPieceAt(from).getOwner());
    }
}
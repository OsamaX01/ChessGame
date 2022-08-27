package handlers;

import board.Board;
import generalComponents.Player;
import generalComponents.Square;

public class NotCastledHandler extends BaseHandler {
    @Override
    protected boolean isValid(Board board, Square from, Square to) {
        Player owner = board.getPieceAt(from).getOwner();
        return !owner.hasCastled();
    }
}

package handlers;

import board.Board;
import general.Square;

public class EmptyDestinationHandler extends BaseHandler {

    @Override
    protected boolean isValid(Board board, Square from, Square to) {
        return (board.getPieceAt(to) == null);
    }
}

package handlers;

import board.Board;
import generalComponents.Square;

public class AtTheFirstMoveHandler extends BaseHandler {

    @Override
    protected boolean isValid(Board board, Square from, Square to) {
        return board.getPieceAt(from).isFirsMove();
    }
}

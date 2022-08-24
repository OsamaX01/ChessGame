package handlers;

import board.Board;
import general.Square;

public class HorizontalMoveHandler extends BaseHandler {

    @Override
    protected boolean isValid(Board board, Square from, Square to) {
        return from.getRow() == to.getRow();
    }
}

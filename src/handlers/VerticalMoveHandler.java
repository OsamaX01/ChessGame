package handlers;

import board.Board;
import general.Square;

public class VerticalMoveHandler extends BaseHandler {

    @Override
    protected boolean isValid(Board board, Square from, Square to) {
        return from.getColumn() == to.getColumn();
    }
}

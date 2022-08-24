package handlers;

import board.Board;
import general.Square;

public class NullPointerHandler extends BaseHandler {

    @Override
    protected boolean isValid(Board board, Square from, Square to) {
        return (board != null && from != null && to != null);
    }
}
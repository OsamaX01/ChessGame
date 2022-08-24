package handlers;

import board.Board;
import general.Square;

public class RightToLeftDiagonalsHandler extends BaseHandler {

    @Override
    protected boolean isValid(Board board, Square from, Square to) {
        return Math.abs(from.getRow() + from.getColumn()) == Math.abs(to.getRow() + to.getColumn());
    }
}


package handlers;

import board.Board;
import generalComponents.Square;

public class LeftToRightDiagonalsHandler extends BaseHandler {

    @Override
    protected boolean isValid(Board board, Square from, Square to) {
        return Math.abs(from.getRow() - from.getColumn()) == Math.abs(to.getRow() - to.getColumn());
    }
}

package handlers;

import board.Board;
import general.Square;

public class ValidDestinationHandler extends BaseHandler {

    @Override
    protected boolean isValid(Board board, Square from, Square to) {
        boolean result = (to.getColumn() >= 0 && to.getColumn() < board.getColumn());
        result = result && (to.getRow() >= 0 && to.getRow() < board.getRow());
        return  result;
    }
}

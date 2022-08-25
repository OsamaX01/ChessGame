package handlers;

import board.Board;
import general.Square;

public class ValidStartLocationHandler extends BaseHandler {

    @Override
    protected boolean isValid(Board board, Square from, Square to) {
        boolean result = (from.getColumn() >= 0 && from.getColumn() < board.getColumn());
        result = result && (from.getRow() >= 0 && from.getRow() < board.getRow());
        return  result;
    }
}
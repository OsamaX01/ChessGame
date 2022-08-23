package handlers;

import board.Board;
import general.Location;

public class LeftToRightDiagonalsHandler extends BaseHandler {

    @Override
    protected boolean isValid(Board board, Location from, Location to) {
        return Math.abs(from.getRow() - from.getColumn()) == Math.abs(to.getRow() - to.getColumn());
    }
}

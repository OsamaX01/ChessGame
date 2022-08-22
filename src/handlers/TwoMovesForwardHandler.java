package handlers;

import board.Board;
import general.Location;

import board.Board;
import general.Location;

public class TwoMovesForwardHandler extends BaseHandler {
    @Override
    protected boolean isValid(Board board, Location from, Location to) {
        return to.getRow() == from.getRow() + 2;
    }
}

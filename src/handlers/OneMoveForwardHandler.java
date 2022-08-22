package handlers;

import board.Board;
import general.Location;

public class OneMoveForwardHandler extends BaseHandler {
    @Override
    protected boolean isValid(Board board, Location from, Location to) {
        return to.getRow() == from.getRow() + 1;
    }
}

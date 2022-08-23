package handlers;

import board.Board;
import general.Location;

public class VerticalMoveHandler extends BaseHandler {

    @Override
    protected boolean isValid(Board board, Location from, Location to) {
        return from.getColumn() == to.getColumn();
    }
}

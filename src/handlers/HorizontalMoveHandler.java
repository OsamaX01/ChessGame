package handlers;

import board.Board;
import general.Location;

public class HorizontalMoveHandler extends BaseHandler {

    @Override
    protected boolean isValid(Board board, Location from, Location to) {
        return from.getRow() == to.getRow();
    }
}

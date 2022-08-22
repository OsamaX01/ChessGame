package handlers;

import board.Board;
import general.Location;

public class NullPointerHandler extends BaseHandler {

    @Override
    protected boolean isValid(Board board, Location from, Location to) {
        return (board != null && from != null && to != null);
    }
}
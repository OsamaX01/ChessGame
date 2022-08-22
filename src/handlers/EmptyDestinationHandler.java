package handlers;

import board.Board;
import general.Location;

public class EmptyDestinationHandler extends BaseHandler {

    @Override
    protected boolean isValid(Board board, Location from, Location to) {
        return (board.getPieceAt(to) == null);
    }
}

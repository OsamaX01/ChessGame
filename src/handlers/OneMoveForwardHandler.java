package handlers;

import board.Board;
import general.Color;
import general.Location;

public class OneMoveForwardHandler extends BaseHandler {
    @Override
    protected boolean isValid(Board board, Location from, Location to) {
        if (board.getPieceAt(from).getOwner().getColor() == Color.BLACK) {
            return to.getRow() == from.getRow() - 1;
        }
        return to.getRow() == from.getRow() + 1;
    }
}

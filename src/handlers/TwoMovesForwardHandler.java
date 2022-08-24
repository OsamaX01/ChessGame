package handlers;

import board.Board;
import general.Color;
import general.Location;

import board.Board;
import general.Location;

public class TwoMovesForwardHandler extends BaseHandler {
    @Override
    protected boolean isValid(Board board, Location from, Location to) {
        if (board.getPieceAt(from).getOwner().getColor() == Color.BLACK) {
            return to.getRow() == from.getRow() - 2;
        }
        return to.getRow() == from.getRow() + 2;
    }
}

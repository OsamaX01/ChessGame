package handlers;

import board.Board;
import generalComponents.Color;
import generalComponents.Square;

public class TwoMovesForwardHandler extends BaseHandler {
    @Override
    protected boolean isValid(Board board, Square from, Square to) {
        boolean result = to.getColumn() == from.getColumn();
        if (board.getPieceAt(from).getOwner().getColor() == Color.WHITE) {
            result = result && to.getRow() == from.getRow() + 2;
        } else {
            result = result && to.getRow() == from.getRow() - 2;
        }

        return result;
    }
}

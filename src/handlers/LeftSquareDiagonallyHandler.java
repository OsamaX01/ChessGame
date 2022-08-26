package handlers;

import board.Board;
import generalComponents.Color;
import generalComponents.Square;

public class LeftSquareDiagonallyHandler extends BaseHandler {

    @Override
    protected boolean isValid(Board board, Square from, Square to) {
        boolean result = to.getColumn() == from.getColumn() - 1;
        if (board.getPieceAt(from).getOwner().getColor() == Color.WHITE) {
            result = result && to.getRow() == from.getRow() + 1;
        } else {
            result = result && to.getRow() == from.getRow() - 1;
        }

        return result;
    }
}

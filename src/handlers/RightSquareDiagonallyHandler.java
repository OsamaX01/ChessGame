package handlers;

import board.Board;
import general.Color;
import general.Square;

public class RightSquareDiagonallyHandler extends BaseHandler {

    @Override
    protected boolean isValid(Board board, Square from, Square to) {
        boolean result = to.getColumn() == from.getColumn() + 1;
        if (board.getPieceAt(from).getOwner().getColor() == Color.WHITE) {
            result = result && to.getRow() == from.getRow() + 1;
        } else {
            result = result && to.getRow() == from.getRow() - 1;
        }

        return result;
    }
}

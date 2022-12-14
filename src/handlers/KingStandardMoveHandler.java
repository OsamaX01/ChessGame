package handlers;

import board.Board;
import generalComponents.Square;

public class KingStandardMoveHandler extends BaseHandler {
    @Override
    protected boolean isValid(Board board, Square from, Square to) {
        int[] x = {1, -1, 0, 0, 1, -1, 1, -1};
        int[] y = {0, 0, 1, -1, 1, 1, -1, -1};

        for (int i = 0; i < 8; i++) {
            if (from.getColumn() + x[i] == to.getColumn() && from.getRow() + y[i] == to.getRow()) {
                return true;
            }
        }

        return  false;
    }
}

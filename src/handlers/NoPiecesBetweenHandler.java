package handlers;

import board.Board;
import generalComponents.Square;

public class NoPiecesBetweenHandler extends BaseHandler {

    @Override
    protected boolean isValid(Board board, Square from, Square to) {
        int fromRow = from.getRow();
        int fromColumn = from.getColumn();
        while (true) {
            fromRow += getCloser(fromRow, to.getRow());
            fromColumn += getCloser(fromColumn, to.getColumn());
            if (fromRow == to.getRow() && fromColumn == to.getColumn()) {
                break;
            }
            if (board.getPieceAt(new Square(fromRow, fromColumn)) != null) {
                return false;
            }
        }
        return true;
    }

    private int getCloser(int from, int to) {
        int differance = to - from;
        if (differance == 0) {
            return 0;
        } else if (differance < 0) {
            return -1;
        } else {
            return 1;
        }
    }
}

package handlers;

import board.Board;
import general.Location;

public class NoPiecesBetweenHandler extends BaseHandler {

    @Override
    protected boolean isValid(Board board, Location from, Location to) {
        int fromRow = from.getRow();
        int fromColumn = from.getColumn();
        System.out.println(fromRow + " " + fromColumn);
        while (true) {
            fromRow += getCloser(fromRow, to.getRow());
            fromColumn += getCloser(fromColumn, to.getColumn());
            if (fromRow == to.getRow() && fromColumn == to.getColumn()) {
                break;
            }
            if (board.getPieceAt(new Location(fromRow, fromColumn)) != null) {
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

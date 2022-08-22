package handlers;

import board.Board;
import general.Location;

public class NoPiecesBetweenHandler extends BaseHandler {

    @Override
    protected boolean isValid(Board board, Location from, Location to) {
        int fromRow = from.getRow();
        int fromColumn = from.getColumn();
        while (fromRow != to.getRow() || fromColumn != to.getColumn()) {
            fromRow += getCloser(fromRow, to.getRow());
            fromColumn += getCloser(fromColumn, to.getColumn());
            if (board.getPieceAt(new Location(fromRow, fromColumn)) != null) {
                return false;
            }
        }
        return true;
    }

    private int getCloser(int from, int to) {
        int differance = from - to;
        if (differance == 0) {
            return 0;
        } else if (differance < 0) {
            return -1;
        } else {
            return 1;
        }
    }
}
package simulators;

import board.StandardChessBoard;
import generalComponents.Square;

import java.util.ArrayList;

public class SquaresBetween {
    public static ArrayList<Square> getSquaresBetween(StandardChessBoard board, Square first, Square second) {
        ArrayList<Square> squares = new ArrayList<>();
        int fromRow = first.getRow();
        int fromColumn = first.getColumn();
        do {
            fromRow += getCloser(fromRow, second.getRow());
            fromColumn += getCloser(fromColumn, second.getColumn());
            squares.add(new Square(fromRow, fromColumn));
        } while (fromRow != second.getRow() || fromColumn != second.getColumn());

        return squares;
    }

    private static int getCloser(int from, int to) {
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

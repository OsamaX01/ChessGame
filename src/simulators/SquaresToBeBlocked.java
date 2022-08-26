package simulators;

import board.StandardChessBoard;
import generalComponents.Square;

import java.util.ArrayList;

public class SquaresToBeBlocked {
    public static ArrayList<Square> getSquaresBetweenKingAndCheckingPiece(StandardChessBoard board, Square kingSquare, Square checkingSquare) {
        ArrayList<Square> squares = new ArrayList<>();
        int fromRow = kingSquare.getRow();
        int fromColumn = kingSquare.getColumn();
        do {
            fromRow += getCloser(fromRow, checkingSquare.getRow());
            fromColumn += getCloser(fromColumn, checkingSquare.getColumn());
            squares.add(new Square(fromRow, fromColumn));
        } while (fromRow != checkingSquare.getRow() || fromColumn != checkingSquare.getColumn());

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

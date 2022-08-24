package board;

import general.Square;
import general.Player;
import pieces.Piece;

import java.util.Arrays;

abstract public class Board {
    private final int row;
    private final int column;
    Piece[][] pieces;

    public Board(int row, int column) {
        if (row <= 0 || column <= 0) {
            throw new IllegalArgumentException();
        }
        this.row = row;
        this.column = column;
        pieces = new Piece[row][column];
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Piece getPieceAt(Square square) {
        if (square == null) {
            throw new NullPointerException();
        }
        return pieces[square.getRow()][square.getColumn()];
    }

    private void setPieceAt(Piece piece, Square square) {
        if (square == null) {
            throw new NullPointerException();
        }
        pieces[square.getRow()][square.getColumn()] = piece;
    }

    public void addPiece(Piece piece) {
        if (getPieceAt(piece.getLocation()) != null) {
            System.out.println("this location is occupied by another piece!");
            return;
        }
        setPieceAt(piece, piece.getLocation());
    }

    public void removePiece(Piece piece) {
        if (getPieceAt(piece.getLocation()) == null) {
            System.out.println("this location has no piece!");
            return;
        }
        setPieceAt(null, piece.getLocation());
    }

    public abstract void initializeBoardWithPieces(Player white, Player black);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return row == board.row && column == board.column && Arrays.deepEquals(pieces, board.pieces);
    }

    @Override
    public String toString() {
        return row + "*" + column + " Board";
    }
}

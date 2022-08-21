package board;

import general.Location;
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

    private Piece getPieceAt(Location location) {
        if (location == null) {
            throw new NullPointerException();
        }
        return pieces[location.getRow()][location.getColumn()];
    }

    private void setPieceAt(Piece piece, Location location) {
        if (location == null) {
            throw new NullPointerException();
        }
        pieces[location.getRow()][location.getColumn()] = piece;
    }

    public void addPiece(Piece piece, Location location) {
        if (getPieceAt(location) != null) {
            System.out.println("this location is occupied by another piece!");
            return;
        }
        setPieceAt(piece, location);
    }

    public void removePiece(Piece piece, Location location) {
        if (getPieceAt(location) == null) {
            System.out.println("this location has no piece!");
            return;
        }
        setPieceAt(null, location);
    }

    public abstract void initializeBoardWithPieces();

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

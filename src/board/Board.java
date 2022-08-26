package board;

import generalComponents.Color;
import generalComponents.Square;
import generalComponents.Player;
import pieces.Piece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

abstract public class Board {
    private final int row;
    private final int column;
    Piece[][] pieces;

    private void setPieceAt(Piece piece, Square square) {
        if (square == null) {
            throw new NullPointerException();
        }
        pieces[square.getRow()][square.getColumn()] = piece;
    }

    public void addPiece(Piece piece) {
        if (piece == null) {
            System.out.println("Illegal argument : Piece is null");
            return;
        }
        if (getPieceAt(piece.getLocation()) != null) {
            System.out.println("this location is occupied by another piece!");
            return;
        }
        setPieceAt(piece, piece.getLocation());
    }

    public void removePiece(Piece piece) {
        if (piece != null && getPieceAt(piece.getLocation()) != null) {
            setPieceAt(null, piece.getLocation());
        }
    }

    public Board(int row, int column) {
        if (row <= 0 || column <= 0) {
            throw new IllegalArgumentException("row and column must be greater than zero");
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

    public ArrayList<Piece> getPiecesWithColor(Color color) {
        if (color == null) {
            throw new IllegalArgumentException("NullPointer argument");
        }

        ArrayList<Piece> result = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pieces[i][j] != null && color == pieces[i][j].getOwner().getColor()) {
                    result.add(pieces[i][j]);
                }
            }
        }
        return result;
    }

    public Piece getKing(Color color) {
        if (color == null) {
            throw new IllegalArgumentException("NullPointer argument");
        }

        Piece king = null;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pieces[i][j] != null && Objects.equals(pieces[i][j].getName(), "King")) {
                    if (color == pieces[i][j].getOwner().getColor()) {
                        king = pieces[i][j];
                    }
                }
            }
        }
        return king;
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

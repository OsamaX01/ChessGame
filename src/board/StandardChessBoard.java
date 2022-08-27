package board;

import generalComponents.Color;
import generalComponents.Square;
import generalComponents.Player;
import pieces.*;

public class StandardChessBoard extends Board {

    private void initializeOneBoardSideWithPieces(Player player, int mainRow, int pawnsRow) {
        addPiece(PieceFactory.createPiece("Rock", player, new Square(mainRow, 0)));
        addPiece(PieceFactory.createPiece("Rock", player, new Square(mainRow, 7)));

        addPiece(PieceFactory.createPiece("Knight", player, new Square(mainRow, 1)));
        addPiece(PieceFactory.createPiece("Knight", player, new Square(mainRow, 6)));

        addPiece(PieceFactory.createPiece("Bishop", player, new Square(mainRow, 2)));
        addPiece(PieceFactory.createPiece("Bishop", player, new Square(mainRow, 5)));

        addPiece(PieceFactory.createPiece("Queen", player, new Square(mainRow, 3)));
        addPiece(PieceFactory.createPiece("King", player, new Square(mainRow, 4)));

        for (int i = 0; i < getColumn(); i++) {
            addPiece(PieceFactory.createPiece("Pawn", player, new Square(pawnsRow, i)));
        }
    }

    @Override
    public void initializeBoardWithPieces(Player white, Player black) {
        if (white == null || black == null) {
            throw new IllegalArgumentException("Null argument");
        }
        initializeOneBoardSideWithPieces(white, 0, 1);
        initializeOneBoardSideWithPieces(black, 7, 6);
    }

    public StandardChessBoard() {
        super(8, 8);
    }

    public void printBoard() {
        System.out.print("   ");
        for (int i = 0; i < 8; i++) {
            System.out.print((char)('a' + i) + "  ");
        }
        System.out.println();

        for (int i = 7; i >= 0; i--) {
            System.out.print((char)('1' + i) + "  ");
            for (int j = 0; j < 8; j++) {
                Piece currentPiece = getPieceAt(new Square(i, j));
                if (currentPiece == null) {
                    System.out.print(".. ");
                } else {
                    if (currentPiece.getOwner().getColor() == Color.WHITE) {
                        System.out.print("W");
                    } else{
                        System.out.print("B");
                    }
                    System.out.print(currentPiece.getSymbol() + " ");
                }
            }
            System.out.println();
        }
    }
}

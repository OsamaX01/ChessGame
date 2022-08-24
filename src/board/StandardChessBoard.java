package board;

import general.Color;
import general.Location;
import general.Player;
import pieces.*;

public class StandardChessBoard extends Board {

    private void initializeOneBoardSideWithPieces(Player player, int mainRow, int pawnsRow) {
        addPiece(new Rock(player, new Location(mainRow, 0)));
        addPiece(new Rock(player, new Location(mainRow, 7)));

        addPiece(new Knight(player, new Location(mainRow, 1)));
        addPiece(new Knight(player, new Location(mainRow, 6)));

        addPiece(new Bishop(player, new Location(mainRow, 2)));
        addPiece(new Bishop(player, new Location(mainRow, 5)));

        addPiece(new Queen(player, new Location(mainRow, 3)));
        addPiece(new King(player, new Location(mainRow, 4)));

        for (int i = 0; i < getColumn(); i++) {
            addPiece(new Pawn(player, new Location(pawnsRow, i)));
        }
    }
    public StandardChessBoard() {
        super(8, 8);
    }

    @Override
    public void initializeBoardWithPieces(Player white, Player black) {
        initializeOneBoardSideWithPieces(white, 0, 1);
        initializeOneBoardSideWithPieces(black, 7, 6);
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
                Piece currentPiece = getPieceAt(new Location(i, j));
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

package board;

import general.Location;
import general.Player;
import pieces.King;
import pieces.Queen;
import pieces.Knight;
import pieces.Bishop;
import pieces.Rock;
import pieces.Pawn;

public class StandardChessBoard extends Board {
    public StandardChessBoard() {
        super(8, 8);
    }

    @Override
    public void initializeBoardWithPieces(Player white, Player black) {
        initializeOneBoardSideWithPieces(white, 0, 1);
        initializeOneBoardSideWithPieces(black, 7, 6);
    }

    private void initializeOneBoardSideWithPieces(Player player, int mainRow, int pawnsRow) {
        addPiece(new Rock(player, new Location(mainRow, 0)));
        addPiece(new Rock(player, new Location(mainRow, 7)));

        addPiece(new Knight(player, new Location(mainRow, 1)));
        addPiece(new Knight(player, new Location(mainRow, 6)));

        addPiece(new Bishop(player, new Location(mainRow, 2)));
        addPiece(new Bishop(player, new Location(mainRow, 5)));

        addPiece(new Queen(player, new Location(mainRow, 3)));
        addPiece(new King(player, new Location(mainRow, 4)));

        for (int i = mainRow; i < getColumn(); i++) {
            addPiece(new Pawn(player, new Location(pawnsRow, i)));
        }
    }
}

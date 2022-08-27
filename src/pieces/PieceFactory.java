package pieces;

import generalComponents.Player;
import generalComponents.Square;

public class PieceFactory {
    public static Piece createPiece(String name, Player owner, Square location) {
        if (name == null || owner == null || location == null) {
            throw new IllegalArgumentException("NullPointer argument");
        }

        switch (name) {
            case "Queen":
                return new Queen(owner, location);
            case "Rock":
                return new Rock(owner, location);
            case "Bishop":
                return new Bishop(owner, location);
            case "Knight":
                return new Knight(owner, location);
            case "King":
                return new King(owner, location);
            case "Pawn":
                return new Pawn(owner, location);
            default:
                throw new IllegalArgumentException("Can't create piece: name is invalid - Please try again");
        }
    }

    public static boolean isValidPieceNameToCreate(String name) {
        switch (name) {
            case "Queen":
            case "Pawn":
            case "Rock":
            case "Bishop":
            case "Knight":
            case "King":
                return true;
            default:
                return false;
        }
    }
}

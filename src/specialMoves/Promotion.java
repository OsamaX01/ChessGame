package specialMoves;

import generalComponents.Player;
import generalComponents.Square;
import pieces.*;

import java.util.Objects;
import java.util.Scanner;

public class Promotion {
    public static void promote(Piece piece) {
        if (piece == null) {
            throw new IllegalArgumentException("NullPointer argument");
        }

        Scanner scanner = new Scanner(System.in);
        Player player = piece.getOwner();
        Square location = piece.getLocation();
        boolean isPromoted = false;

        while (!isPromoted) {
            System.out.println("Please Enter the name of piece you want to promote your " + piece + "\nNote: Name starts with capital letter");
            String newPieceName = scanner.nextLine();
            if (PieceFactory.isValidPieceNameToCreate(newPieceName) && !newPieceName.equals("King") && !newPieceName.equals("Pawn")) {
                piece = PieceFactory.createPiece(newPieceName, player, location);
                isPromoted = true;
            }
        }
    }
}

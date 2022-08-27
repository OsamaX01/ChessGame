package specialMoves;

import board.Board;
import generalComponents.Player;
import generalComponents.Square;
import pieces.*;

import java.util.Scanner;

public class Promotion {
    public static void promote(Board board, Square square) {
        if (square == null) {
            throw new IllegalArgumentException("NullPointer argument");
        }

        Scanner scanner = new Scanner(System.in);
        Piece piece = board.getPieceAt(square);
        Player player =  piece.getOwner();
        Square location = piece.getLocation();
        boolean isPromoted = false;

        while (!isPromoted) {
            System.out.println("Please Enter the name of piece you want to promote your " + piece + "\nNote: Name starts with capital letter");
            String newPieceName = scanner.nextLine();
            if (PieceFactory.isValidPieceNameToCreate(newPieceName) && !newPieceName.equals("King") && !newPieceName.equals("Pawn")) {
                Piece newPiece = PieceFactory.createPiece(newPieceName, player, location);
                board.removePiece(piece);
                board.addPiece(newPiece);
                isPromoted = true;
            }
        }
    }
}

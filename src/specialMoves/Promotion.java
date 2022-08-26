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

            if (Objects.equals(newPieceName, "Queen")) {
                piece = new Queen(piece.getOwner(), piece.getLocation());
                isPromoted = true;
            }
            else if (Objects.equals(newPieceName, "Rock")) {
                piece = new Rock(piece.getOwner(), piece.getLocation());
                isPromoted = true;
            }
            else if (Objects.equals(newPieceName, "Bishop")) {
                piece = new Bishop(piece.getOwner(), piece.getLocation());
                isPromoted = true;
            }
            else if (Objects.equals(newPieceName, "Knight")) {
                piece = new Knight(piece.getOwner(), piece.getLocation());
                isPromoted = true;
            }
            else {
                System.out.println("Invalid piece: Please try again");
            }
        }
    }
}

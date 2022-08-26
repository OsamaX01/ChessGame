package simulators;

import board.StandardChessBoard;
import generalComponents.Player;
import generalComponents.Square;
import movements.MoveStrategy;
import pieces.Piece;

public class InputValidator {
    private final String input;
    private final StandardChessBoard board;

    public InputValidator(String input, StandardChessBoard board) {
        if (input == null || board == null) {
            throw new IllegalArgumentException("Null argument");
        }
        this.input = input;
        this.board = board;
    }

    public boolean isValidInput() {
        if (!input.matches("[A-H][1-8] [A-H][1-8]")) {
            System.out.println("Invalid input : Please enter your move at the following format:");
            System.out.println("[Rank followed by file] space [Rank followed by file], in Capital letters");
            System.out.println("e.g G8 F6");
            return false;
        }

        return true;
    }

    public boolean isValidSquare(Square from, Square to, Player player) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Null argument");
        }

        Piece currentPiece = board.getPieceAt(from);
        if (currentPiece == null) {
            System.out.println("Invalid input : Empty square:");
            return false;
        } else if (!currentPiece.getOwner().equals(player)) {
            System.out.println("Invalid input : This is an Opponent " + currentPiece);
            return false;
        }
        return true;
    }

    public boolean isValidMovement(Square from, Square to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Null argument");
        }

        Piece currentPiece = board.getPieceAt(from);
        boolean canMove = false;
        for (MoveStrategy movement : currentPiece.getMovements()) {
            if (movement.validateMove(board, from, to)) {
                canMove = true;
                break;
            }
        }

        if (!canMove) {
            System.out.println("Invalid Move : " + currentPiece + " Can't Move to " + to);
            return false;
        }
        return true;
    }
}
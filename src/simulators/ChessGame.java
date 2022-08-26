package simulators;

import board.StandardChessBoard;
import generalComponents.Color;
import generalComponents.Player;
import generalComponents.Square;
import pieces.Piece;

import javafx.util.Pair;
import java.util.Scanner;

public class ChessGame {
    private final StandardChessBoard board = new StandardChessBoard();
    private final GameStatesChecker gameStatesChecker = new GameStatesChecker();
    private boolean whiteTurn = true;
    private Player white;
    private Player black;

    private Pair<Square, Square> getValidMove(Player player) {
        Scanner scanner = new Scanner(System.in);
        if (player == null) {
            throw new IllegalArgumentException("Null argument");
        }

        while (true) {
            System.out.println("Enter next move (" + player + ") :");
            String enteredMove = scanner.nextLine();
            InputValidator inputValidator = new InputValidator(enteredMove, board);

            if (!inputValidator.isValidInput()) {
                continue;
            }

            Square from = Square.getSquare(enteredMove.charAt(1), enteredMove.charAt(0));
            Square to = Square.getSquare(enteredMove.charAt(4), enteredMove.charAt(3));

            if (!inputValidator.isValidSquare(from, to, player) || !inputValidator.isValidMovement(from, to)) {
                continue;
            }

            if (gameStatesChecker.isStillInCheck(board, from, to)) {
                System.out.println("Your king is still in danger, Please try again!");
                continue;
            }

            return new Pair<>(from, to);
        }
    }

    private void makeMove(Player currentPlayer) {
        Pair<Square, Square> move = getValidMove(currentPlayer);
        Square from = move.getKey();
        Square to = move.getValue();

        Piece atDestinationPiece = board.getPieceAt(to);
        if (atDestinationPiece != null) {
            System.out.println(currentPlayer + " killed " + atDestinationPiece);
            board.removePiece(atDestinationPiece);
        }

        Piece currentPiece = board.getPieceAt(from);
        board.removePiece(currentPiece);
        currentPiece.setLocation(to);
        board.addPiece(currentPiece);
        currentPiece.setIsFirsMove(false);

        whiteTurn = !whiteTurn;
    }

    private void simulateGame() {
        board.printBoard();
        while (true) {
            Player currentPlayer = whiteTurn ? white : black;
            Player opponentPlayer = whiteTurn ? black : white;
            makeMove(currentPlayer);

            if (gameStatesChecker.isCheck(board, opponentPlayer)) {
                if (gameStatesChecker.isCheckMate(board, opponentPlayer)) {
                    break;
                }
                System.out.println("King is in check !");
            }

            board.printBoard();
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the white player name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter the Black player name: ");
        String secondName = scanner.nextLine();
        white = new Player(firstName, Color.WHITE);
        black = new Player(secondName, Color.BLACK);
        board.initializeBoardWithPieces(white, black);
        simulateGame();
    }
}

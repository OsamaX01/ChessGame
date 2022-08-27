package simulators;

import board.StandardChessBoard;
import generalComponents.Color;
import generalComponents.Player;
import generalComponents.Square;

import javafx.util.Pair;
import pieces.Piece;
import java.util.Scanner;

public class ChessGame {
    private final StandardChessBoard board = new StandardChessBoard();
    private final GameStatesChecker gameStatesChecker = new GameStatesChecker();
    private boolean whiteTurn = true;
    private int numberOfMoves = 0;
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

    Piece makeMove(Player currentPlayer) {
        Pair<Square, Square> move = getValidMove(currentPlayer);
        Square from = move.getKey();
        Square to = move.getValue();

        if (board.getPieceAt(to) != null) {
            System.out.println(currentPlayer + " killed " + board.getPieceAt(to));
        }

        board.move(from, to);
        whiteTurn = !whiteTurn;
        numberOfMoves++;
        return board.getPieceAt(to);
    }

    private void simulateGame() {
        board.printBoard();
        while (true) {
            Player currentPlayer = whiteTurn ? white : black;
            Player opponentPlayer = whiteTurn ? black : white;
            Piece moved = makeMove(currentPlayer);

            if (gameStatesChecker.isCheck(board, opponentPlayer)) {
                if (gameStatesChecker.isCheckMate(board, opponentPlayer, moved)) {
                    System.out.println("Check Mate : Game is done\nWinner is " + currentPlayer);
                    break;
                }
                System.out.println("King is in check !");
            } else if (gameStatesChecker.isDraw(board, numberOfMoves)) {
                System.out.println("Draw !!");
                break;
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

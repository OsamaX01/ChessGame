package general;

import board.StandardChessBoard;
import movements.MoveStrategy;
import pieces.Piece;

import javafx.util.Pair;
import java.util.Scanner;

public class ChessGame {
    private final StandardChessBoard board = new StandardChessBoard();
    private boolean whiteTurn = true;
    private Player white;
    private Player black;

    private Square convertMoveToLocation(char rank, char file) {
        int a = rank - '1';
        int b = file - 'A';
        return new Square(a, b);
    }

    private Pair<Square, Square> getValidMove(Player player) {
        class InputValidator {
            private final String input;
            public InputValidator(String input) {
                this.input = input;
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

            public boolean isValidSquare(Square from, Square to) {
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

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter next move (" + player + ") :");
            String enteredMove = scanner.nextLine();
            InputValidator inputValidator = new InputValidator(enteredMove);

            if (!inputValidator.isValidInput()) {
                continue;
            }

            Square from = convertMoveToLocation(enteredMove.charAt(1), enteredMove.charAt(0));
            Square to = convertMoveToLocation(enteredMove.charAt(4), enteredMove.charAt(3));

            if (!inputValidator.isValidSquare(from, to) || !inputValidator.isValidMovement(from, to)) {
                continue;
            }

            return new Pair<>(from, to);
        }
    }

    private void makeMove() {
        Player currentPlayer = whiteTurn ? white : black;
        System.out.println(currentPlayer);
        Pair<Square, Square> move =  getValidMove(currentPlayer);
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

        whiteTurn = !whiteTurn;
    }

    private void simulateGame() {
        board.printBoard();
        while (true) {
            makeMove();
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

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

    private Location convertMoveToLocation(char rank, char file) {
        int a = rank - '1';
        int b = file - 'A';
        return new Location(a, b);
    }

    private Pair<Location, Location> getValidMove(Player player) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter next move (" + player + ") :");
            String enteredMove = scanner.nextLine();

            if (!enteredMove.matches("[A-H][1-8] [A-H][1-8]")) {
                System.out.println("Invalid input : Please enter your move at the following format:");
                System.out.println("[Rank followed by file] space [Rank followed by file], in Capital letters");
                System.out.println("e.g G8 F6");
                continue;
            }

            Location from = convertMoveToLocation(enteredMove.charAt(1), enteredMove.charAt(0));
            Location to = convertMoveToLocation(enteredMove.charAt(4), enteredMove.charAt(3));

            Piece currentPiece = board.getPieceAt(from);
            if (currentPiece == null) {
                System.out.println("Invalid input : Empty square:");
                continue;
            } else if (!currentPiece.getOwner().equals(player)) {
                System.out.println("Invalid input : This is an Opponent " + currentPiece);
                continue;
            }

            boolean canMove = false;
            for (MoveStrategy movement : currentPiece.getMovements()) {
                if (movement.validateMove(board, from, to)) {
                    canMove = true;
                    break;
                }
            }

            if (!canMove) {
                System.out.println("Invalid Move : " + currentPiece + " Can't Move to " + to);
                continue;
            }

            return new Pair<>(from, to);
        }
    }

    private void makeMove() {
        Player currentPlayer = whiteTurn ? white : black;
        System.out.println(currentPlayer);
        Pair<Location, Location> move =  getValidMove(currentPlayer);
        Location from = move.getKey();
        Location to = move.getValue();

        if (board.getPieceAt(to) != null) {
            board.removePiece(board.getPieceAt(to));
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

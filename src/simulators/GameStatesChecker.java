package simulators;

import board.StandardChessBoard;
import generalComponents.Color;
import generalComponents.Player;
import generalComponents.Square;
import movements.MoveStrategy;
import pieces.King;
import pieces.Piece;

import java.util.ArrayList;

public class GameStatesChecker {
    private boolean canKingMoveToAdjacentSquares(StandardChessBoard board, Player kingOwner) {
        if (board == null || kingOwner == null) {
            throw new IllegalArgumentException("NullPointer Argument");
        }

        int[] x = {1, -1, 0, 0, 1, -1, 1, -1};
        int[] y = {0, 0, 1, -1, 1, 1, -1, -1};

        King king = (King) board.getKing(kingOwner.getColor());
        ArrayList<Square> kingAdjacentSquares = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Square currentSquare = new Square(king.getLocation().getRow() + x[i], king.getLocation().getColumn() + y[i]);
            for (MoveStrategy moveStrategy : king.getMovements()) {
                if (moveStrategy.validateMove(board, king.getLocation(), currentSquare)) {
                    kingAdjacentSquares.add(currentSquare);
                    break;
                }
            }
        }


        for (Square square : kingAdjacentSquares) {
            boolean canReachThisSquare = false;
            Color opponentColor = (kingOwner.getColor() == Color.WHITE ? Color.BLACK : Color.WHITE);

            checkReachability:
            for (Piece piece : board.getPiecesWithColor(opponentColor)) {
                if (piece.getLocation().equals(square)) {
                    continue;
                }

                for (MoveStrategy moveStrategy : piece.getMovements()) {
                    if (moveStrategy.validateMove(board, piece.getLocation(), square)) {
                        canReachThisSquare = true;
                        break checkReachability;
                    }
                }
            }

            if (!canReachThisSquare) {
                return true;
            }
        }

        return false;
    }

    private boolean canCaptureOrBlockCheckingPiece(StandardChessBoard board, Player kingOwner, Piece checkingPiece) {
        King king = (King) board.getKing(kingOwner.getColor());
        for (Square square : SquaresToBeBlocked.getSquaresBetweenKingAndCheckingPiece(board, king.getLocation(), checkingPiece.getLocation())) {

            boolean canBlock = false;
            loopCanBlock:
            for (Piece piece : board.getPiecesWithColor(kingOwner.getColor())) {
                for (MoveStrategy moveStrategy : piece.getMovements()) {
                    if (moveStrategy.validateMove(board, piece.getLocation(), square)) {
                        canBlock = true;
                        break loopCanBlock;
                    }
                }
            }

            if (canBlock) {
                return true;
            }
        }

        return false;
    }

    public boolean isStillInCheck(StandardChessBoard board, Square from, Square to) {
        if (board == null || from == null || to == null) {
            throw new IllegalArgumentException("NullPointer argument");
        }

        Piece removePiece = (board.getPieceAt(to));
        if (removePiece != null) {
            board.removePiece(removePiece);
        }

        Piece currentPiece = board.getPieceAt(from);
        board.removePiece(currentPiece);
        currentPiece.setLocation(to);
        board.addPiece(currentPiece);

        boolean result = isCheck(board, currentPiece.getOwner());

        board.removePiece(currentPiece);
        currentPiece.setLocation(from);
        board.addPiece(currentPiece);

        if (removePiece != null) {
            board.addPiece(removePiece);
        }

        return result;
    }

    public boolean isCheck(StandardChessBoard board, Player kingOwner) {
        if (board == null || kingOwner == null) {
            throw new IllegalArgumentException("NullPointer Argument");
        }

        King king = (King) board.getKing(kingOwner.getColor());
        Color opponentColor = (kingOwner.getColor() == Color.WHITE ? Color.BLACK : Color.WHITE);
        for (Piece piece : board.getPiecesWithColor(opponentColor)) {
            for (MoveStrategy moveStrategy : piece.getMovements()) {
                if (moveStrategy.validateMove(board, piece.getLocation(), king.getLocation())) {
                    return true;
                }
            }
        }

        return  false;
    }

    public boolean isCheckMate(StandardChessBoard board, Player kingOwner, Piece checkingPiece) {
        if (board == null || kingOwner == null) {
            throw new IllegalArgumentException("NullPointer Argument");
        }

        if (canKingMoveToAdjacentSquares(board, kingOwner)) {
            return false;
        } else if (canCaptureOrBlockCheckingPiece(board, kingOwner, checkingPiece)) {
            return false;
        }

        return true;
    }

    public boolean isDraw(StandardChessBoard board, int moves) {
        return (moves >= 100 || (board.getPiecesWithColor(Color.WHITE).size() == 1 && board.getPiecesWithColor(Color.BLACK).size() == 1));
    }
}

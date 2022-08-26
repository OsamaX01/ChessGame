package handlers;

import board.Board;
import generalComponents.Color;
import generalComponents.Square;
import movements.MoveStrategy;
import pieces.Piece;

public class NotCheckHandler extends BaseHandler {

    @Override
    protected boolean isValid(Board board, Square from, Square to) {
        Color kingColor = board.getPieceAt(from).getOwner().getColor();
        Color opponentColor = (kingColor == Color.WHITE ? Color.BLACK : Color.WHITE);
        for (Piece piece : board.getPiecesWithColor(opponentColor)) {
            for (MoveStrategy moveStrategy : piece.getMovements()) {
                if (moveStrategy.validateMove(board, piece.getLocation(), to)) {
                    System.out.println("You will be checked");
                    return false;
                }
            }
        }

        System.out.println("Im here");
        return true;
    }
}
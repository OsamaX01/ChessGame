package handlers;

import board.Board;
import generalComponents.Color;
import generalComponents.Square;
import pieces.Piece;

import java.util.Objects;

public class PromotionHandler extends BaseHandler {

    @Override
    protected boolean isValid(Board board, Square from, Square to) {
        Piece fromPiece = board.getPieceAt(from);
        if (!Objects.equals(fromPiece.getName(), "Pawn")) {
            return false;
        }

        if (fromPiece.getOwner().getColor() == Color.WHITE) {
            return fromPiece.getLocation().getRow() == 6;
        } else {
            return fromPiece.getLocation().getRow() == 1;
        }
    }
}

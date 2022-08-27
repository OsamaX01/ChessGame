package movements;

import board.Board;
import board.StandardChessBoard;
import generalComponents.Square;
import handlers.*;
import simulators.SquaresBetween;
import specialMoves.Castling;

import java.util.Objects;


public class CastlingMoveStrategy implements MoveStrategy {
    @Override
    public boolean validateMove(Board board, Square from, Square to) {
        Square rockPlace = to.getColumn() < from.getColumn() ? new Square(0, 0) : new Square(0, 7);
        if (board.getPieceAt(rockPlace) == null || !Objects.equals(board.getPieceAt(rockPlace).getName(), "Rock")) {
            return  false;
        }

        BaseHandler handler1 = new ValidStartLocationHandler();
        BaseHandler handler2 = new ValidDestinationHandler();
        BaseHandler handler3 = new NotCastledHandler();
        BaseHandler handler4 = new AtTheFirstMoveHandler();
        BaseHandler handler5 = new NoPiecesBetweenHandler();
        BaseHandler handler6 = new NotCheckHandler();

        handler1.setNext(handler2);
        handler2.setNext(handler3);
        handler3.setNext(handler4);

        boolean isCastling = handler1.canHandle(board, from, to);
        isCastling = isCastling && handler4.canHandle(board, rockPlace, rockPlace);
        isCastling = isCastling && handler5.canHandle(board, from, rockPlace);

        isCastling = isCastling && handler6.canHandle(board, from, from);
        for (Square square : SquaresBetween.getSquaresBetween((StandardChessBoard) board, from, to)) {
            isCastling = isCastling && handler6.canHandle(board, from, square);
        }

        if (isCastling) {
            Castling.perform(board, from, rockPlace);
        }

        return isCastling;
    }
}

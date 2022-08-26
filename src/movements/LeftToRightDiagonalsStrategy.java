package movements;

import board.Board;
import generalComponents.Square;
import handlers.*;

public class LeftToRightDiagonalsStrategy implements MoveStrategy {
    @Override
    public boolean validateMove(Board board, Square from, Square to) {
        if (board == null || from == null || to == null) {
            throw new IllegalArgumentException("NullPointer argument");
        }

        BaseHandler handler1 = new ValidStartLocationHandler();
        BaseHandler handler2 = new ValidDestinationHandler();
        BaseHandler handler3 = new NotSameColorAtDestinationHandler();
        BaseHandler handler4 = new LeftToRightDiagonalsHandler();
        BaseHandler handler5 = new NoPiecesBetweenHandler();

        handler1.setNext(handler2);
        handler2.setNext(handler3);
        handler3.setNext(handler4);
        handler4.setNext(handler5);

        return handler1.canHandle(board, from, to);
    }
}
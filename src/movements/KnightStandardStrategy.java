package movements;

import board.Board;
import general.Square;
import handlers.*;

public class KnightStandardStrategy implements MoveStrategy {
    @Override
    public boolean validateMove(Board board, Square from, Square to) {
        if (board == null || from == null || to == null) {
            throw new IllegalArgumentException("NullPointer argument");
        }

        BaseHandler handler1 = new ValidStartLocationHandler();
        BaseHandler handler2 = new ValidDestinationHandler();
        BaseHandler handler3 = new NotSameColorAtDestinationHandler();
        BaseHandler handler4 = new KnightStandardHandler();

        handler1.setNext(handler2);
        handler2.setNext(handler3);
        handler3.setNext(handler4);

        return handler1.canHandle(board, from, to);
    }
}
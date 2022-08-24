package movements;

import board.Board;
import general.Square;
import handlers.*;

public class KingStandardMoveStrategy implements MoveStrategy {
    @Override
    public boolean validateMove(Board board, Square from, Square to) {
        BaseHandler handler1 = new NullPointerHandler();
        BaseHandler handler2 = new ValidDestinationHandler();
        BaseHandler handler3 = new NotSameColorAtDestinationHandler();
        BaseHandler handler4 = new KingStandardMoveHandler();

        handler1.setNext(handler2);
        handler2.setNext(handler3);
        handler3.setNext(handler4);

        return handler1.canHandle(board, from, to);
    }
}

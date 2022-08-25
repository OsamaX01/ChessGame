package movements;

import board.Board;
import general.Square;
import handlers.*;

public class LeftSquareDiagonallyIfEnemyExists extends BaseHandler {
    @Override
    protected boolean isValid(Board board, Square from, Square to) {
        if (board == null || from == null || to == null) {
            throw new IllegalArgumentException("NullPointer argument");
        }

        BaseHandler handler1 = new ValidStartLocationHandler();
        BaseHandler handler2 = new ValidDestinationHandler();
        BaseHandler handler3 = new LeftSquareDiagonallyHandler();
        BaseHandler handler4 = new EnemyOnDestinationHandler();
        handler1.setNext(handler2);
        handler2.setNext(handler3);
        handler3.setNext(handler4);

        return handler1.canHandle(board, from, to);
    }
}

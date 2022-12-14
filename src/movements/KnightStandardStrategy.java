package movements;

import board.Board;
import generalComponents.Square;
import handlers.*;

public class KnightStandardStrategy implements MoveStrategy {
    private static MoveStrategy instance;

    private KnightStandardStrategy() { }

    public static MoveStrategy getInstance() {
        if (instance == null) {
            instance = new KnightStandardStrategy();
        }
        return instance;
    }

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
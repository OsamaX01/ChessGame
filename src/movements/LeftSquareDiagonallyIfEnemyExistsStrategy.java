package movements;

import board.Board;
import generalComponents.Square;
import handlers.*;

public class LeftSquareDiagonallyIfEnemyExistsStrategy implements MoveStrategy {
    private static MoveStrategy instance;

    private LeftSquareDiagonallyIfEnemyExistsStrategy() { }

    public static MoveStrategy getInstance() {
        if (instance == null) {
            instance = new LeftSquareDiagonallyIfEnemyExistsStrategy();
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
        BaseHandler handler3 = new LeftSquareDiagonallyHandler();
        BaseHandler handler4 = new EnemyOnDestinationHandler();
        handler1.setNext(handler2);
        handler2.setNext(handler3);
        handler3.setNext(handler4);

        return handler1.canHandle(board, from, to);
    }
}

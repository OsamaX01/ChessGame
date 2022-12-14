package movements;

import board.Board;
import generalComponents.Square;
import handlers.*;

public class TwoForwardAtStartStrategy implements MoveStrategy {
    private static MoveStrategy instance;

    private TwoForwardAtStartStrategy() { }

    public static MoveStrategy getInstance() {
        if (instance == null) {
            instance = new TwoForwardAtStartStrategy();
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
        BaseHandler handler3 = new AtTheFirstMoveHandler();
        BaseHandler handler4 = new TwoMovesForwardHandler();
        BaseHandler handler5 = new NoPiecesBetweenHandler();
        BaseHandler handler6 = new EmptyDestinationHandler();

        handler1.setNext(handler2);
        handler2.setNext(handler3);
        handler3.setNext(handler4);
        handler4.setNext(handler5);
        handler5.setNext(handler6);

        return handler1.canHandle(board, from, to);
    }
}

package movements;

import board.Board;
import general.Square;
import handlers.*;

public class TwoForwardAtStartStrategy implements MoveStrategy {
    @Override
    public boolean validateMove(Board board, Square from, Square to) {
        BaseHandler handler1 = new NullPointerHandler();
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

package movements;

import board.Board;
import general.Location;
import handlers.*;

public class VerticalMoveStrategy implements MoveStrategy {
    @Override
    public boolean validateMove(Board board, Location from, Location to) {
        BaseHandler handler1 = new NullPointerHandler();
        BaseHandler handler2 = new ValidDestinationHandler();
        BaseHandler handler3 = new NotSameColorAtDestinationHandler();
        BaseHandler handler4 = new VerticalMoveHandler();
        BaseHandler handler5 = new NoPiecesBetweenHandler();

        handler1.setNext(handler2);
        handler2.setNext(handler3);
        handler3.setNext(handler4);
        handler4.setNext(handler5);

        return handler1.canHandle(board, from, to);
    }
}

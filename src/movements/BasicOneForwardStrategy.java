package movements;

import board.Board;
import general.Location;

import handlers.*;

public class BasicOneForwardStrategy implements MoveStrategy {
    @Override
    public boolean validateMove(Board board, Location from, Location to) {
        BaseHandler handler1 = new NullPointerHandler();
        BaseHandler handler2 = new ValidDestinationHandler();
        BaseHandler handler3 = new OneMoveForwardHandler();
        BaseHandler handler4 = new EmptyDestinationHandler();
        handler1.setNext(handler2);
        handler2.setNext(handler3);
        handler3.setNext(handler4);

        return handler1.canHandle(board, from, to);
    }
}

package movements;

import board.Board;
import general.Location;

import handlers.BaseHandler;
import handlers.NullPointerHandler;
import handlers.ValidDestinationHandler;
import handlers.OneMoveForwardHandler;

public class BasicOneForwardStrategy implements MoveStrategy {
    @Override
    public boolean validateMove(Board board, Location from, Location to) {
        BaseHandler handler1 = new NullPointerHandler();
        BaseHandler handler2 = new ValidDestinationHandler();
        BaseHandler handler3 = new OneMoveForwardHandler();
        handler1.setNext(handler2);
        handler2.setNext(handler3);

        return handler1.canHandle(board, from, to);
    }
}

package movements;

import board.Board;
import generalComponents.Square;

import handlers.*;
import specialMoves.Promotion;

public class BasicOneForwardStrategy implements MoveStrategy {
    @Override
    public boolean validateMove(Board board, Square from, Square to) {
        if (board == null || from == null || to == null) {
            throw new IllegalArgumentException("NullPointer argument");
        }

        BaseHandler handler1 = new ValidStartLocationHandler();
        BaseHandler handler2 = new ValidDestinationHandler();
        BaseHandler handler3 = new OneMoveForwardHandler();
        BaseHandler handler4 = new EmptyDestinationHandler();
        handler1.setNext(handler2);
        handler2.setNext(handler3);
        handler3.setNext(handler4);

        boolean isHandled = handler1.canHandle(board, from, to);

        if (isHandled) {
            BaseHandler handler5 = new PromotionHandler();
            if (handler5.canHandle(board, from, to)) {
                Promotion.promote(board.getPieceAt(from));
            }
        }

        return isHandled;
    }
}

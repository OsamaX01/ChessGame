package movements;

import board.Board;
import generalComponents.Square;
import handlers.BaseHandler;
import handlers.PromotionHandler;
import specialMoves.Promotion;

public class OneForwardWithPromotionStrategy extends BasicOneForwardStrategy {

    @Override
    public boolean validateMove(Board board, Square from, Square to) {
        boolean isHandled = super.validateMove(board, from, to);

        if (isHandled) {
            BaseHandler handler5 = new PromotionHandler();
            if (handler5.canHandle(board, from, to)) {
                Promotion.promote(board.getPieceAt(from));
            }
        }

        return isHandled;
    }
}

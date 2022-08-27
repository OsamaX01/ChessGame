package movements;

import board.Board;
import generalComponents.Square;
import handlers.BaseHandler;
import handlers.PromotionHandler;
import specialMoves.Promotion;

public class OneForwardWithPromotionStrategy implements MoveStrategy {
    private static MoveStrategy instance;

    private OneForwardWithPromotionStrategy() { }

    public static MoveStrategy getInstance() {
        if (instance == null) {
            instance = new OneForwardWithPromotionStrategy();
        }
        return instance;
    }


    @Override
    public boolean validateMove(Board board, Square from, Square to) {
        if (board == null || from == null || to == null) {
            throw new IllegalArgumentException("NullPointer argument");
        }

        boolean isHandled = BasicOneForwardStrategy.getInstance().validateMove(board, from, to);

        if (isHandled) {
            BaseHandler handler5 = new PromotionHandler();
            if (handler5.canHandle(board, from, to)) {
                Promotion.promote(board, from);
            }
        }

        return isHandled;
    }
}

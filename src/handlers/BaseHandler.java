package handlers;

import board.Board;
import generalComponents.Square;

public abstract class BaseHandler implements Handler {
    protected Handler nextHandler = null;

    @Override
    public void setNext(Handler handler) {
        if (handler == null) {
            throw new NullPointerException();
        }
        nextHandler = handler;
    }

    @Override
    public boolean canHandle(Board board, Square from, Square to) {
        if (board == null || from == null || to == null) {
            throw new IllegalArgumentException("NullPointer argument");
        }

        if (isValid(board, from, to)) {
            return (nextHandler == null || nextHandler.canHandle(board, from, to));
        }
        else {
           return false;
        }
    }

    protected abstract boolean isValid(Board board, Square from, Square to);
}

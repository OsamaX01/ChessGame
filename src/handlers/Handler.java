package handlers;

import board.Board;
import generalComponents.Square;

public interface Handler {
    void setNext(Handler handler);
    boolean canHandle(Board board, Square from, Square to);
}

package handlers;

import board.Board;
import general.Square;

public interface Handler {
    void setNext(Handler handler);
    boolean canHandle(Board board, Square from, Square to);
}

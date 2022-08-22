package handlers;

import board.Board;
import general.Location;

public interface Handler {
    void setNext(Handler handler);
    boolean canHandle(Board board, Location from, Location to);
}

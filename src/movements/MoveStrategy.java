package movements;

import board.Board;
import general.Location;

public interface MoveStrategy {
    boolean validateMove(Board board, Location from, Location to);
}
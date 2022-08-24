package movements;

import board.Board;
import general.Square;

public interface MoveStrategy {
    boolean validateMove(Board board, Square from, Square to);
}
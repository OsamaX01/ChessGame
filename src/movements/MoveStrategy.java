package movements;

import board.Board;
import generalComponents.Square;

public interface MoveStrategy {
    boolean validateMove(Board board, Square from, Square to);
}
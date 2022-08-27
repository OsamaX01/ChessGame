package pieces;

import generalComponents.Square;
import generalComponents.Player;
import movements.HorizontalMoveStrategy;
import movements.LeftToRightDiagonalsStrategy;
import movements.RightToLeftDiagonalsStrategy;
import movements.VerticalMoveStrategy;

public class Queen extends Piece {
    public Queen(Player owner, Square square) {
        super(owner, square);
    }

    @Override
    public String getName() {
        return "Queen";
    }

    @Override
    public String getSymbol() {
        return "Q";
    }

    @Override
    protected void setMovements() {
        addMovementStrategy(VerticalMoveStrategy.getInstance());
        addMovementStrategy(HorizontalMoveStrategy.getInstance());
        addMovementStrategy(LeftToRightDiagonalsStrategy.getInstance());
        addMovementStrategy(RightToLeftDiagonalsStrategy.getInstance());
    }
}

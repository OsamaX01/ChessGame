package pieces;

import generalComponents.Square;
import generalComponents.Player;
import movements.HorizontalMoveStrategy;
import movements.VerticalMoveStrategy;

public class Rock extends Piece {
    public Rock(Player owner, Square square) {
        super(owner, square);
    }

    @Override
    public String getName() {
        return "Rock";
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    protected void setMovements() {
         addMovementStrategy(VerticalMoveStrategy.getInstance());
         addMovementStrategy(HorizontalMoveStrategy.getInstance());
    }
}

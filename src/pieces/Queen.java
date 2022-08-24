package pieces;

import general.Location;
import general.Player;
import movements.HorizontalMoveStrategy;
import movements.LeftToRightDiagonalsStrategy;
import movements.RightToLeftDiagonalsStrategy;
import movements.VerticalMoveStrategy;

public class Queen extends Piece {
    public Queen(Player owner, Location location) {
        super(owner, location);
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
        addMovementStrategy(new VerticalMoveStrategy());
        addMovementStrategy(new HorizontalMoveStrategy());
        addMovementStrategy(new LeftToRightDiagonalsStrategy());
        addMovementStrategy(new RightToLeftDiagonalsStrategy());
    }
}

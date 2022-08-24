package pieces;

import general.Location;
import general.Player;
import movements.HorizontalMoveStrategy;
import movements.VerticalMoveStrategy;

public class Rock extends Piece {
    public Rock(Player owner, Location location) {
        super(owner, location);
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
         addMovementStrategy(new VerticalMoveStrategy());
         addMovementStrategy(new HorizontalMoveStrategy());
    }
}

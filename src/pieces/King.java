package pieces;

import general.Location;
import general.Player;
import movements.KingStandardMoveStrategy;

public class King extends Piece {
    public King(Player owner, Location location) {
        super(owner, location);
    }

    @Override
    public String getName() {
        return "King";
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    @Override
    protected void setMovements() {
        addMovementStrategy(new KingStandardMoveStrategy());
    }
}

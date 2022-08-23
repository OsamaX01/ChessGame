package pieces;

import general.Location;
import general.Player;
import movements.KnightStandardStrategy;

public class Knight extends Piece {
    public Knight(Player owner, Location location) {
        super(owner, location);
    }

    @Override
    public String getName() {
        return "Knight";
    }

    @Override
    protected void setMovements() {
        addMovementStrategy(new KnightStandardStrategy());
    }
}

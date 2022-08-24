package pieces;

import general.Location;
import general.Player;
import movements.BasicOneForwardStrategy;
import movements.TwoForwardAtStartStrategy;

public class Pawn extends Piece {
    public Pawn(Player owner, Location location) {
        super(owner, location);
    }

    @Override
    public String getName() {
        return "Pawn";
    }

    @Override
    public String getSymbol() {
        return "P";
    }

    @Override
    protected void setMovements() {
        addMovementStrategy(new BasicOneForwardStrategy());
        addMovementStrategy(new TwoForwardAtStartStrategy());
    }
}

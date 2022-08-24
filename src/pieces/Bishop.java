package pieces;

import general.Location;
import general.Player;
import movements.LeftToRightDiagonalsStrategy;
import movements.RightToLeftDiagonalsStrategy;

public class Bishop extends Piece {
    public Bishop(Player owner, Location location) {
        super(owner, location);
    }

    @Override
    public String getName() {
        return "Bishop";
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    protected void setMovements() {
        addMovementStrategy(new LeftToRightDiagonalsStrategy());
        addMovementStrategy(new RightToLeftDiagonalsStrategy());
    }
}
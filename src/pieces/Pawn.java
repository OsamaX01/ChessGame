package pieces;

import general.Square;
import general.Player;
import movements.BasicOneForwardStrategy;
import movements.TwoForwardAtStartStrategy;

public class Pawn extends Piece {
    public Pawn(Player owner, Square square) {
        super(owner, square);
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

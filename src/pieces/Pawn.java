package pieces;

import general.Square;
import general.Player;
import handlers.LeftSquareDiagonallyHandler;
import movements.*;

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
        addMovementStrategy(new LeftSquareDiagonallyIfEnemyExistsStrategy());
        addMovementStrategy(new RightSquareDiagonallyIfEnemyExistsStrategy());
    }
}

package pieces;

import generalComponents.Square;
import generalComponents.Player;
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
        addMovementStrategy(new OneForwardWithPromotionStrategy());
        addMovementStrategy(new TwoForwardAtStartStrategy());
        addMovementStrategy(new LeftSquareDiagonallyIfEnemyExistsStrategy());
        addMovementStrategy(new RightSquareDiagonallyIfEnemyExistsStrategy());
    }
}

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
        addMovementStrategy(OneForwardWithPromotionStrategy.getInstance());
        addMovementStrategy(TwoForwardAtStartStrategy.getInstance());
        addMovementStrategy(LeftSquareDiagonallyIfEnemyExistsStrategy.getInstance());
        addMovementStrategy(RightSquareDiagonallyIfEnemyExistsStrategy.getInstance());
    }
}

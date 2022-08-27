package pieces;

import generalComponents.Square;
import generalComponents.Player;
import movements.CastlingMoveStrategy;
import movements.KingStandardMoveStrategy;

public class King extends Piece {
    public King(Player owner, Square square) {
        super(owner, square);
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
        addMovementStrategy(KingStandardMoveStrategy.getInstance());
        addMovementStrategy(CastlingMoveStrategy.getInstance());
    }
}

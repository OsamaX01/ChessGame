package pieces;

import general.Square;
import general.Player;
import movements.KnightStandardStrategy;

public class Knight extends Piece {
    public Knight(Player owner, Square square) {
        super(owner, square);
    }

    @Override
    public String getName() {
        return "Knight";
    }

    @Override
    public String getSymbol() {
        return "T";
    }

    @Override
    protected void setMovements() {
        addMovementStrategy(new KnightStandardStrategy());
    }
}

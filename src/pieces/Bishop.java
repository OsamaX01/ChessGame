package pieces;

import generalComponents.Square;
import generalComponents.Player;
import movements.LeftToRightDiagonalsStrategy;
import movements.RightToLeftDiagonalsStrategy;

public class Bishop extends Piece {
    public Bishop(Player owner, Square square) {
        super(owner, square);
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
        addMovementStrategy(LeftToRightDiagonalsStrategy.getInstance());
        addMovementStrategy(RightToLeftDiagonalsStrategy.getInstance());
    }
}
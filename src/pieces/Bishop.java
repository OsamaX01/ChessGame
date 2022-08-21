package pieces;

import general.Location;
import general.Player;

public class Bishop extends Piece {
    public Bishop(Player owner, Location location) {
        super(owner, location);
    }

    @Override
    public String getName() {
        return "Bishop";
    }
}
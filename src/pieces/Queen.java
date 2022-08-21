package pieces;

import general.Location;
import general.Player;

public class Queen extends Piece {
    public Queen(Player owner, Location location) {
        super(owner, location);
    }

    @Override
    public String getName() {
        return "Queen";
    }
}

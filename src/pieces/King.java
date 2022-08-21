package pieces;

import general.Location;
import general.Player;

public class King extends Piece {
    public King(Player owner, Location location) {
        super(owner, location);
    }

    @Override
    public String getName() {
        return "King";
    }
}

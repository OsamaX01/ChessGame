package pieces;

import general.Location;
import general.Player;

public class Rock extends Piece {
    public Rock(Player owner, Location location) {
        super(owner, location);
    }

    @Override
    public String getName() {
        return "Rock";
    }
}
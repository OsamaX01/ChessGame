package pieces;

import general.Location;
import general.Player;

public class Knight extends Piece {
    public Knight(Player owner, Location location) {
        super(owner, location);
    }

    @Override
    public String getName() {
        return "Knight";
    }
}
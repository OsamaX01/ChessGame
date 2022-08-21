package pieces;

import general.Location;
import general.Player;

public class Pawn extends Piece {
    public Pawn(Player owner, Location location) {
        super(owner, location);
    }

    @Override
    public String getName() {
        return "Pawn";
    }
}
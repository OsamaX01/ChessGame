package pieces;

import general.Location;
import general.Player;

abstract public class Piece {
    private Player owner;
    private Location location;
    private final boolean isFirsMove;

    public Piece(Player owner, Location location) {
        this.owner = owner;
        this.location = location;
        isFirsMove = true;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Player getOwner() {
        return owner;
    }

    public Location getLocation() {
        return location;
    }

    public boolean isFirsMove() {
        return isFirsMove;
    }
}

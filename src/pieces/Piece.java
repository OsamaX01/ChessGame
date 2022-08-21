package pieces;

import general.Location;
import general.Player;
import movements.MoveStrategy;

import java.util.ArrayList;

abstract public class Piece {
    private Player owner;
    private Location location;
    private final boolean isFirsMove;
    private ArrayList<MoveStrategy> movements;

    public Piece(Player owner, Location location) {
        if (owner == null || location == null) {
            throw new NullPointerException();
        }
        this.owner = owner;
        this.location = location;
        isFirsMove = true;
        movements = new ArrayList<>();
    }

    public void setOwner(Player owner) {
        if (owner == null) {
            throw new NullPointerException();
        }
        this.owner = owner;
    }

    public void setLocation(Location location) {
        if (location == null) {
            throw new NullPointerException();
        }
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

    public void addMovementStrategy(MoveStrategy movement) {
        if (movement == null) {
            throw new NullPointerException();
        }
        if (movements.contains(movement)) {
            System.out.println("this movement is already added! ");
            return;
        }
        movements.add(movement);
    }

    public void removeMovementStrategy(MoveStrategy movement) {
        if (movement == null) {
            throw new NullPointerException();
        }
        if (!movements.contains(movement)) {
            System.out.println("does not contain this movement to remove! ");
            return;
        }
        movements.remove(movement);
    }

    public ArrayList<MoveStrategy> getMovements() {
        return movements;
    }
}

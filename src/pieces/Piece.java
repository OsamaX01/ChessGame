package pieces;

import generalComponents.Square;
import generalComponents.Player;
import movements.MoveStrategy;

import java.util.ArrayList;
import java.util.Objects;

abstract public class Piece {
    private Player owner;
    private Square square;
    private boolean isFirsMove;
    private ArrayList<MoveStrategy> movements;

    public Piece(Player owner, Square square) {
        if (owner == null || square == null) {
            throw new NullPointerException();
        }
        this.owner = owner;
        this.square = square;
        isFirsMove = true;
        movements = new ArrayList<>();
        setMovements();
    }

    public void setOwner(Player owner) {
        if (owner == null) {
            throw new NullPointerException();
        }
        this.owner = owner;
    }

    public void setLocation(Square square) {
        if (square == null) {
            throw new NullPointerException();
        }
        this.square = square;
    }

    public void setIsFirsMove(boolean isFirsMove) {
        this.isFirsMove = isFirsMove;
    }

    public Player getOwner() {
        return owner;
    }

    public Square getLocation() {
        return square;
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

    abstract public String getName();

    abstract public String getSymbol();

    abstract protected void setMovements();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return Objects.equals(owner, piece.owner) && Objects.equals(getName(), piece.getName());
    }

    @Override
    public String toString() {
        return getName() + " at " + square;
    }
}

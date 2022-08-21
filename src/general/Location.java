package general;

import javafx.util.Pair;

public class Location extends Pair<Integer, Integer> {

    public Location(Integer row, Integer column) {
        super(row, column);
    }

    public int getRow() {
        return getKey();
    }

    public int getColumn() {
        return getValue();
    }

    @Override
    public String toString() {
        return "Location : " + getRow() + ", " + getColumn();
    }

    @Override
    public boolean equals(Object rhs) {
        return super.equals(rhs);
    }
}

package general;

import javafx.util.Pair;

public class Square extends Pair<Integer, Integer> {

    public Square(Integer row, Integer column) {
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
        return "Square : " + (char)(getColumn() + 'A') + ", " + (getRow() + 1) + " ";
    }

    @Override
    public boolean equals(Object rhs) {
        return super.equals(rhs);
    }
}

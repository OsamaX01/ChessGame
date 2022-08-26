package generalComponents;

import javafx.util.Pair;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

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

    static public Square getSquare(char rank, char file) {
        if (!isLetter(file) || !isDigit(rank)) {
            throw new IllegalArgumentException("rank must be a letter and file must be a digit");
        }

        int a = rank - '1';
        int b = file - 'A';
        return new Square(a, b);
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

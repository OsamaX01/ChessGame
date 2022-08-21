import java.util.Objects;

public class Player {
    private String name;
    private Color color;

    public Player(String name, Color color) {
        setName(name);
        setColor(color);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && color == player.color;
    }

    @Override
    public String toString() {
        return String.format("Player: %s (%s)", name, color);
    }
}

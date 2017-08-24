package Frogger;

public abstract class WidthCharacter extends Character {
    protected int width;

    public WidthCharacter(int x, int y, int turnInterval, String marker, int width) {
        super(x, y, turnInterval, marker);
        this.width = width;
    }
}

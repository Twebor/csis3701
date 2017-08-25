package Frogger;

/**
 * The base character outline for a character that must also take note of the width dimension in the Frogger game.
 * @author tthenshaw
 */

public abstract class WidthCharacter extends Character {

    /** Represents the width of the game */
    protected int width;

    /**
     * Creates a character with the given coordinates, turnIntervals, identifier marker, and the width confines.
     * @param x The character's x-coordinate.
     * @param y The character's y-coordinate.
     * @param turnInterval The character's turn frequency.
     * @param marker The character's game identifier/marker.
     * @param width The width dimension of the game area.
     */
    public WidthCharacter(int x, int y, int turnInterval, String marker, int width) {
        super(x, y, turnInterval, marker);
        this.width = width;
    }
}

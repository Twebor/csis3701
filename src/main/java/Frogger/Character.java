package Frogger;

/**
 * The base character outline in the frogger game.
 * @author tthenshaw
 */

public abstract class Character {

    /** Represents the x-coordinate. */
    protected int x;
    /** Represents the y-coordinate */
    protected int y;
    /** Represents the in-game identifier */
    protected String marker;
    /** Represents the amount of turns elapsed. */
    protected int turns;
    /** Represents how long between active turns. */
    protected int turnInterval;

    /**
     * Creates a character with the given coordinates, turnIntervals, and identifier marker.
     * @param x The character's initial x-coordinate.
     * @param y The character's initial y-coordinate.
     * @param turnInterval The character's turn frequency.
     * @param marker The character's game identifier/marker.
     */
    public Character(int x, int y, int turnInterval, String marker) {
        this.x = x;
        this.y = y;
        this.turnInterval = turnInterval;
        this.marker = marker;

        turns = 0;
    }

    /**
     * Gets the character's x-coordinate.
     * @return An int representing the character's x-coordinate.
     */
    public final int getX() {
        return x;
    }

    /**
     * Gets the character's y-coordinate.
     * @return An int representing the character's y-coordinate.
     */
    public final int getY() {
        return y;
    }

    /**
     * Gets the character's identifier
     * @return A string representing the marker.
     */
    public final String getMarker() {
        return marker;
    }

    /**
     * Gets the character's visibility status.
     * @return A boolean representing if the character is visible.
     */
    public boolean isVisible() {
        return true;
    }

    /**
     * Signals a new turn by incrementing turn counter and checks if active turn.
     * @return A boolean representing if the character should be active.
     */
    protected boolean isTurn() {
        // pre-increment to signify turn and compare to interval.
        return ++turns % turnInterval == 0;
    }

    /**
     * The character's active turn; the character's special move.
     * @param playerX The player's x-coordinate.
     * @param playerY The player's y-coordinate.
     */
    public abstract void act(int playerX, int playerY);
}

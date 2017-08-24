package Frogger;

/**
 * The Hider character in the frogger game.  Every 2 turns, the hider will change visibility.
 * @author tthenshaw
 */

public class Hider extends Character {

    /** Represents if the hider is visible */
    private boolean isVisible;

    /**
     * Creates a Hider with the given coordinates.
     * @param x The character's initial x-coordinate.
     * @param y The character's initial y-coordinate.
     */
    public Hider(int x, int y) {
        super(x, y, 2, "H");

        isVisible = true;
    }

    /**
     * The hider's active turn; will change visibility every 2 turns, and check if intersection.
     * @param playerX The player's x-coordinate.
     * @param playerY The player's y-coordinate.
     */
    public void act(int playerX, int playerY) {
        if (isTurn()) {
            // invert visibility.
            isVisible = !isVisible;
        }
    }

    /**
     * Checks if the hider is visible.
     * @return A boolean representing the hider's visibility.
     */
    @Override
    public boolean isVisible() {
        return isVisible;
    }
}

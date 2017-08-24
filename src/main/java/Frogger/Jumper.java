package Frogger;

/**
 * The Jumper character in the frogger game.  Every 4 turns, the jumper will jump to a random location in the same row.
 * @author tthenshaw
 */

public class Jumper extends WidthCharacter {

    /**
     * Creates a new jumper with the given set of coordinates as well as specifying the width as a range for its jumps.
     * @param x The character's initial x-coordinate.
     * @param y The character's initial y-coordinate.
     * @param width The width dimension of the game board.
     */
    public Jumper(int x, int y, int width) {
        super(x, y, 4, "J", width);
    }

    /**
     * The jumper's active turn; will randomly jump to a location within the same row every 4 turns.
     * @param playerX The player's x-coordinate.
     * @param playerY The player's y-coordinate.
     */
    public void act(int playerX, int playerY) {
        if (isTurn()) {
            x = (int) (Math.random() * width);
        }
    }
}

package Frogger;

/**
 * The Chaser character in the frogger game.  Every 3 turns will move closer to player's coordinates.
 * @author tthenshaw
 */

public class Chaser extends Character {

    /**
     * Creates a new chaser with given coordinates.
     * @param x The character's initial x-coordinate.
     * @param y The character's initial y-coordinate.
     */
    public Chaser(int x, int y) {
        super(x, y, 3, "C");
    }

    /**
     * The chaser's active turn; will move towards the player every 3 turns, and check if intersection.
     * @param playerX The player's x-coordinate.
     * @param playerY The player's y-coordinate.
     */
    public void act(int playerX, int playerY) {
        if (isTurn()) {
            // Compare both x and y coordinates to player and move accordingly.
            if (x > playerX) {
                x--;
            } else if (x < playerX) {
                x++;
            }

            if (y > playerY) {
                y--;
            } else if (y < playerY) {
                y++;
            }
        }
    }
}

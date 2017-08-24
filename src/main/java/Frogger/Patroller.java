package Frogger;

/**
 * The Patroller character in the frogger game.  Every 2 turns, the patroller will move one space in the given direction (left/right).
 * @author tthenshaw
 */

public class Patroller extends WidthCharacter {

    /** Represents the direction for the patroller to move */
    private String direction;

    /**
     * Creates a new patroller character with the given coordinates, the width as a range to stay within, and direction for travel.
     * @param x The character's initial x-coordinate.
     * @param y The character's initial y-coordinate.
     * @param width The width dimension of the game board.
     * @param direction The direction (left/right) for the patroller to travel.
     */
    public Patroller(int x, int y, int width, String direction) {
        super(x, y, 2, "P", width);

        this.direction = direction;
    }

    /**
     * The patroller's active turn; will randomly move one space in the supplied direction every 2 turns.  Wraps to other side on edges.
     * @param playerX The player's x-coordinate.
     * @param playerY The player's y-coordinate.
     */
    public void act(int playerX, int playerY) {
        if (isTurn()) {
            if (direction.toLowerCase().equals("left")) {
                if (x == 0) {
                    x = width - 1;
                } else {
                    x--;
                }
            } else if (direction.toLowerCase().equals("right")) {
                if (x == width - 1) {
                    x = 0;
                } else {
                    x++;
                }
            }
        }
    }
}

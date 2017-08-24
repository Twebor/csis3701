package podgame;

/**
 * Represents a Pod in the simple "pod chase" game.
 * @author tthenshaw
 */

public class Pod {
    /** Represents if the pod is caught by player. */
    private boolean caught = false;
    /** Represents the pod's x-coordinate. */
    private int x;
    /** Represents the pod's y-coordinate. */
    private int y;
    /** Represents the direction the pod is moving. */
    private String direction;
    /** Represents the game board's width. */
    private int width;
    /** Represents the game board's height. */
    private int height;

    /**
     * Creates a Pod with an initial location, direction, and describes game board dimensions.
     * @param x The pod's initial x-coordinate.
     * @param y The pod's initial y-coordinate.
     * @param direction The pod's initial direction.
     * @param width The game board's width.
     * @param height The game board's height.
     */
    public Pod(int x, int y, String direction, int width, int height) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.width = width;
        this.height = height;
    }

    /**
     * Gets the pod's x-coordinate.
     * @return An int representing the pod's x-coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the pod's y-coordinate.
     * @return An int representing the pod's y-coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Gets the pod's status on being caught.
     * @return A boolean representing if the pod is caught.
     */
    public boolean isCaught() {
        return caught;
    }

    /**
     * Makes the pod move one space.
     */
    public void move() {
        // Uses indexOf() to check for direction as it returns -1 if char not found.

        // Northbound
        if (direction.indexOf('N') != -1) {
            y++;

            // Check for bounces off top/bottom walls.
            if (y == height - 1) {
                // switch to southbound
                direction = "S" + direction.charAt(1);
            }
        } else {
            // Southbound
            y--;

            // Check if bounce off bottom.
            if (y == 0) {
                // switch to northbound.
                direction = "N" + direction.charAt(1);
            }
        }

        // Eastbound
        if (direction.indexOf('E') != -1) {
            x++;

            // Check if bounce off east.
            if (x == width - 1) {
                // switch to westbound.
                direction = direction.charAt(0) + "W";
            }
        } else {
            // Westbound
            x--;

            // Check if bounce off west.
            if (x == 0) {
                // switch to eastbound.
                direction = direction.charAt(0) + "E";
            }
        }
    }

    /**
     * Passes the current location of the player to the pod.
     * @param x An int representing the player's x-coordinate.
     * @param y An int representing the player's y-coordinate.
     */
    public void playerAt(int x, int y) {
        // Compares pod instance to supplied player coordinates.
        if (this.x == x && this.y == y) {
            caught = true;
        }
    }
}

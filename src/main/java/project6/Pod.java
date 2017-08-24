package project6;

/**
 * Represents a Pod in the simple "pod chase" game.
 * @author tthenshaw
 */

public class Pod {

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


    // compares two pods.
    @Override
    public boolean equals(Object obj) {
        // same object
        if (obj == this) {
            return true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Pod that = (Pod) obj;

        return this.x == that.x && this.y == that.y;
    }

    // inspired by Item 8 of Effective Java, (Always Override hashCode when you override equals) pg. 48
    // returns an object's hashcode calculated.
    @Override
    public int hashCode() {
        // using primes
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }
}

package nimgame;

// MUST ADD AN ADDITIONAL EXCEPTION TO BE THROWN BEFORE BEING TURNED IN
// MUST ADD AN ADDITIONAL EXCEPTION TO BE THROWN BEFORE BEING TURNED IN
// MUST ADD AN ADDITIONAL EXCEPTION TO BE THROWN BEFORE BEING TURNED IN
// MUST ADD AN ADDITIONAL EXCEPTION TO BE THROWN BEFORE BEING TURNED IN
// MUST ADD AN ADDITIONAL EXCEPTION TO BE THROWN BEFORE BEING TURNED IN
// MUST ADD AN ADDITIONAL EXCEPTION TO BE THROWN BEFORE BEING TURNED IN
// MUST ADD AN ADDITIONAL EXCEPTION TO BE THROWN BEFORE BEING TURNED IN
// MUST ADD AN ADDITIONAL EXCEPTION TO BE THROWN BEFORE BEING TURNED IN
// MUST ADD AN ADDITIONAL EXCEPTION TO BE THROWN BEFORE BEING TURNED IN
// MUST ADD AN ADDITIONAL EXCEPTION TO BE THROWN BEFORE BEING TURNED IN
// MUST ADD AN ADDITIONAL EXCEPTION TO BE THROWN BEFORE BEING TURNED IN
// MUST ADD AN ADDITIONAL EXCEPTION TO BE THROWN BEFORE BEING TURNED IN
// MUST ADD AN ADDITIONAL EXCEPTION TO BE THROWN BEFORE BEING TURNED IN

/**
 * Stores the state of the simple stick NimGame, and throws exceptions when problems occur.
 * @author tthenshaw
 */

import nimgame.exceptions.*;

public class NimGame {
    /** Represents the rows of sticks */
    private int[] sticks;

    /**
     * Creates a new game with the sticks per row specified by items supplied.
     * @param initialSticks The amount of sticks per row. int[] {3, 5, 7} = row of 3, 5, and 7.
     * @throws TooManyRowsException if array length != 3.  Only works with 3 rows.
     */
    public NimGame(int[] initialSticks) throws TooManyRowsException {
        if (initialSticks.length != 3) {
            throw new TooManyRowsException("Only 3 rows must be supplied.  Amount supplied: " + initialSticks.length);
        }
        sticks = initialSticks;
    }

    /**
     * Gets the current number of sticks in a given row.
     * @param r The row to get the number of sticks from.
     * @return An int representing the number of sticks in the requested row.
     */
    public int getRow(int r) {
        // -1 for 0-based indices
        return sticks[r];
    }

    /**
     * Removes s sticks from row r.
     * @param r The row to remove sticks from.
     * @param s The amount of sticks to remove.
     * @throws NoSuchRowException if the row is not between 1 and 3
     * @throws IllegalSticksException if the number of sticks taken is not between 1 and 3.
     * @throws NotEnoughSticksException if the number of sticks taken is valid, but not enough sticks in the row.
     */
    public void play(int r, int s) throws NoSuchRowException, IllegalSticksException, NotEnoughSticksException {
        if (!isValidRow(r)) {
            throw new NoSuchRowException("Supplied row must be between 1-3 : " + r);
        } else if (!isValidAmountOfSticks(s)) {
            throw new IllegalSticksException("Sticks taken must be between 1-3 : " + s);
        } else if (!isEnoughSticksInRow(r, s)) {
            throw new NotEnoughSticksException("There are not enough sticks in the given row to take!");
        }

        sticks[r] -= s;
    }

    /**
     * Checks if a valid row is supplied.
     * @param r The row to check.
     * @return A boolean representing if the row is valid.
     */
    private boolean isValidRow(int r) {
        return r >= 0 && r <= 2;
    }

    /**
     * Checks if a valid amount of sticks is supplied.
     * @param s The amount of sticks.
     * @return A boolean representing if the amount of sticks is valid.
     */
    private boolean isValidAmountOfSticks(int s) {
        return s >= 1 && s <= 3;
    }

    /**
     * Checks if a valid amount of sticks is supplied.
     * @param r The row to check.
     * @param s The amount of sticks.
     * @return A boolean representing if there's enough sticks to take from the row.
     */
    private boolean isEnoughSticksInRow(int r, int s) {
        return getRow(r) >= s;
    }

    /**
     * Checks that there's at least one stick in every row.  True if a row is empty, false otherwise.
     * @return A boolean representing if the game is over.
     */
    public boolean isOver() {
        for (int row : sticks) {
            if (row == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Takes a random number of sticks (1-3) from a random row.
     */
    public void AIMove() {
        int amountOfSticks;
        int row;

        // keep rerolling until move is valid.
        do {
            amountOfSticks = generateRandomOneToThree();
            row = generateRandomOneToThree() - 1;
        } while (!isEnoughSticksInRow(row, amountOfSticks));

        // exceptions should not be triggered as already validated.
        sticks[row] -= amountOfSticks;
    }

    /**
     * Generates a random number between 1 and 3.
     * @return An int in range [1, 3]
     */
    private int generateRandomOneToThree() {
        // truncates double result upon int cast.
        return (int) ((Math.random() * 3) + 1);
    }

    @Override
    public String toString() {
        // Uses StringBuilder to take advantage of its mutability.  Strings are normally immutable and
        // JVM may not know to optimize to SB if using normal String concatenation within a loop.
        StringBuilder sb = new StringBuilder();
        for (int row : sticks) {
            for (int i = 0; i < row; i++) {
                if (i == row - 1) {
                    sb.append("|");
                } else {
                    sb.append("| ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

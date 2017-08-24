package nimgame.exceptions;

/**
 * Exception representing if illegal amount of sticks given. Must be between 1-3.
 */

public class IllegalSticksException extends Exception {

    public IllegalSticksException(String s) {
        super(s);
    }
}

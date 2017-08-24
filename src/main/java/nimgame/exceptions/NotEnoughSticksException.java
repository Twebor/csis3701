package nimgame.exceptions;

/**
 * Exception given if there's not enough sticks in the given row to take.
 */

public class NotEnoughSticksException extends Exception {

    public NotEnoughSticksException(String s) {
        super(s);
    }
}

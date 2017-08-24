package nimgame.exceptions;

/**
 * Exception given if illegal row given.  Must be between 1-3.
 */

public class NoSuchRowException extends Exception {

    public NoSuchRowException(String s) {
        super(s);
    }
}

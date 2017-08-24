package nimgame.exceptions;

/**
 * Exception given if amount of rows is not 3.
 */

public class TooManyRowsException extends Exception {

    public TooManyRowsException(String s) {
        super(s);
    }
}

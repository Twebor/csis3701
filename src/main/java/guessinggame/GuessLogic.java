package guessinggame;

/**
 * Represents the logic in the simple guessing game.
 * @author tthenshaw
 */

public class GuessLogic {
    /** Represents the answer to the game. */
    private int answer;
    /** Represents the amount of guesses the player has made. */
    private int totalGuesses;
    /** Represents the limit; the highest possible guess. */
    private int max;
    /** Represents the state of if the player has won the game. */
    private boolean isCorrect;
    /** Represents the numbers that have been guessed already. */
    private boolean[] guessedNumbers;

    /**
     * Creates a new instance of the Guessing Game with the max limit supplied as argument.
     * @param max The max/limit to the game; the highest possible guess.
     */
    public GuessLogic(int max) {
        this.max = max;
        answer = generateAnswer();
        totalGuesses = 0;
        isCorrect = false;

        guessedNumbers = new boolean[max + 1];
    }

    /**
     * Randomly generates an answer for the game instance in range [1, max]
     * @return An int representing the answer.
     */
    private int generateAnswer() {
        // Math.random() generates a double in range [0.0, 1).  Result is truncated by casting to int.
        return (int) ((Math.random() * max) + 1);
    }

    /**
     * Validates the player's guess for the range criteria.
     * @param guess The player's guess.
     * @return A boolean representing if the guess is in the valid range. [1, max]
     */
    public boolean isGuessInRange(int guess) {
        return guess >= 1 && guess <= max;
    }

    /**
     * Validates the player's guess for repeating criteria.
     * @param guess The player's guess.
     * @return A boolean representing if the guess has been guessed previously.
     */
    public boolean isGuessRepeated(int guess) {
        return guessedNumbers[guess];
    }

    /**
     * Checks if the player's guess matches, increments totalGuesses, and adds guess to guessed numbers.
     * @param guess The player's guess.
     * @return A boolean representing if the guess is correct.
     */
    public boolean checkGuess(int guess) {
        totalGuesses++;
        guessedNumbers[guess] = true;

        if (guess == answer) {
            isCorrect = true;
        }

        return isCorrect();
    }

    /**
     * Checks if the player won the game.
     * @return A boolean representing if the game has been won.
     */
    public boolean isCorrect() {
        return isCorrect;
    }

    /**
     * Gets the total amount of guesses.
     * @return An int representing the total amount of guesses so far.
     */
    public int getTotalGuesses() {
        return totalGuesses;
    }
}

package guessinggame;

import java.util.Scanner;

/**
 * The UI for the guessing game.
 * @author tthenshaw
 */

public class GuessApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 10;

        GuessLogic game = new GuessLogic(max);

        while (!game.isCorrect()) {
            System.out.printf("Enter a guess between 1 and %d: ", max);

            // parses string guess into int to evaluate.  Could also wrap in try-catch to check some illegal inputs.
            int guess = Integer.parseInt(sc.nextLine());

            // Guess validation.
            if (!game.isGuessInRange(guess)) {
                System.out.printf("You must guess a number between 1 and %d!%n", max);
                continue;
            } else if (game.isGuessRepeated(guess)) {
                System.out.println("You have already guessed that!");
                continue;
            }

            // evaluates if incorrect answer.
            if (!game.checkGuess(guess)) {
                System.out.println("That is not correct.");
            }
        }

        System.out.printf("You guessed it in %d guesses%n", game.getTotalGuesses());
    }
}

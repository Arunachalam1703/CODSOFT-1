import java.util.*;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        boolean keepPlaying = true;
        int roundsPlayed = 0;
        int attemptsMade = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (keepPlaying) {
            int targetNumber = random.nextInt(100) + 1;
            int attemptsInCurrentRound = 0;
            final int MAX_ATTEMPTS = 10;
            boolean isGuessedCorrectly = false;

            System.out.println("\nI'm thinking of a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess the number.");

            while (attemptsInCurrentRound < MAX_ATTEMPTS && !isGuessedCorrectly) {
                System.out.print("Enter your guess (Attempt " + (attemptsInCurrentRound + 1) + "): ");
                int userGuess = input.nextInt();
                attemptsInCurrentRound++;
                attemptsMade++;

                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Please enter a number within the range 1 to 100.");
                } else if (userGuess == targetNumber) {
                    System.out.println("Congratulations! Your guess is correct!");
                    isGuessedCorrectly = true;
                } else if (userGuess > targetNumber) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }
            }

            if (!isGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + targetNumber + ".");
            }

            roundsPlayed++;
            System.out.print("Do you want to play again? (yes/no): ");
            keepPlaying = input.next().equalsIgnoreCase("yes");
        }

        System.out.println("\nGame Over! You played " + roundsPlayed + " rounds with a total of " + attemptsMade + " attempts.");
        input.close();
    }
}

import java.util.Scanner;
import java.util.Random;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final int MIN_RANGE = 1;
        final int MAX_RANGE = 100;
        final int MAX_ATTEMPTS = 7; 
        
        int totalScore = 0;
        int roundsPlayed = 0;
        boolean isPlaying = true;

        System.out.println("Number Guessing Game");
        System.out.println("Rules:");
        System.out.println("1. Guess the number between " + MIN_RANGE + " and " + MAX_RANGE + ".");
        System.out.println("2. You have " + MAX_ATTEMPTS + " attempts per round.");
        System.out.println("3. Points are awarded based on how quickly you guess.");
        
        while (isPlaying) {
            roundsPlayed++;
            int targetNumber = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
            int attemptsUsed = 0;
            boolean hasWon = false;
            
            System.out.println("\nRound " + roundsPlayed);
            System.out.println("I've picked a number.");
            
            while (attemptsUsed < MAX_ATTEMPTS) {
                System.out.print("Attempt " + (attemptsUsed + 1) + " of " + MAX_ATTEMPTS + ". Enter your guess: ");
                
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a valid integer.");
                    scanner.next(); 
                    System.out.print("Enter your guess: ");
                }
                
                int userGuess = scanner.nextInt();
                attemptsUsed++;

                if (userGuess == targetNumber) {
                    System.out.println("Correct! You guessed the number in " + attemptsUsed + " attempts.");
                    
                    int roundScore = (MAX_ATTEMPTS - attemptsUsed + 1) * 10;
                    totalScore += roundScore;
                    System.out.println("You earned " + roundScore + " points this round.");
                    hasWon = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }
            }

            if (!hasWon) {
                System.out.println("You've run out of attempts! The correct number was: " + targetNumber);
            }

            System.out.println("Current Total Score: " + totalScore);
            
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            
            if (!response.equals("yes") && !response.equals("y")) {
                isPlaying = false;
            }
        }

        System.out.println("Game Over");
        System.out.println("Total Rounds: " + roundsPlayed);
        System.out.println("Final Score:  " + totalScore);
        
        scanner.close();
    }
}
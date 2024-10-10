package Task_2;

import java.util.Scanner;

public class highRoller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userScore = 0;
        int programScore = 0;

        System.out.println("Welcome to the High Roller game!");
        System.out.println("You will play against the program. The best of three rounds wins.");

        // Loop for three rounds
        for (int round = 1; round <= 3; round++) {
            int userDiceRoll = getUserDiceRoll(scanner); // Get the user's dice roll
            int programDiceRoll = getRandomDiceRoll(); // Generate a random dice roll for the program
            System.out.println("\nRound " + round + ":");
            System.out.println("Your dice roll: " + userDiceRoll);
            System.out.println("Program's dice roll: " + programDiceRoll);

            // Compare the user's dice roll with the program's dice roll and determine the winner
            if (userDiceRoll > programDiceRoll) {
                System.out.println("Congratulations! You win this round!");
                userScore++;
            } else if (userDiceRoll < programDiceRoll) {
                System.out.println("You lose this round.");
                programScore++;
            } else {
                System.out.println("It's a draw!");
            }
        }

        // Display the final scores
        System.out.println("\nFinal Score:");
        System.out.println("Your score: " + userScore);
        System.out.println("Program's score: " + programScore);

        // Determine and display the overall winner
        if (userScore > programScore) {
            System.out.println("Congratulations! You win the game!");
        } else if (userScore < programScore) {
            System.out.println("You lose the game.");
        } else {
            System.out.println("It's a draw!");
        }

        scanner.close();
    }

    // Method to simulate the user rolling the dice
    private static int getUserDiceRoll(Scanner scanner) {
        System.out.println("\nPress Enter to roll your dice...");
        scanner.nextLine(); // Wait for the user to press Enter
        return (int) (Math.random() * 6) + 1; // Generate a random number between 1 and 6
    }

    // Method to generate a random dice roll for the program
    private static int getRandomDiceRoll() {
        return (int) (Math.random() * 6) + 1; // Generate a random number between 1 and 6
    }
}

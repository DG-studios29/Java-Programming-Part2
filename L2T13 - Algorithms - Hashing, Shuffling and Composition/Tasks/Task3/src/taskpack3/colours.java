package taskpack3;



import java.util.Scanner;
import java.util.Random;

public class colours {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of people
        System.out.print("Enter the number of people: ");
        int numPeople = scanner.nextInt();

        // Check if the number of people is valid
        if (numPeople <= 0) {
            System.out.println("Please enter a valid number of people.");
            return;
        }

        // Create arrays to store names and colors
        String[] names = new String[numPeople];
        String[] colors = new String[numPeople];

        // Input names and colors
        for (int i = 0; i < numPeople; i++) {
            System.out.print("Enter the name for person " + (i + 1) + ": ");
            names[i] = scanner.next();
            System.out.print("Enter a color for " + names[i] + ": ");
            colors[i] = scanner.next();
        }

        // Shuffle the colors randomly
        shuffleArray(colors);

        // Print out the pairs
        System.out.println("\nName - Color Pairs:");
        for (int i = 0; i < numPeople; i++) {
            System.out.println(names[i] + " - " + colors[i]);
        }

        scanner.close();
    }

    // Fisher-Yates shuffle algorithm to shuffle an array randomly
    private static void shuffleArray(String[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            String temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}


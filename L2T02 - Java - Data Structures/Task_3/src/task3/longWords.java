package task3;

import java.util.Scanner;

public class longWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter any number of words and store them in an array
        System.out.println("Enter words (enter 0 to finish input):");
        String[] words = new String[100]; // Assuming the user will enter at most 100 words
        int count = 0;

        // Read input until the user enters 0 or reaches the array size limit
        while (count < words.length) {
            String word = scanner.next();
            if (word.equals("0")) {
                break; // Exit the loop if the user enters 0
            }
            words[count] = word;
            count++;
        }

        // Determine the number of words longer than 4 letters
        int longWordCount = countLongWords(words, count);

        // Calculate the average length of all words given
        double averageLength = calculateAverageLength(words, count);

        // Print out the number of words longer than 4 letters and the average length
        System.out.println("Number of words longer than 4 letters: " + longWordCount);
        System.out.println("Average word length: " + averageLength);

        scanner.close();
    }

    // Method to determine the number of words longer than 4 letters
    private static int countLongWords(String[] words, int count) {
        int longWordCount = 0;
        for (int i = 0; i < count; i++) {
            if (words[i].length() > 4) {
                longWordCount++;
            }
        }
        return longWordCount;
    }

    // Method to calculate the average length of all words given
    private static double calculateAverageLength(String[] words, int count) {
        int totalLength = 0;
        for (int i = 0; i < count; i++) {
            totalLength += words[i].length();
        }
        return (double) totalLength / count;
    }
}

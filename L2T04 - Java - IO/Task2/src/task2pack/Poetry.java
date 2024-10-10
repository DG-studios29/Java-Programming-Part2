package task2pack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Poetry {

    // Function to encode a message using the cipher and capitalize vowels
    public static String encodeMessage(String message) {
        StringBuilder encodedMessage = new StringBuilder(); // Initialize a StringBuilder to store the encoded message
        String lowercaseAlphabet = "abcdefghijklmnopqrstuvwxyz"; // Lowercase alphabet string
        String uppercaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Uppercase alphabet string;
        String vowels = "AEIOUaeiou"; // String containing vowels

        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i); // Get the current character from the message
            char encodedChar = currentChar; // Initialize encodedChar with the current character

            if (Character.isLowerCase(currentChar)) {
                // Find the index of the character in the lowercase alphabet
                int index = currentChar - 'a';
                // Calculate the encoded index by adding 15 and wrapping around the alphabet
                int encodedIndex = (index + 15) % 26;
                // Get the encoded character from the lowercase alphabet
                encodedChar = (char) ('a' + encodedIndex);
            } else if (Character.isUpperCase(currentChar)) {
                // Find the index of the character in the uppercase alphabet
                int index = currentChar - 'A';
                // Calculate the encoded index by adding 15 and wrapping around the alphabet
                int encodedIndex = (index + 15) % 26;
                // Get the encoded character from the uppercase alphabet
                encodedChar = (char) ('A' + encodedIndex);
            }

            // If the encoded character is a vowel, make it uppercase
            if (vowels.indexOf(encodedChar) != -1) {
                encodedChar = Character.toUpperCase(encodedChar);
            }

            encodedMessage.append(encodedChar); // Append the encoded character to the encoded message StringBuilder
        }

        return encodedMessage.toString(); // Return the encoded message as a string
    }

    public static void main(String[] args) {
        String inputFileName = "poem.txt";
        String outputFileName = "capitalVowels.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                // Encode each line, capitalize vowels, and write the encoded line to the output file
                String encodedLine = encodeMessage(line);
                bw.write(encodedLine);
                bw.newLine(); // Add a new line for each line in the original poem
            }

            System.out.println("Encoding completed. Check " + outputFileName + " for the encoded poem with capitalized vowels.");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

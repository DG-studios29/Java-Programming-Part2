package task3pack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Poetry {

    // Function to decode a message and reverse the characters of each line
    public static String decodeAndReverse(String message) {
        StringBuilder decodedMessage = new StringBuilder(); // Initialize a StringBuilder to store the decoded message

        // Reverse the characters of the line
        String reversedLine = new StringBuilder(message).reverse().toString();

        // Function to decode a message using the cipher and capitalize vowels
        for (int i = 0; i < reversedLine.length(); i++) {
            char currentChar = reversedLine.charAt(i); // Get the current character from the reversed line
            char decodedChar = currentChar; // Initialize decodedChar with the current character

            if (Character.isLowerCase(currentChar)) {
                // Find the index of the character in the lowercase alphabet
                int index = currentChar - 'a';
                // Calculate the decoded index by subtracting 15 and wrapping around the alphabet
                int decodedIndex = (index - 15 + 26) % 26;
                // Get the decoded character from the lowercase alphabet
                decodedChar = (char) ('a' + decodedIndex);
            } else if (Character.isUpperCase(currentChar)) {
                // Find the index of the character in the uppercase alphabet
                int index = currentChar - 'A';
                // Calculate the decoded index by subtracting 15 and wrapping around the alphabet
                int decodedIndex = (index - 15 + 26) % 26;
                // Get the decoded character from the uppercase alphabet
                decodedChar = (char) ('A' + decodedIndex);
            }

            decodedMessage.append(decodedChar); // Append the decoded character to the decoded message StringBuilder
        }

        return decodedMessage.reverse().toString(); // Reverse the characters again and return the decoded message as a string
    }

    public static void main(String[] args) {
        String inputFileName = "capitalVowels.txt";
        String outputFileName = "reversePoem.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                // Decode each line, reverse the characters, and write the decoded line to the output file
                String decodedLine = decodeAndReverse(line);
                bw.write(decodedLine);
                bw.newLine(); // Add a new line for each line in the original poem
            }

            System.out.println("Decoding and reversing completed. Check " + outputFileName + " for the reversed and decoded poem.");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}



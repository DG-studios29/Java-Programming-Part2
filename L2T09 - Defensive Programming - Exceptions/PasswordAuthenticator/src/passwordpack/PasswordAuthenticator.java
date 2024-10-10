package passwordpack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordAuthenticator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Password Authenticator!");

        while (true) {
            // Prompt the user to create a password and confirm it
            System.out.print("Create a password: ");
            String password1 = scanner.nextLine(); // Read the first password input
            System.out.print("Confirm your password: ");
            String password2 = scanner.nextLine(); // Read the confirmation password input

            // Check if the password is valid and matches the confirmation
            if (isValidPassword(password1, password2)) {
                // If the password is valid and matches, display a success message
                System.out.println("Password created successfully.");
                // Write the password to a file
                writeToFile(password1);
                // Exit the loop since a valid password has been created
                break;
            } else {
                // If the password is not valid or does not match the confirmation
                System.out.println("Password is unusable. Please fix the following:");
                // Check if the password lacks a number and provide feedback
                if (!hasNumber(password1)) {
                    System.out.println("- Password must contain at least one number.");
                }
                // Check if the passwords do not match and provide feedback
                if (!password1.equals(password2)) {
                    System.out.println("- Passwords do not match.");
                }
                // Prompt the user to try creating the password again
                System.out.println("Please try again.");
            }
        }

        scanner.close();
    }

    // Check if a password is valid (contains a number and matches the confirmation)
    private static boolean isValidPassword(String password1, String password2) {
        return hasNumber(password1) && password1.equals(password2);
    }

    // Check if a password contains at least one number
    private static boolean hasNumber(String password) {
        Pattern pattern = Pattern.compile(".*\\d.*");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    // Write a password to a file
    private static void writeToFile(String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("passwords.txt", true))) {
            writer.write(password);
            writer.newLine();
            System.out.println("Password written to 'passwords.txt'.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}

package optionalbonustask;

import java.util.Scanner;

public class searchReplace {

    // Recursive function to replace target substring with replacement in a string
    public static String replaceSubstring(String str, String target, String replacement) {
        int index = str.indexOf(target);
        if (index == -1) {
            return str; // Base case: target substring not found, return the current string
        }

        // Create a new string by replacing the target substring with the replacement
        String newStr = str.substring(0, index) + replacement + str.substring(index + target.length());

        // Recur with the new string to continue searching for other occurrences
        return replaceSubstring(newStr, target, replacement);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a string: ");
        String inputString = scanner.nextLine();

        System.out.print("Please enter the substring you wish to find: ");
        String targetSubstring = scanner.nextLine();

        System.out.print("Please enter a string to replace the given substring: ");
        String replacementString = scanner.nextLine();

        // Call the replaceSubstring function to perform the search and replace
        String newString = replaceSubstring(inputString, targetSubstring, replacementString);

        System.out.println("Your new string is: " + newString);
    }
}


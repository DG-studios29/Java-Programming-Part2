package compulsorytask;

public class NoRepeats {
    public static void main(String[] args) {
        String inputString = "And I think to myself: what a wonderful world!";
        System.out.println("Before " + inputString);
        String result = removeDuplicates(inputString);
        System.out.println("After " + result);
    }

    public static String removeDuplicates(String input) {
        StringBuilder result = new StringBuilder();
        String lowerCaseInput = input.toLowerCase(); // Convert the input to lowercase

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char lowerCaseChar = lowerCaseInput.charAt(i); // Get the lowercase equivalent of the current character

            if (lowerCaseInput.indexOf(lowerCaseChar) == i || currentChar == ' ') {
                // Check if the index of the first occurrence of the lowercase character matches the current index
                // If it matches, this is the first occurrence, so we include it in the result.
                // Also, include spaces in the result.
                result.append(currentChar);
            }
        }

        return result.toString();
    }
}

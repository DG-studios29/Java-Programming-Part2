package task1;

public class palindromeRecursion {
	public static boolean isPalindrome(int[] arr, int start, int end) {
        if (start >= end) {
            return true; // Base case: single element or empty array is a palindrome
        }
        
        if (arr[start] != arr[end]) {
            return false; // If the elements at the current positions don't match, it's not a palindrome
        }
        
        return isPalindrome(arr, start + 1, end - 1); // Recur with the next positions
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 5}; // Example array
        boolean result = isPalindrome(arr, 0, arr.length - 1);
        
        if (result) {
            System.out.println("The array is a palindrome.");
        } else {
            System.out.println("The array is not a palindrome.");
        }
    }
}

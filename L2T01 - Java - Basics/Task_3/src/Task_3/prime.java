package Task_3;

import java.util.Scanner;

public class prime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a positive integer
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        boolean isPrime = checkPrime(number);

        // Print out the number and whether it is a prime number or not
        System.out.println(number + (isPrime ? " is a prime number." : " is not a prime number."));

        scanner.close();
    }

    // Method to check if the number is a prime number
    private static boolean checkPrime(int num) {
        if (num <= 1) {
            return false; // Numbers less than or equal to 1 are not prime
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false; // If the number has factors other than 1 and itself, it is not prime
            }
        }

        return true; // If no factors other than 1 and itself, the number is prime
    }
}


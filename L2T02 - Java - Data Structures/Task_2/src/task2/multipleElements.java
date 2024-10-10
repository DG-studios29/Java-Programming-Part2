package task2;

import java.util.Scanner;

public class multipleElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] array = new int[3][4];

        // Ask the user to enter four numbers for the first row of the array
        System.out.println("Enter four numbers:");
        for (int i = 0; i < 4; i++) {
            array[0][i] = scanner.nextInt();
        }

        // Calculate the first two multiples for each number in the first row and fill the array
        for (int i = 0; i < 4; i++) {
            array[1][i] = array[0][i] * 2;
            array[2][i] = array[0][i] * 3;
        }

        // Print out the array
        System.out.println("The 3-by-4 array with the first two multiples:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}

package task1pack;

import java.util.ArrayList;
import java.util.List;

public class bigo {
	// O(n) algorithm to sequentially insert an element into a list
    public static void insertElementSequentially(List<Integer> list, int element) {
        list.add(element);
    }

    // O(n^2) algorithm to iterate over a 2D array of integers
    public static void iterate2DArray(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    // O(log n) algorithm to sequentially insert an element into a sorted list
    public static void insertElementIntoSorted(List<Integer> sortedList, int element) {
        int low = 0;
        int high = sortedList.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = sortedList.get(mid);

            if (element == midValue) {
                sortedList.add(mid, element);
                return;
            } else if (element < midValue) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        sortedList.add(low, element);
    }

    public static void main(String[] args) {
        // Testing the algorithms
        List<Integer> list = new ArrayList<>();
        insertElementSequentially(list, 5);
        insertElementSequentially(list, 2);
        insertElementSequentially(list, 8);
        System.out.println("List after sequential insertion: " + list);

        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("2D Array:");
        iterate2DArray(array);

        List<Integer> sortedList = new ArrayList<>();
        sortedList.add(1);
        sortedList.add(3);
        sortedList.add(5);
        insertElementIntoSorted(sortedList, 4);
        System.out.println("Sorted list after insertion: " + sortedList);
    }
}

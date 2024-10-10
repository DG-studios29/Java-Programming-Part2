package task1pack;

import java.util.Arrays;

public class priorityQueue {
    private String[] queue;
    private int size;

    public priorityQueue() {
        // Initialize the priority queue as an array.
        queue = new String[10]; // Initial capacity, you can adjust it as needed.
        size = 0;
    }

    public void offer(String element) {
        // Add the element to the end of the array.
        if (size == queue.length) {
            // Double the capacity if the array is full.
            String[] newQueue = new String[queue.length * 2];
            System.arraycopy(queue, 0, newQueue, 0, size);
            queue = newQueue;
        }
        queue[size] = element;
        size++;

        // Bubble up the element to maintain the heap property.
        int childIndex = size - 1;
        while (childIndex > 0) {
            int parentIndex = (childIndex - 1) / 2;
            if (element.compareTo(queue[parentIndex]) >= 0) {
                break; // The element is in its correct position.
            }
            // Swap the element with its parent.
            String temp = queue[childIndex];
            queue[childIndex] = queue[parentIndex];
            queue[parentIndex] = temp;
            childIndex = parentIndex;
        }
    }

    public String remove() {
        if (size == 0) {
            return null; // Empty priority queue
        }
        // Remove the root element (the minimum element in the priority queue).
        String removedElement = queue[0];
        size--;

        // Place the last element at the root and heapify down.
        String lastElement = queue[size];
        queue[0] = lastElement;

        int currentIndex = 0;
        while (true) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;
            int minIndex = currentIndex;

            // Find the index of the minimum element among the current node and its children.
            if (leftChildIndex < size && queue[leftChildIndex].compareTo(queue[minIndex]) < 0) {
                minIndex = leftChildIndex;
            }

            if (rightChildIndex < size && queue[rightChildIndex].compareTo(queue[minIndex]) < 0) {
                minIndex = rightChildIndex;
            }

            if (minIndex == currentIndex) {
                break; // The element is in its correct position.
            }

            // Swap the element with the minimum child.
            String temp = queue[currentIndex];
            queue[currentIndex] = queue[minIndex];
            queue[minIndex] = temp;
            currentIndex = minIndex;
        }
        return removedElement;
    }

    public void sort() {
        // Sort the elements in the custom priority queue using Arrays.sort.
        Arrays.sort(queue, 0, size);
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        priorityQueue pq = new priorityQueue();
        pq.offer("banana");
        pq.offer("apple");
        pq.offer("cherry");
        pq.offer("date");

        System.out.println("Priority Queue size: " + pq.size());

        // Print the elements in the priority queue (unsorted).
        for (int i = 0; i < pq.size(); i++) {
            System.out.print(pq.queue[i] + " ");
        }
        System.out.println();

        // Sort the priority queue.
        pq.sort();

        // Print the elements in the priority queue after sorting.
        for (int i = 0; i < pq.size(); i++) {
            System.out.print(pq.queue[i] + " ");
        }
        System.out.println();

        String removedElement = pq.remove();
        System.out.println("Removed element: " + removedElement);
        System.out.println("Priority Queue size after removal: " + pq.size());
    }
}


package taskpack1;



import java.util.Arrays;

class LinearProbing {
    private int capacity; // The size of the hash table
    private int[] table;  // The hash table itself
    private int[] keys;   // Keys stored in the hash table
    private int[] values; // Corresponding values for the keys
    private int size;     // Number of elements in the hash table

    // Constructor to initialize the hash table with a given capacity
    public LinearProbing(int capacity) {
        this.capacity = capacity;
        this.table = new int[capacity];
        this.keys = new int[capacity];
        this.values = new int[capacity];
        this.size = 0;
        Arrays.fill(table, -1); // Initialize the table with -1 (indicating empty slots)
    }

    // Hash function to compute the index for a given key
    private int hash(int key) {
        return key % capacity;
    }

    // Method to insert a key-value pair into the hash table
    public void insert(int key, int value) {
        if (size == capacity) {
            System.out.println("Hash table is full. Cannot insert.");
            return;
        }

        int index = hash(key);

        // Linear probing to find an empty slot
        while (table[index] != -1) {
            index = (index + 1) % capacity;
        }

        // Insert the key and value
        table[index] = value;
        keys[index] = key;
        size++;
    }

    // Method to remove an entry with a given key from the hash table
    public void remove(int key) {
        int index = find(key);
        if (index == -1) {
            System.out.println("Key not found in the hash table.");
            return;
        }

        // Mark the slot as deleted (-2 is a sentinel value to indicate a deleted slot)
        table[index] = -2;
        size--;
    }

    // Helper method to find the index of a given key in the hash table
    private int find(int key) {
        int index = hash(key);

        while (table[index] != -1) {
            if (keys[index] == key) {
                return index;
            }
            index = (index + 1) % capacity;
        }

        return -1; // Key not found
    }

    // Method to print the contents of the hash table
    public void display() {
        System.out.println("Hash Table:");
        for (int i = 0; i < capacity; i++) {
            if (table[i] != -1 && table[i] != -2) {
                System.out.println("Key: " + keys[i] + ", Value: " + table[i]);
            }
        }
    }

    public static void main(String[] args) {
        LinearProbing hashTable = new LinearProbing(10);

        // Insert key-value pairs
        hashTable.insert(5, 50);
        hashTable.insert(2, 20);
        hashTable.insert(1, 10);
        hashTable.insert(6, 60);

        // Display the initial hash table
        hashTable.display();

        // Remove a key
        hashTable.remove(2);

        // Display the hash table after removal
        hashTable.display();
    }
}

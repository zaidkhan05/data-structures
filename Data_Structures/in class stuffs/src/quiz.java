import java.util.*;
import java.util.hashmap;
import java.util.hashset;
import java.util.hashmap.entry;
import java.util.hashmap.hashmap;
import java.util.hashmap.hashset;
import java.util.hashmap.iterator;
import java.util.hashmap.map;
import java.util.hashmap.set;
import java.util.hashmap.treemap;
import java.util.hashmap.treeset;
import java.util.hashmap.hashmap.entry;
import java.util.hashmap.hashmap.hashmap;
import java.util.hashmap.hashmap.hashset;
import java.util.hashmap.hashmap.iterator;


public class quiz{



    // Function to insert using Linear Probing
    public static void insertLinearProbing(int hashTable[], int n, int key)
    {
        // Compute the index using the key
        int index = key % n;

        // Find the next free space using linear probing
        while (hashTable[index] != 0) {
            index = (index + 1) % n;
        }

        // Insert the key
        hashTable[index] = key;
    }



    
    
    // Driver Code
    public static void main(String args[])
    {
        // Given hash table
        int n = 103;
        int hashTable[] = new int[n];

        // Given keys
        int keys[] = { 103, 0, 205, 308, 411, 2 };

        // Insert the keys into the hash table
        for (int i = 0; i < keys.length; i++) {
            insertLinearProbing(hashTable, n, keys[i]);
        }

        // Print the final hash table
        for (int i = 0; i < n; i++) {
            System.out.println("Index " + i + ": " + hashTable[i]);
        }
        //so they will be
        //Index 0: 0
        //Index 1: 411
        //Index 2: 2
        //Index 3: 103
        //Index 4: 205
        //Index 5: 308
        //Index 6: 0
        //Index 7: 0
        //Index 8: 0
        //Index 9: 0
        //Index 10: 0
        //Index 11: 0
        

    }
    
    
}

/*
An empty hash table has a capacity of 103, and you insert six entries with keys 103, 0, 205, 308, 411, and 2.

Using linear probing and a division hash function, show the final hash table after all the entries have been inserted.


 */
import java.util.Scanner;
import java.util.LinkedList;
import java.util.*;

public class assignment7part2 {
    public static void main(String[] args) {
        //e
        Scanner input = new Scanner(System.in);
        //create a new heap
        Heap<Integer> heap = new Heap<Integer>();
        //prompt the user to enter 5 numbers
        System.out.println("Enter 5 numbers: ");

    }
}
/*
Part 2 - Objective of Part 2 is to reinforce understanding of Heap data structures.

You may use the Java Libraries for solving this problem. We recommend using java.util.* The star “ * ” acts as a wildcard and allows you to use the entire java.util library. For more information on this library review the tutorial https://docs.oracle.com/javase/tutorial/collections/intro/index.html

The heap presented in our textbook is also known as a max-heap, in which each node is greater than or equal to any of its children. A min-heap is a heap in which each node is less than or equal to any of its children. Min-heaps are often used to implement priority queues. Revise the Heap class in Listing 23.9 (which starts on p.878) to implement a min-heap.

Use the following logic:

1.	Write a main method that will accept 5 numbers, and put them in a min-heap

2.	Remove them from the min heap, printing one at a time as they are removed, to show that the list is sorted

Hint: the textbook example is for a MAX heap; you must alter that example to reflect a MIN heap – think about it !

No files or data are provided for this part of the assignment.

 */
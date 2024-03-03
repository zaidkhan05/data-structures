import java.util.Scanner;
import java.util.LinkedList;
// import java.util.*;

class MinHeap<E extends Comparable<E>> {
    private LinkedList<E> list = new LinkedList<E>();

    public MinHeap() {
    }

    public MinHeap(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    public void add(E newObject) {
        list.add(newObject);
        int currentIndex = list.size() - 1;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (list.get(currentIndex).compareTo(list.get(parentIndex)) < 0) {
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            } else
                break;
            currentIndex = parentIndex;
        }
    }

    public E remove() {
        if (list.size() == 0)
            return null;

        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            if (leftChildIndex >= list.size())
                break;
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) > 0) {
                    maxIndex = rightChildIndex;
                }
            }
            if (list.get(currentIndex).compareTo(list.get(maxIndex)) > 0) {
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            } else
                break;
        }
        return removedObject;
    }

    public int getSize() {
        return list.size();
    }
}

public class assignment7part2 {
    public static void main(String[] args) {
        //e
        Scanner input = new Scanner(System.in);
        //create a new heap
        MinHeap<Integer> heap = new MinHeap<Integer>();
        //prompt the user to enter 5 numbers
        System.out.println("Enter 5 numbers: ");
        //add the numbers to the heap
        for(int i = 0; i < 5; i++){
            heap.add(input.nextInt());
        }
        //remove the numbers from the heap and print them
        for(int i = 0; i < 5; i++){
            System.out.println(heap.remove());
            
        }


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
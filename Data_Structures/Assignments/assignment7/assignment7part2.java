// Name:	Zaid Khan
// Class:	CS 3305/W04
// Term:	Spring 2024
// Instructor:  Carla McManus
// Assignment:  7-Part-2-Heaps
// IDE:  vscode
import java.util.Scanner;
import java.util.LinkedList;
//heap class
class MinHeap<E extends Comparable<E>> {
    //new linkedlist
    private LinkedList<E> list = new LinkedList<E>();
    //blank constructor
    public MinHeap() {
    }
    //constructor with parameter
    public MinHeap(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }
    //add method
    public void add(E newObject) {
        //adding to the linkedlist
        list.add(newObject);
        //holder
        int currentIndex = list.size() - 1;
        //sorting the list
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
    //remove method
    public E remove() {
        if (list.size() == 0){
            return null;
        }
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
    //getsize method
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
        System.out.println("here is the heap");
        //remove the numbers from the heap and print them
        for(int i = 0; i < 5; i++){
            System.out.println(heap.remove());
            
        }


    }
}
//pseudocode
//create heap class
//create linkedlist
//create blank constructor
//create constructor with parameter
//create add method
//create remove method
//create getsize method
//create main method
//create scanner
//create new heap
//prompt user to enter 5 numbers
//add the numbers to the heap
//remove the numbers from the heap and print them

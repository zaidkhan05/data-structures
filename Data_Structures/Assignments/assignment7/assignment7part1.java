
import java.util.*;
import java.util.LinkedList;
import java.io.*;

public class assignment7part1 {
    //merge sort method
    public static LinkedList<Integer> mergeSort(LinkedList<Integer> list){
        //if the list is empty or has only one element, return the list
        if(list.size() <= 1){
            return list;
        }
        //create two new linked lists
        LinkedList<Integer> left = new LinkedList<Integer>();
        LinkedList<Integer> right = new LinkedList<Integer>();
        //add the elements from the list to the left and right lists
        for(int i = 0; i < list.size(); i++){
            if(i < list.size()/2){
                left.add(list.get(i));
            }
            else{
                right.add(list.get(i));
            }
        }
        //recursively sort the left and right lists
        left = mergeSort(left);
        right = mergeSort(right);
        //return the merged lists
        return merge(left, right);
    }
    //merge method
    public static LinkedList<Integer> merge(LinkedList<Integer> left, LinkedList<Integer> right){
        //create a new linked list
        LinkedList<Integer> merged = new LinkedList<Integer>();
        //while both lists are not empty
        while(!left.isEmpty() && !right.isEmpty()){
            //if the first element in the left list is less than the first element in the right list
            if(left.getFirst() < right.getFirst()){
                //add the first element in the left list to the merged list
                merged.add(left.removeFirst());
            }
            //if the first element in the right list is less than the first element in the left list
            else{
                //add the first element in the right list to the merged list
                merged.add(right.removeFirst());
            }
        }
        //if the left list is not empty, add the remaining elements to the merged list
        while(!left.isEmpty()){
            merged.add(left.removeFirst());
        }
        //if the right list is not empty, add the remaining elements to the merged list
        while(!right.isEmpty()){
            merged.add(right.removeFirst());
        }
        //return the merged list
        return merged;
    }
    public static void main(String[] args) {
        //create a new linked list
        LinkedList<Integer> list = new LinkedList<Integer>();
        //add the integers from the file to the linked list
        try{
            File file = new File("C:\\Users\\agent\\data-structures-1\\Data_Structures\\Assignments\\assignment7\\mergetest.txt");
            Scanner sc = new Scanner(file);
            while(sc.hasNextInt()){
                list.add(sc.nextInt());
            }
            sc.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        //print the unsorted list
        System.out.println("Unsorted list: " + list);
        //sort the list
        list = mergeSort(list);
        //print the sorted list
        System.out.println("Sorted list: " + list);
    }
    
}

/*
Part 1 - The objective of Part 1 is to reinforce the understanding of Sorting data structures.

You must write your own Mergesort code using Linked Lists, not ArrayLists, and you may use Linked List class available in the Java Library. You may not use any predefined sorting methods in the Java Library.

One of the advantages of Mergesort algorithm is that it can easily be adapted to sort a linked list of values. This is because the algorithm retrieves the values from the two lists being merged in the order that they occur in the lists. If the lists are linked lists, then that algorithm can simply move down the list node after node.

Write a program that sorts a linked list of integers using the Mergesort algorithm. The program will read the integers into a linked list, and then sort the linked list using Mergesort. This will require additional linked lists, but you should use linked lists, not arrays, for all your list storage.

You may read data from the mergetest.txt file that we have provided or you may hard code that data, into one linked list. Once you have the linked list, then you begin the Mergesort algorithm.

 */
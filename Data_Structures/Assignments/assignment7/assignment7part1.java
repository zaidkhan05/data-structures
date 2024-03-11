// Name:	Zaid Khan
// Class:	CS 3305/W04
// Term:	Spring 2024
// Instructor:  Carla McManus
// Assignment:  7-Part-1-Sorting
// IDE:  vscode
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
        //create left and right linked lists
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
        //recursively sort the left and right lists cuz linkedlists
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
        //try-catch block to handle file not found exception
        try{
            File file = new File("C:\\Users\\agent\\data-structures-1\\Data_Structures\\Assignments\\assignment7\\mergetest.txt");
            Scanner sc = new Scanner(file);
            while(sc.hasNextInt()){
                list.add(sc.nextInt());
            }
            sc.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found, add the source path ");
        }
        //print the unsorted list
        System.out.println("Unsorted list: " + list);
        //sort the list
        list = mergeSort(list);
        //print the sorted list
        System.out.println("Sorted list: " + list);
    }
    
}

//pseudocode
////////////////////////////
//mergesort method
//mergeSort(list)
//if list.size <= 1
//return list
//left = new LinkedList
//right = new LinkedList
//for i = 0 to list.size
//if i < list.size/2
//add list.get(i) to left
//else
//add list.get(i) to right
//left = mergeSort(left)
//right = mergeSort(right)
//return merge(left, right)
///////////////////////////////
//merge method
//merge(left, right)
//merged = new LinkedList
//while left is not empty and right is not empty
//if left.getFirst < right.getFirst
//add left.removeFirst to merged
//else
//add right.removeFirst to merged
//while left is not empty
//add left.removeFirst to merged
//while right is not empty
//add right.removeFirst to merged
//return merged
///////////////////////////////
//main method
//list = new LinkedList
//try/catch block for opening file and getting the integers and add them to the list
//print "Unsorted list: " + list
//list = mergeSort(list)
//print "Sorted list: " + list
///////////////////////////////

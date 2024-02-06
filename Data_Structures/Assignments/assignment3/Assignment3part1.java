// Name:	Zaid Khan
// Class:	CS 3305/W04
// Term:	Spring 2024
// Instructor:  Carla McManus
// Assignment:  3 – Part 1 Iterator
// IDE:  Visual Studio Code - Insiders

import java.util.*;

public class Assignment3part1 {
    //printrange method
    void printRange(int x, int y){
        //create a linked list
        LinkedList<Integer> sampleData = new LinkedList<Integer>();
        //add values to the list
        sampleData.add(1);
        sampleData.add(1);
        sampleData.add(2);
        sampleData.add(3);
        sampleData.add(3);
        sampleData.add(4);
        sampleData.add(4);
        sampleData.add(5);
        sampleData.add(6);
        sampleData.add(7);
        //create an iterator
        ListIterator<Integer> listIterator = sampleData.listIterator();
        //create a boolean to check if the first value is found
        boolean foundFirst = false;
        //create a boolean to check if the second value is found
        boolean foundSecond = false;
        //create a string to store the values
        String values = "";
        //iterate through the list
        while(listIterator.hasNext()){
            //if the first value is found
            if(listIterator.next() == x){
                //set the boolean to true
                foundFirst = true;
                //add the value to the string
                values += x + " ";
                //iterate through the rest of the list
                while(listIterator.hasNext()){
                    //if the second value is found
                    if(listIterator.next() == y || !listIterator.hasNext()){
                        //set the boolean to true
                        foundSecond = true;
                        //print the values
                        System.out.println(values);
                        //break the loop
                        break;
                    }
                    //add the value to the string
                    values += listIterator.next() + " ";
                    
                }
            }
            //if the second value is found
            if(foundSecond){
                //break the loop
                break;
            }
        }
        //if the first value is not found
        if(!foundFirst){
            //print nothing
            System.out.println("");
        }
        //if the second value is not found
        // if(!foundSecond){
        //     //print the values
        //     System.out.println(values);
        // }

    }

    void removeRepetitions(){

    }

    public static void main(String[] args) {
        //create a linked list
        LinkedList<Integer> sampleData = new LinkedList<Integer>();
        //add values to the list
        sampleData.add(1);
        sampleData.add(1);
        sampleData.add(2);
        sampleData.add(3);
        sampleData.add(3);
        sampleData.add(4);
        sampleData.add(4);
        sampleData.add(5);
        sampleData.add(6);
        sampleData.add(7);

        //print the range of values
        Assignment3part1 list = new Assignment3part1();
        list.printRange(2, 5);
       list.printRange(2, 78);
        list.printRange(2, 1);
        list.printRange(8, 5);
        //remove the repetitions
        // list.removeRepetitions();
    }
}


/*
Part 1 – Linked List Iterator

Write a program that creates a linked list of integers, assigns integers to the linked list, prints a range of values in the list and eliminates duplicate numbers in the list. Your program must have two methods:

First method is called printRange which has two parameters, x and y. printRange should write out all integers in the list that are between the first occurrence of x (inclusive) and the first occurrence of y (but not including y). You may assume integers can be compared for equality using ==

Use the following header for the method:

void printRange(int x, int y);

Use the following logic to develop printRange	This makes the implementation easier.

•	Do not sort or reorganize the data

•	Print integers from x to y including x but not including y

•	If there isn’t an entry with a value equal to x, then print nothing

•	If there isn’t an entry after x, that has a value equal to y, then print the integers from x (inclusive) to the end of the list

•	Print the values on one line separated by space.

•	Put an end of line after the values are ALL printed.


Hint, your program will need to make multiple calls to printRange

For this program, you are [hard coding] creating your data in the program, and not entering it from the console. In your program create a linked list with the following members:

{1, 1, 2, 3, 3, 4, 4, 5, 6, 7}.

Review the sample output below. You MUST USE the values for x and y, shown (shown in bold) as parameters in multiple calls to printRange to test the logic of your program

Below is sample output.	.	// Comments
 
List [1,2,3,4,5,6,7]		// x = 2	y = 5
prints  2 3	4	// prints list including x but not y




List [1,2,3,4,5,6,7]		// x = 2	y = 78
prints  2 3	4567	// prints list including x, no value =y so print to end
List [1,2,3,4,5,6,7]		// x = 2	y = 1
prints  2 3	4567	// prints list including x, no value =y so print to end
List [1,2,3,4,5,6,7]		// x = 8	y = 5
		// prints nothing




The second method is called removeRepetitions. removeRepetitions steps through the linked list comparing numbers and when duplicate numbers are found, removes one of the duplicate numbers. Again, you may assume integers can be compared for equality using ==

Use the following header for the method removeRepetitions:

void removeRepetitions()

Here is a brief outline of an algorithm for removeRepetitions:

variable p steps through the list

for each number in the list, define a new variable q equal to p While q is not the last number in the list

If the next number has data equal to the data in p, remove the next number

Otherwise move q to the next number

 */
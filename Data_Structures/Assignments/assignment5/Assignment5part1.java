// Name:	Zaid Khan
// Class:	CS 3305/W04
// Term:	Spring 2024
// Instructor:  Carla McManus
// Assignment:  05-Part-1-Queues
// IDE:  vscode

import java.util.LinkedList;
import java.util.Scanner;


public class Assignment5part1 {
    public static void main(String[] args) {
        //create a new linked list
        LinkedList<String> list = new LinkedList<String>();
        System.out.println("Lets make a list for the chores we need to do!");
        Scanner sc = new Scanner(System.in);
        while(true){
            // list.add("");
            System.out.println("Enter a chore: ");
            String chore = sc.nextLine();
            System.out.println("Enter the priority of the chore: ");
            int priority = sc.nextInt();
            sc.nextLine();
            list.add(priority, chore);
            System.out.println("Do you want to add another chore? (y/n)");
            if(sc.next().equalsIgnoreCase("n")){
                break;
            }
        }
        System.out.println("Here is the list of chores and their priorities: ");
        sc.close();

        System.out.println(list);
    }
    
}

/*
Objectives	The purpose of this lab is to reinforce linked list and queue concepts in Java

Assignment 05 PART 1	Queues (50 points) - Note Part 1 is a separate deliverable:

Write a class with a main method that uses a priority queue to store a list of chores and the chore’s priority. You need to store the name of the chore and it’s assigned priority. Assigned priorities can be any positive integer. The rest is up to you.

YOU may use the Java Linked List Class, and build your queue with that class.

 */
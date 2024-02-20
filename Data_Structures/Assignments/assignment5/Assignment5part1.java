// Name:	Zaid Khan
// Class:	CS 3305/W04
// Term:	Spring 2024
// Instructor:  Carla McManus
// Assignment:  05-Part-1-Queues
// IDE:  vscode

import java.util.LinkedList;
import java.util.Scanner;

class Queue extends LinkedList<String>{
    public void add(int priority, String chore){
        if(this.isEmpty()){
            this.add(chore + " - " + priority);
        }
        else{
            //sort the list based on priority
            for(int i = 0; i < this.size(); i++){
                for(int j = 0; j < this.size(); j++){

                String[] temp = this.get(i).split(" - ");
                
                if(priority < Integer.parseInt(temp[1])){
                    String temp2 = this.get(i);
                    this.remove(i);
                    this.add(chore + " - " + priority);
                    this.add(temp2);
                    return;
                }
                
            }
            }
            this.add(chore + " - " + priority);
        }
    }
    public void dequeue(){
        if(!this.isEmpty()){
            this.removeFirst();
            System.out.println("you have completed" + this.getFirst() + "!, now you have to do " + this.getFirst());    
        }
        else{
            System.out.println("The list is empty");
        }
    }

    
}


public class Assignment5part1 {
    public static void main(String[] args) {
        //create a new linked list
        Queue chores = new Queue();
        System.out.println("Lets make a list for the chores we need to do!");
        Scanner sc = new Scanner(System.in);
        boolean addMore = true;
        while(addMore){
            // list.add("");
            System.out.println("Enter a chore: ");
            String chore = sc.nextLine();
            System.out.println("Enter the priority of the chore: ");
            int priority = sc.nextInt();
            sc.nextLine();
            chores.add(priority, chore);

            System.out.println("Do you want to add another chore? (y/n)");
            String temp = sc.nextLine();
            if(temp.equalsIgnoreCase("n")){
                addMore = false;
            }
            else if(temp.equalsIgnoreCase("y")){
                addMore = true;
            }
            else{
                System.out.println("Invalid input, assuming you want to add another chore");
                addMore = true;
            }
        }
        System.out.println("Here is the list of chores and their priorities: ");
        sc.close();

        System.out.println(chores);
    }
    
}

/*
Objectives	The purpose of this lab is to reinforce linked list and queue concepts in Java

Assignment 05 PART 1	Queues (50 points) - Note Part 1 is a separate deliverable:

Write a class with a main method that uses a priority queue to store a list of chores and the chore’s priority. You need to store the name of the chore and it’s assigned priority. Assigned priorities can be any positive integer. The rest is up to you.

YOU may use the Java Linked List Class, and build your queue with that class.

 */
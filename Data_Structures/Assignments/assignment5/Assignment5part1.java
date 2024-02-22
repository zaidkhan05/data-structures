// Name:	Zaid Khan
// Class:	CS 3305/W04
// Term:	Spring 2024
// Instructor:  Carla McManus
// Assignment:  05-Part-1-Queues
// IDE:  vscode

import java.util.LinkedList;
import java.util.Scanner;

class Queue extends LinkedList<String>{
    //add a chore to the list based on priority
    public void add(int priority, String chore){
        //if the list is empty, add the chore
        if(this.isEmpty()){
            this.add(chore + " - " + priority);
        }
        //if the list is not empty, add the chore based on priority
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
    //remove the first element in the list
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
        //create a new priority queue
        Queue chores = new Queue();
        System.out.println("Lets make a list for the chores we need to do!");
        Scanner sc = new Scanner(System.in);
        boolean addMore = true;
        //add chores to the list
        while(addMore){
            // list.add("");
            System.out.println("Enter a chore: ");
            String chore = sc.nextLine();
            System.out.println("Enter the priority of the chore: ");
            int priority = sc.nextInt();
            sc.nextLine();
            //add the chore to the list
            chores.add(priority, chore);

            System.out.println("Do you want to add another chore? (y/n)");
            String temp = sc.nextLine();
            //check if the user wants to add another chore
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
        //print the list of chores
        System.out.println("Here is the list of chores and their priorities: ");
        sc.close();

        System.out.println(chores);
    }
    
}
//pseudocode
//create a new priority queue
//create a scanner
//create a boolean to check if the user wants to add more chores
//while the user wants to add more chores
//  ask the user for a chore
//  ask the user for the priority of the chore
//  add the chore to the list
//  ask the user if they want to add another chore
//  if the user does not want to add another chore, set addMore to false
//  if the user wants to add another chore, set addMore to true
//  if the user enters an invalid input, assume they want to add another chore
//print the list of chores

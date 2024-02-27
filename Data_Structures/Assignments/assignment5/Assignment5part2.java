// Name:	Zaid Khan
// Class:	CS 3305/W04
// Term:	Spring 2024
// Instructor:  Carla McManus
// Assignment:  05-Part-2-Shoppers
// IDE:  vscode
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Assignment5part2 {
    public static void main(String Args[]){
        //create 5 queues for the checkouts
        Queue[] checkouts = new Queue[5];
        for(int i = 0; i < checkouts.length; i++){
            //use linkedlists for the different checkouts
            checkouts[i] = new LinkedList<String>();
        }
        Scanner sc = new Scanner(System.in);
        boolean addMore = true;
        boolean gameRunning = true;
        //add 1 customer to each line
        for(int i = 0; i < checkouts.length; i++){
            //add a customer to each line
            System.out.println("Name a customer for line " + (i+1) + ": ");
            String x = sc.nextLine();
            checkouts[i].add(x);
        }
        //start the simulation
        while(gameRunning){
            for(int i = 0; i < checkouts.length; i++){
                //if the line is not empty, print the customer being served
                if(!checkouts[i].isEmpty()){
                    System.out.println("Customer " + checkouts[i].peek() + " is being served at queue " + (i+1));
                }
            }
            //add more customers to the lines
            System.out.println("Are there more customers waiting to get in line? (y/n)");
            String waitForLine = sc.nextLine();
            addMore = true;
            //if the user does not want to add more customers, set addMore to false
            if(waitForLine.equals("n")){
                addMore = false;
            }
            //add customers to the lines
            while(addMore){
                //add a customer to the shortest line
                System.out.println("Enter a customer name: ");
                String customer = sc.nextLine();
                int shortestLine = 0;
                for(int i = 0; i < checkouts.length; i++){
                    if(checkouts[i].size() < checkouts[shortestLine].size()){
                        shortestLine = i;
                    }
                }
                checkouts[shortestLine].add(customer);
                //ask if the user wants to add more customers
                System.out.println("Are there more customers waiting to get in line? (y/n)");
                String moreForLine = sc.nextLine();
                addMore = true;
                if(moreForLine.equals("n")){
                    addMore = false;
                }
            }
            //print the lines
            for(int i = 0; i < checkouts.length; i++){
                System.out.println("Line " + i + ": " + checkouts[i]);
            }
            
            for(int i = 0; i < checkouts.length; i++){
                if(!checkouts[i].isEmpty()){
                    System.out.println("Customer " + checkouts[i].peek() + " has checked out from line " + (i+1));
                    checkouts[i].remove();
                }
            }
            //ask if the user wants to continue the simulation
            System.out.println("Do you want to continue the simulation? (y/n)");
            String continueSim = sc.nextLine();
            if(continueSim.equals("n")){
                gameRunning = false;
            }

        }
        System.out.println("The simulation has ended");
        sc.close();
        
    }
    
}
//pseudocode
// create 5 queues for the checkouts
// add 1 customer to each line
// start the simulation
// while the game is running
//     for each line
//         if the line is not empty, print the customer being served
//     add more customers to the lines
//     ask if the user wants to add more customers
//     if the user does not want to add more customers, set addMore to false
//     add customers to the lines
//     ask if the user wants to add more customers
//     print the lines
//     for each line
//         if the line is not empty, print the customer being served
//         remove the customer from the line
//     ask if the user wants to continue the simulation
//     if the user does not want to continue the simulation, set gameRunning to false
// print that the simulation has ended


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
        //e
        Queue[] checkouts = new Queue[5];
        for(int i = 0; i < checkouts.length; i++){
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
        while(gameRunning){
            for(int i = 0; i < checkouts.length; i++){
                if(!checkouts[i].isEmpty()){
                    System.out.println("Customer " + checkouts[i].peek() + " is being served at queue " + (i+1);
                }
            }
            System.out.println("Are there more customers waiting to get in line? (y/n)");
            String waitForLine = sc.nextLine();
            addMore = true;
            if(waitForLine.equals("n")){
                addMore = false;
            }
            while(addMore){
                System.out.println("Enter a customer: ");
                String customer = sc.nextLine();
                int shortestLine = 0;
                for(int i = 0; i < checkouts.length; i++){
                    if(checkouts[i].size() < checkouts[shortestLine].size()){
                        shortestLine = i;
                    }
                }
                checkouts[shortestLine].add(customer);
                
                System.out.println("Are there more customers waiting to get in line? (y/n)");
                String moreForLine = sc.nextLine();
                addMore = true;
                if(moreForLine.equals("n")){
                    addMore = false;
                }
            }
            for(int i = 0; i < checkouts.length; i++){
                System.out.println("Line " + i + ": " + checkouts[i]);
            }
            
            for(int i = 0; i < checkouts.length; i++){
                if(!checkouts[i].isEmpty()){
                    System.out.println("Customer " + checkouts[i].peek() + " has checked out from line " + (i+1);
                    checkouts[i].remove();
                }
            }
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
/*
Write a program to simulate checkout lines at a grocery store. There will be multiple queues, one for each check out line. For this exercise, you may assume there are 5 check out lines. You can use an array of queues to simulate the checkout lines.

Use the following logic:

1.	Generate 5 customers and enqueue them, one customer in each queue

2.	Each new customers ready to check out choose the shortest line

Customers enter the check out queues randomly, and then each time a customer is generated that customer chooses the shortest line.

If the lines are equal, then the first available line is chosen. Each transaction takes a random amount of time to complete. Print each action taken with Queue number, to the display.

For your output show the queues with customers and activity, showing changes in each queue.

You can capture all of the output at the end of the program running. Program should list actions that have been performed and Queue numbers.

Be sure to limit your program in order to ensure that it does not run forever.

 */

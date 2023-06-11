
import java.util.ArrayList;
import java.util.Scanner;
class Lot {
   
    private int lotNumber = 1001;
    private String description;
    private int currentBid;
    private int bidIncrement;
    private boolean sold;
    static int thethink = 0;
    Lot(){
        this.lotNumber += thethink;
        this.thethink++;
        this.description = "Unknown Item";
        this.currentBid = 0;
        this.bidIncrement = 0;
        this.sold = false;
    }
    Lot(String description, int currentBid, int bidIncrement){
        this.lotNumber+= thethink;
        this.thethink++;
        this.description = description;
        this.currentBid = currentBid;
        this.bidIncrement = bidIncrement;
        this.sold = false;
    }
    public void markSold(){
        this.sold = true;
    }
    boolean getSold(){
        return this.sold;
    }
    int getBidIncrement(){
        return this.bidIncrement;
    }
    String getDescription(){
        return this.description;
    }
    void setCurrentBid(int newBid){
        this.currentBid = newBid;
    }
    int nextBid(){
        return this.currentBid + this.bidIncrement;
    }
    @Override
    public String toString(){
        if(this.sold){
            return "Lot " + this.lotNumber + ". " + this.description + " was sold for $" + this.currentBid;
        }
        else{
            return "Lot " + this.lotNumber + ". " + this.description + " current bid $" + this.currentBid + " minimum bid $" + this.nextBid();
        }
    }

}



public class Assignment2{

    static Lot getNexLot(ArrayList<Lot> lots){
        if(lots.size() == 0){
            return new Lot();
        }
        else{
            return(lots.get(0));
        }
    }
    static void addItem(ArrayList<Lot> lots){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please give a description for the new lot: ");
        String description = sc.nextLine();
        System.out.println("What is the starting bid? ");
        int startingBid = sc.nextInt();
        System.out.println("What is the bid increment? ");
        int bidIncrement = sc.nextInt();
        Lot newLot = new Lot(description, startingBid, bidIncrement);
        lots.add(newLot);
        
    }
    static void bid(Lot lot){
        Scanner sc = new Scanner(System.in);
        System.out.println("The minimum bid you can make is $" + lot.nextBid() + ".");
        System.out.println("How much do you want to bid? ");
        int newBid = sc.nextInt();
        if(newBid < lot.nextBid()){
            System.out.println("Your bid is too low.");
        }
        else{
            lot.setCurrentBid(newBid);
        }
        
    }
    static void markSold(Lot lot){
        lot.markSold();
        System.out.println(lot.toString());
    }
    static void mainMenu(ArrayList<Lot> lots){
        Scanner sc = new Scanner(System.in);
        Lot currentLot = null;
        int choice = 0;
        do{
            if(currentLot != null && !lots.get(0).getDescription().equalsIgnoreCase("Unknown Item")){
                // currentLot = getNexLot(lots);
                System.out.println("Current Lot: " + currentLot);
            }
            else{
                System.out.println("We are not currently bidding.");
            }
            System.out.println("1. Add Lot to auction");
            System.out.println("2. Start bidding on next Lot");
            System.out.println("3. Bid on current Lot");
            System.out.println("4. Mark current Lot sold");
            System.out.println("5. Quit");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    addItem(lots);
                    break;
                case 2:
                    
                    if(lots.size() == 0){
                        System.out.println("There is nothing to bid on, add an item first");
                    }
                    else if(currentLot == null){
                        currentLot = getNexLot(lots);
                    }
                    else if(currentLot.getSold() == false){
                        System.out.println("You must mark the current lot as sold before bringing up the next Lot.");
                    }
                    else{
                        lots.remove(0);
                        currentLot = getNexLot(lots);
                    }
                    break;
                case 3:
                    if(currentLot == null || lots.get(0).getDescription().equalsIgnoreCase("Unknown Item") || currentLot.getSold() == true){
                        System.out.println("You must first bring a Lot up for bidding");
                    }
                    else{
                        bid(currentLot);
                    }
                    break;
                case 4:
                    if(currentLot == null || lots.get(0).getDescription().equalsIgnoreCase("Unknown Item") || currentLot.getSold() == true){
                        System.out.println("You must first bring a Lot up for bidding");
                    }
                    else{
                        markSold(currentLot);
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }while(choice != 5);
        
    }
    public static void main(String[] args){
        //e
        ArrayList<Lot> auction = new ArrayList<Lot>();
        mainMenu(auction);
    }
}

/*
CSE1322L Assignment 2 - Spring 2023
Introduction:
In this week’s assignment you’ll write software for an auction company. Your program
will allow the auction company to enter “Lots” of items for sale. A Lot is either one item,
or a bunch of items which are being sold together. Each item has a starting price, and a
bid increment. For example an item may start off as $100, with a bid increment of $25,
which means the next lowest amount someone can bid is $125, then $150 etc. People
can of course bid more than the bid increment.
An auction can have as many items as they want, but only one item will be available to
bid at any given time.
Tasks:
● Begin by creating a class called Lot
● It must have private attributes for lotNumber (int), description (string), currentBid (int),
bidIncrement (int), sold (boolean).
● Each lot will be sequentially numbered starting at 1001.
● Write a default constructor which sets:
○ lotNumber to the next sequential number. Ie, the first object of type Lot should
have a lotNumber of 1001, the next object should be 1002, then 1003 etc. The
person creating the object will not need to pass this value in, it’ll be calculated in
the class itself.
○ Description should be set to “Unknown Item”
○ currentBid and bidIncrement should both be set to 0.
○ sold should be set to false.
● Write an overloaded constructor that takes in a description, startingBid and
bidIncrement.
○ Again, the lotNumber should be automatically calculated, just like in the default
constructor.
○ The description, currentBid and bidIncrement should be set to the parameters
passed in
○ sold should be set to false.
● Create a method markSold, which sets Sold to true
● Create a getter method for sold, bidIncrement, and description
● Create a setter method for currentBid
● Create a method nextBid which returns the next possible lowest bid. This is the
currentBid + the bidIncrement.
● Create an override of toString (Java) or ToString (C#)
○ If the lot is sold (check the boolean), return a string like:
■ “Lot 1001. Description was sold for $500”
○ If the lot is not sold, return a string like:
■ “Lot 1001. Description current bid $100 minimum bid $120”
○ In both cases Lot 1001 should be the actual lot number, the description should
replace the word Description and the current bid/sold amount should be the
current bid, and the minimum bid should be the nextBid.
Next you’ll write a number of methods in your driver class:
● Write a method getNextLot.
○ This will take in an ArrayList (Java) or List (C#) of Lots.
○ It should return a Lot
○ If the auction ArrayList/List has items in it, return the first item (from cell 0) and
remove it from the ArrayList/List.
○ Otherwise return an empty Lot created using the default constructor.
● Write a method addItem
○ This will take in an ArrayList (Java) or List (C#) of lots
○ It will return void
○ It will prompt the user for a new Description, starting bid, and bid increment, then
create a lot and add it to the ArrayList/List that was passed in.
● Write a method bid
○ This will take in a Lot
○ Ask the user how much they want to bid, and tell them the minimum bid they
must make.
○ Read in the users bid
○ If it’s too small (below the minimum bid) tell them.
○ Otherwise change the current bid for this Lot item to the amount they bid.
● Create a method markSold
○ This will take in a Lot
○ Mark the lot as sold
○ Print out the current Lot
● Create a method mainMenu
○ This will take in an ArrayList (Java) or List (C#) of Lots
○ Define a currentLot of type Lot and set it to null.
○ Using a loop you’ll print out the menu until the user chooses option 5.
■ If you currently have a Lot to bid on, print Current Lot: Followed by the
description of the lot.
■ If you don’t have a lot yet (currentLot is null or it’s description is “Unknown
Item”), print “We are not currently bidding”
■ Next print the menu:
● 1. Add Lot to Auction
● 2. Start bidding on next Lot
● 3. Bid on current Lot
● 4. Mark current Lot sold
● 5. Quit
■ Read in the users choice
● If the user chooses 1 use the appropriate method to add an item
to the auction.
● If the user chooses 2, first check that there are Lots in the auction.
If there are currently none print “There is nothing to bid on, add an
item first”
○ If you have a current lot, and it’s not sold print “You must
mark the current lot as sold before bringing up the next
Lot”
○ Otherwise get the next lot and store it in currentLot
● If the user chooses 3 and the current lot is null, or the current lot’s
description is “Unknown Item” or the current lot is sold print: “You
must first bring a Lot up for bidding”
○ Otherwise, allow the user to bid
● If the user chooses 4 and the current lot is null or the current lot’s
descriptions is “Unknown Item”, or the current lot is sold print: “You
must first bring a Lot up for Bidding”
○ Otherwise, mark the current lot as sold
● Your main method should simple create an ArrayList (Java) or List (C#) of Lot called
auction.
○ Call mainMenu passing it the auction collection.
Example Runs: [User input in red]
We are not currently bidding
1. Add Lot to Auction
2. Start bidding on next Lot
3. Bid on current Lot
4. Mark current Lot Sold
5. Exit
1
What is the description of this item
65" Samsung OLED TV
What is the starting bid
350
What is the bid increment
25
We are not currently bidding
1. Add Lot to Auction
2. Start bidding on next Lot
3. Bid on current Lot
4. Mark current Lot Sold
5. Exit
1
What is the description of this item
Desk Lamp
What is the starting bid
5
What is the bid increment
5
We are not currently bidding
1. Add Lot to Auction
2. Start bidding on next Lot
3. Bid on current Lot
4. Mark current Lot Sold
5. Exit
1
What is the description of this item
Gamer Chair, red with armrests.
What is the starting bid
100
What is the bid increment
10
We are not currently bidding
1. Add Lot to Auction
2. Start bidding on next Lot
3. Bid on current Lot
4. Mark current Lot Sold
5. Exit
3
You must first bring a Lot up for bidding
We are not currently bidding
1. Add Lot to Auction
2. Start bidding on next Lot
3. Bid on current Lot
4. Mark current Lot Sold
5. Exit
4
You must first bring a Lot up for bidding
We are not currently bidding
1. Add Lot to Auction
2. Start bidding on next Lot
3. Bid on current Lot
4. Mark current Lot Sold
5. Exit
2
Current Lot:
Lot 1001. 65" Samsung OLED TV current bid: $350 minimum bid: $375
1. Add Lot to Auction
2. Start bidding on next Lot
3. Bid on current Lot
4. Mark current Lot Sold
5. Exit
3
How much would you like to bid?
Minimum bid is 375
375
Current Lot:
Lot 1001. 65" Samsung OLED TV current bid: $375 minimum bid: $400
1. Add Lot to Auction
2. Start bidding on next Lot
3. Bid on current Lot
4. Mark current Lot Sold
5. Exit
3
How much would you like to bid?
Minimum bid is 400
500
Current Lot:
Lot 1001. 65" Samsung OLED TV current bid: $500 minimum bid: $525
1. Add Lot to Auction
2. Start bidding on next Lot
3. Bid on current Lot
4. Mark current Lot Sold
5. Exit
4
Lot 1001. 65" Samsung OLED TV was sold for $500
Current Lot:
Lot 1001. 65" Samsung OLED TV was sold for $500
1. Add Lot to Auction
2. Start bidding on next Lot
3. Bid on current Lot
4. Mark current Lot Sold
5. Exit
3
You must first bring a Lot up for bidding
Current Lot:
Lot 1001. 65" Samsung OLED TV was sold for $500
1. Add Lot to Auction
2. Start bidding on next Lot
3. Bid on current Lot
4. Mark current Lot Sold
5. Exit
2
Current Lot:
Lot 1002. Desk Lamp current bid: $5 minimum bid: $10
1. Add Lot to Auction
2. Start bidding on next Lot
3. Bid on current Lot
4. Mark current Lot Sold
5. Exit
3
How much would you like to bid?
Minimum bid is 10
10
Current Lot:
Lot 1002. Desk Lamp current bid: $10 minimum bid: $15
1. Add Lot to Auction
2. Start bidding on next Lot
3. Bid on current Lot
4. Mark current Lot Sold
5. Exit
2
You must mark the current Lot as sold before bringing up the next Lot
Current Lot:
Lot 1002. Desk Lamp current bid: $10 minimum bid: $15
1. Add Lot to Auction
2. Start bidding on next Lot
3. Bid on current Lot
4. Mark current Lot Sold
5. Exit
4
Lot 1002. Desk Lamp was sold for $10
Current Lot:
Lot 1002. Desk Lamp was sold for $10
1. Add Lot to Auction
2. Start bidding on next Lot
3. Bid on current Lot
4. Mark current Lot Sold
5. Exit
2
Current Lot:
Lot 1003. Gamer Chair, red with armrests. current bid: $100 minimum bid: $110
1. Add Lot to Auction
2. Start bidding on next Lot
3. Bid on current Lot
4. Mark current Lot Sold
5. Exit
3
How much would you like to bid?
Minimum bid is 110
150
Current Lot:
Lot 1003. Gamer Chair, red with armrests. current bid: $150 minimum bid: $160
1. Add Lot to Auction
2. Start bidding on next Lot
3. Bid on current Lot
4. Mark current Lot Sold
5. Exit
3
How much would you like to bid?
Minimum bid is 160
200
Current Lot:
Lot 1003. Gamer Chair, red with armrests. current bid: $200 minimum bid: $210
1. Add Lot to Auction
2. Start bidding on next Lot
3. Bid on current Lot
4. Mark current Lot Sold
5. Exit
3
How much would you like to bid?
Minimum bid is 210
350
Current Lot:
Lot 1003. Gamer Chair, red with armrests current bid: $350 minimum bid: $360
1. Add Lot to Auction
2. Start bidding on next Lot
3. Bid on current Lot
4. Mark current Lot Sold
5. Exit
3
How much would you like to bid?
Minimum bid is 360
300
You must bid at least 360
Current Lot:
Lot 1003. Gamer Chair, red with armrests. current bid: $350 minimum bid: $360
1. Add Lot to Auction
2. Start bidding on next Lot
3. Bid on current Lot
4. Mark current Lot Sold
5. Exit
4
Lot 1003. Gamer Chair, red with armrests. was sold for $350
Current Lot:
Lot 1003. Gamer Chair, red with armrests. was sold for $350
1. Add Lot to Auction
2. Start bidding on next Lot
3. Bid on current Lot
4. Mark current Lot Sold
5. Exit
5
Submitting your answer:
You’ll submit Lot.java or Lot.cs as well as your driver class on gradescope as
assignment 2. Be sure to submit both files as a single submission.
Please follow the posted submission guidelines here:
https://ccse.kennesaw.edu/fye/submissionguidelines.php
Ensure you submit before the deadline listed on the lab schedule for CSE1322L here:
https://ccse.kennesaw.edu/fye/courseschedules.php
 */

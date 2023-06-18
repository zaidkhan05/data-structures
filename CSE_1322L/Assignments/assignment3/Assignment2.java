
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


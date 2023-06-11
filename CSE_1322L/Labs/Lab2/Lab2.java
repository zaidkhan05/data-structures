import java.util.Scanner;
class StockItem{
    private String description;
    private int id;
    private double price;
    private int quantity;
    private static int idCounter = 0;

    public StockItem(){
        this.description = "Unknown Item";
        this.id += idCounter;
        idCounter++;
        this.price = 0.0;
        this.quantity = 0;
    }

    public StockItem(String description, double price, int quantity){
        this.description = description;
        this.id += idCounter;
        idCounter++;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        if(this.id == 0){
            return "Milk: Item number: " + this.id + " is " + this.description + " has price " + this.price + " we currently have " + this.quantity + " in stock";
        }
        else if(this.id == 1){
            return "Bread: Item number: " + this.id + " is " + this.description + " has price " + this.price + " we currently have " + this.quantity + " in stock";
        }
        else
        return  "Item number: " + this.id + " is " + this.description + " has price " + this.price + " we currently have " + this.quantity + " in stock";
    }

    public String getDescription(){
        return this.description;
    }

    public int getId(){
        return this.id;
    }

    public double getPrice(){
        return this.price;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void setPrice(double price){
        if(price < 0){
            System.out.println("Negative price not allowed.");
        }
        else{
            this.price = price;
        }
    }

    public void lowerQuantity(int quantity){
        if(this.quantity - quantity < 0){
            System.out.println("Negative quantity not allowed.");
        }
        else{
            this.quantity -= quantity;
        }
    }

    public void raiseQuantity(int quantity){
        this.quantity += quantity;
    }

    
}

public class Lab2 {
    public static void main(String[] args) {
        StockItem milk = new StockItem("1 Gallon of Milk", 3.60, 15);
        StockItem bread = new StockItem("1 Loaf of Bread", 1.98, 30);
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do{
            System.out.println("1. Sold One Milk");
            System.out.println("2. Sold One Bread");
            System.out.println("3. Change price of Milk");
            System.out.println("4. Change price of Bread");
            System.out.println("5. Add Milk to Inventory");
            System.out.println("6. Add Bread to Inventory");
            System.out.println("7. See Inventory");
            System.out.println("8. Quit");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    milk.lowerQuantity(1);
                    break;
                case 2:
                    bread.lowerQuantity(1);
                    break;
                case 3:
                    System.out.println("What is the new price for Milk");
                    milk.setPrice(sc.nextDouble());
                    break;
                case 4:
                    System.out.println("What is the new price for Bread ");
                    bread.setPrice(sc.nextDouble());
                    break;
                case 5:
                    System.out.println("How much milk did we get?");
                    milk.raiseQuantity(sc.nextInt());
                    break;
                case 6:
                    System.out.println("How many bread did we get?");
                    bread.raiseQuantity(sc.nextInt());
                    break;
                case 7:
                    System.out.println(milk);
                    System.out.println(bread);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }while(choice != 8);
        
    }
}

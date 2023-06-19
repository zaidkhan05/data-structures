
import java.util.ArrayList;
import java.util.Scanner;
abstract class Customer{
    private char letter;
    private int number;
    private static int ACounter = 0;
    private static int BCounter = 0;
    private static int CCounter = 0;
    private static int DCounter = 0;
    private String ticketNumber;
    public Customer(){
        letter = 'X';
        number = 0;
    }
    public Customer(char letter){
        if(letter == 'A'){
            ACounter++;
            this.letter = letter;
            this.number = ACounter;
        }
        else if(letter == 'B'){
            BCounter++;
            this.letter = letter;
            this.number = BCounter;
        }
        else if(letter == 'C'){
            CCounter++;
            this.letter = letter;
            this.number = CCounter;
        }
        else if(letter == 'D'){
            DCounter++;
            this.letter = letter;
            this.number = DCounter;
        }
        else{
            System.out.println("Invalid letter");
        }
    }
    protected String getTicketNumber(){
        ticketNumber = letter + Integer.toString(number);
        return ticketNumber;
    }
    abstract String getCustomerInfo();
}

class NewTest extends Customer{
    private String name;
    private String dateOfBirth;
    public NewTest(String name, String dateOfBirth){
        super('A');
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
    @Override
    public String getCustomerInfo(){
        return "New Drivers License. Ticket Number " + getTicketNumber() + ". Name: " + name + " DOB: " + dateOfBirth;
    }
}

class Renew extends Customer{
    private String name;

    public Renew(String name){
        super('B');
        this.name = name;
    }
    @Override
    public String getCustomerInfo(){
        return "Renewal License. Ticket Number " + getTicketNumber() + ". Name: " + name;
    }
}

class Move extends Customer{
    private String name;
    private String state;
    public Move(String name, String state){
        super('C');
        this.name = name;
        this.state = state;
    }
    @Override
    public String getCustomerInfo(){
        return "Moved from " + state + ". Ticket Number " + getTicketNumber() + ". Name: " + name;
    }
}
class Suspended extends Customer{
    private String name;
    private String violation;
    public Suspended(String name, String violation){
        super('D');
        this.name = name;
        this.violation = violation;
    }
    @Override
    public String getCustomerInfo(){
        return "Violation: " + violation + ". Ticket Number " + getTicketNumber() + ". Name: " + name;
    }
}
public class Assignment3{
    static void menu(ArrayList<Customer> customers){
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        String name;
        while(choice != 6){
            System.out.println("1. Take test for new license\n" + 
                    "2. Renew existing license\n" + 
                    "3. Move from out of state\n" + 
                    "4. Answer citation/suspended license\n" + 
                    "5. See current queue\n" + 
                    "6. Quit");
            
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("What is your name? ");
                    name = sc.nextLine();
                    System.out.println("What is your date of birth? ");
                    String dateOfBirth = sc.nextLine();
                    NewTest newTest = new NewTest(name, dateOfBirth);
                    customers.add(newTest);
                    
                    break;
                case 2:
                    System.out.println("What is your name? ");
                    name = sc.nextLine();
                    Renew renew = new Renew(name);
                    customers.add(renew);
                    
                    break;
                case 3:
                    System.out.println("What is your name? ");
                    name = sc.nextLine();
                    System.out.println("What state did you move from? ");
                    String state = sc.nextLine();
                    Move move = new Move(name, state);
                    customers.add(move);
                    
                    break;
                case 4:
                    System.out.println("What is your name? ");
                    name = sc.nextLine();
                    System.out.println("What violation did you commit? ");
                    String violation = sc.nextLine();
                    Suspended suspended = new Suspended(name, violation);
                    customers.add(suspended);
                    
                    break;
                case 5:
                    for(int i = 0; i < customers.size(); i++){
                        System.out.println(customers.get(i).getCustomerInfo());
                    }
                    
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice");
                    
                    break;
            }
        }
        sc.close();
    }

    public static void main(String[] args){
        //e
        ArrayList<Customer> customers = new ArrayList<Customer>();
        menu(customers);

        
    }
}

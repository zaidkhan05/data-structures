import java.util.Scanner;
class account{
    private int account_number = 10001;
    private double account_balance;
    static int account_counter = 0;
    public account(){
        account_number += account_counter;
        account_counter++;
        account_balance = 0;
    }
    public account(int account_number, double account_balance){
        this.account_number += account_counter;
        account_counter++;
        this.account_balance = account_balance;
    }
    int getAccount_number(){
        return account_number;
    }
    double getAccount_balance(){
        return account_balance;
    }
    void setAccount_balance(double account_balance){
        this.account_balance = account_balance;
    }
    void withdraw(double amount){
        account_balance -= amount;
    }
    void deposit(double amount){
        account_balance += amount;
    }
    void interest(){

    }

}
class checking extends account{
    checking(){
        super();
    }
    checking(double account_balance){
        super();
        setAccount_balance(account_balance);
    }
    void withdraw(double amount){
        super.withdraw(amount);
        if(getAccount_balance() < 0){
            System.out.println("Charging an overdraft fee of $20 because account is below $0”");
            super.withdraw(20);
        }

    }
}

class savings extends account{
    private static int deposit_counter = 0;
    savings(){
        super();
    }
    savings(double account_balance){
        super();
        setAccount_balance(account_balance);
    }
    void withdraw(double amount){
        if(getAccount_balance() < 500){
            System.out.println("Charging a fee of $10");
            super.withdraw(amount+10);
        }
        else{
            super.withdraw(amount);
        }
        
    }
    void deposit(double amount){
        deposit_counter++;
        System.out.println("This is deposit number " + deposit_counter + " to this account");
        if(deposit_counter > 5){
            System.out.println("Charging a fee of $10");
            super.withdraw(10);
            super.deposit(amount);
        }
        else{
            super.deposit(amount);
        }
    }
    void interest(){
        double interestamount = getAccount_balance() * 0.015;
        System.out.println("Customer earned " + interestamount + " in interest");
        super.deposit(interestamount);
    }
}

public class Lab4 {
   
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        savings save = new savings();
        checking check = new checking();
        int choice = 0;
        double amount = 0;
        while(choice != 8){
            System.out.println("1. Withdraw from Checking\r\n" +
                    "2. Withdraw from Savings\r\n" +
                    "3. Deposit to Checking\r\n" +
                    "4. Deposit to Savings\r\n" +
                    "5. Balance of Checking\r\n" + 
                    "6. Balance of Savings\r\n" +
                    "7. Award Interest to Savings now\r\n" +
                    "8. Quit");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("How much would you like to withdraw from Checking?");
                    amount = sc.nextDouble();
                    check.withdraw(amount);
                    break;
                case 2:
                    System.out.println("How much would you like to withdraw from Savings?");
                    amount = sc.nextDouble();
                    save.withdraw(amount);
                    break;
                case 3:
                    System.out.println("How much would you like to deposit to Checking?");
                    amount = sc.nextDouble();
                    check.deposit(amount);
                    break;
                case 4:
                    System.out.println("How much would you like to deposit to Savings?");
                    amount = sc.nextDouble();
                    save.deposit(amount);
                    break;
                case 5:
                    System.out.println("Your balance for checking " + check.getAccount_number() + " is " + check.getAccount_balance());
                    break;
                case 6:
                    System.out.println("Your balance for saving " + save.getAccount_number() + " is " + save.getAccount_balance());
                    break;
                case 7:
                    save.interest();
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

    }
}


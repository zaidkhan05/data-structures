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


/*
CSE1322L - Lab 4
Concept Summary:
1. Inheritance
2. Over-riding methods
3. Instantiating objects
4. Fundamental Class Concepts.
5. Using your IDE to generate UML diagrams.
Objective:
In this lab, you’ll be creating software for the world's smallest bank. This bank can have only one
customer. The customer will have a checking account and a savings account. The account types have
some specific rules:
Checking Accounts:
- Allows unlimited deposits and withdrawals for free.
- Provides no interest payments.
- If the account balance ever drops below $0, the customer is charged a $20 overdraft fee.
Saving Accounts:
- Must maintain a $500 balance at all times, otherwise the customer is charged $10 each time they
make a withdrawal that lowers their balance below $500.
- Earns 1.5% interest every year
- The first 5 deposits are free, after that there is a fee of $10 per deposit.
You’ll provide the bank teller with a simple menu which will allow them to make changes to their
customer’s accounts.
You’ll use your IDE to generate UML diagrams of your classes. See UML section below.
Account Numbers:
Each account will have an account number. You should use a static variable to keep track of the next
account number. At the start set this number to 10001.
In your driver you’ll create a Checking account, and a Savings account. The checking account will end
up with a account_number of 10001, while the Savings account will end up with an account_number of
10002.
Classes:
● Create a class called “Account”. This will hold things that are true for all account types. Be sure
to include at least:
○ An attribute which will hold the account number.
○ An attribute which will hold the account balance. (e.g. $500.22)
○ A constructor method which opens the account with a balance of 0.
■ It should set the account number using the static variable described above.
○ An overloaded constructor which opens the account with a specific amount which is
passed to the constructor.
■ It should set the account number using the static variable described above.
○ Getter method for accessing the account_number.
○ Getter/Setter method for accessing the account balance.
○ A withdrawal method which takes a parameter of the amount to be withdrawn and
deducts it from the balance.
○ A deposit method which takes a parameter of the amount to be deposited and adds it to
the balance.
● Create a class called “Checking” which should inherit from Account.
○ You will need an appropriate constructor to set the account balance.
○ Modify the withdrawal method you inherited to check for the condition where they try to
overdraft their account.
■ If an overdraft condition occurs you should print out “Charging an overdraft fee
of $20 because account is below $0”
■ Deduct $20 from their balance.
● Create a class called “Savings” which should inherit from Account.
○ You will need an appropriate constructor to set the account balance.
○ Modify the withdrawal method so it implements the rules about dropping below $500
■ If they drop below $500, you should print “Charging a fee of $10 because you are
below $500”
■ Deduct $10 from their balance.
○ Modify the deposit method so it implements the charge for more than 5 deposits.
■ As you do the deposit you should print “This is deposit 1 to this account”, where
1 would be updated to reflect what number deposit this is.
■ If you are doing the 6th or later deposit, print “Charging a fee of $10”, and deduct
$10 from their balance.
○ Add a method which adds 1.5% interest to the account. (This method will be called by
the teller manually once per year).
■ Print out how much the customer earned in interest as follows “Customer earned
15.25 in interest”. Of course it should reflect the actual amount.
■ Add the interest earned to their balance.
All classes should be created with appropriate encapsulation. i.e. account balances and account
numbers should be private and only accessible via getters/setters.
Don’t worry if the formatting of the dollar figures. Ie, sometimes the interest will be 2.585828225
and that’s ok. Likewise sometimes the balance will be 100.5 and that’s ok for this lab.
Driver:
Create a driver class which creates a checking and savings account. Then keep prompting the user with
the following menu until they quit:
1. Withdraw from Checking
2. Withdraw from Savings
3. Deposit to Checking
4. Deposit to Savings
5. Balance of Checking
6. Balance of Savings
7. Award Interest to Savings now
8. Quit
Each menu choice should prompt the user as appropriate to do what it says. i.e. if the user selects
Deposit to Checking, they should be prompted for the amount. See sample output below.
 */
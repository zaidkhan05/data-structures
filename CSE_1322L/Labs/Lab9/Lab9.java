import java.util.Scanner;

public class Lab9 {
   
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while(true){
            System.out.println("0 - Exit");
            System.out.println("1 - Addition");
            System.out.println("2 - Subtraction");
            System.out.println("3 - Multiplication");
            System.out.println("4 - Division");
            System.out.println("Please Choose an Option: ");
            choice = sc.nextInt();
            if(choice == 0){
                break;
            }
            System.out.println("Please enter the first number ");
            float a = sc.nextFloat();
            System.out.println("Please enter the second number ");
            float b = sc.nextFloat();
            Calculator calc = new Calculator();
            switch(choice){
                case 1:
                    System.out.println(calc.add(a, b));
                    break;
                case 2:
                    System.out.println(calc.subtract(a, b));
                    break;
                case 3:
                    System.out.println(calc.multiply(a, b));
                    break;
                case 4:
                    System.out.println(calc.divide(a, b));
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}

/*
CSE1322L - Lab 7
Concept Summary:
1. Object-Oriented programming concepts
2. Interfaces
For this project you will develop a calculator that can do simple arithmetic operations such as
addition, subtraction, multiplication and division.
You’ll begin by creating an interface CalcOp which has 4 methods: add(), subtract(),
multiply() and divide().
Next you’ll create a Calculator class which implements the interface. This class should be
concrete, as such all methods should be concrete.
Finally you’ll write a main method which instantiates a calculator, and presents the user with
a menu. Prompt the user for 2 numbers and perform the appropriate operation based on their
choice. Continue until the user chooses to exit.
Specifications:
The CalcOp interface should include the following items:
• Four methods: add( ), subtract( ), multiply( ) and divide( )
• Each method should take in two floating point numbers and return a float.
The Calculator class should:
● Implement the methods defined in the interface.
Write a driver program which contains the following items:
● A menu with options for exiting the program, addition, subtraction, multiplication and
division.
● All Input / Output statements should be in the driver program only.
Test your program by running through all operations at least once.
Sample Output:
0 - Exit
1 - Addition
2 - Subtraction
3 - Multiplication
4 - Division
Please Choose an Option: 1
Please enter the first number 67
Please enter the second number 89
156.0
0 - Exit
1 - Addition
2 - Subtraction
3 - Multiplication
4 - Division
Please Choose an Option: 2
Please enter the first number 90
Please enter the second number 89
1.0
0 - Exit
1 - Addition
2 - Subtraction
3 - Multiplication
4 - Division
Please Choose an Option: 3
Please enter the first number 65
Please enter the second number 12
780.0
0 - Exit
1 - Addition
2 - Subtraction
3 - Multiplication
4 - Division
Please Choose an Option: 4
Please enter the first number 18
Please enter the second number 2
9.0
0 - Exit
1 - Addition
2 - Subtraction
3 - Multiplication
4 - Division
Please Choose an Option: 0
 */
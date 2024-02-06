import java.util.Scanner;




public class quiz {

    public static void main(String[] args) {
        //create a scanner
        Scanner sc = new Scanner(System.in);
        //create a boolean to check if the user wants to quit
        boolean quit = false;
        //create a while loop to keep the program running
        while(!quit){
            System.out.println("1. Write something to the screen");
            System.out.println("2. add 2 numbers together");
            System.out.println("3. Print out a list of numbers from 1 to 10");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            //read the input from the user
            int choice = sc.nextInt();
            //create a switch statement to check the user input
            switch(choice){
                case 1:
                    System.out.println("What would you like to write? ");
                    sc.nextLine();
                    String input = sc.nextLine();
                    System.out.println(input);
                    break;
                case 2:
                    System.out.println("Enter the first number: ");
                    int num1 = sc.nextInt();
                    System.out.println("Enter the second number: ");
                    int num2 = sc.nextInt();
                    System.out.println("The sum of the two numbers is " + (num1 + num2));
                    break;
                case 3:
                    for(int i = 1; i <= 10; i++){
                        System.out.print(i + " ");
                    }
                    System.out.println();
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            
        }
        //close the scanner
        sc.close();
    }
    
}

/*
Let's do something fun.  Write a Java program that uses a simple menu to read in the user input from the screen and write it back out to the screen.  You may NOT use the Java Menu Library options.  Write this yourself.

Here's the algorithm

Declare your imports
Create your public class and main method
Declare needed variables
Create menu options (with option to Quit)
Ask user to make choice and read input from keyboard
While user input is valid, perform task specified - write something to screen
If user input is invalid, write message notifying invalid input
Stop the program when user enters quit option
 */
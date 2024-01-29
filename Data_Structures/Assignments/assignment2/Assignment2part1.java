// Name:	Zaid Khan
// Class:	CS 3305/W04
// Term:	Spring 2024
// Instructor:  Carla McManus
// Assignment:  2 – Part 1 Factorial
// IDE:  Visual Studio Code - Insiders

import java.util.Scanner;

//main class
public class Assignment2part1 {
  //factorial method
  public static int factorial(int f){
    //if f is 0 or 1 return 1
    if(f == 0 || f == 1){
      return 1;
    }
    //else return f * factorial(f-1)
    else{
      return f * factorial(f-1);
    }
  }
  //main method
  public static void main(String[] args) {
    //e
    System.out.print("Enter a nonnegative integer:  ");
    //input
    Scanner sc = new Scanner(System.in);
    int x = sc.nextInt();
    int y = factorial(x);
    sc.close();
    System.out.println("The factorial of " + x + " is " + y);

  }
}

/*
Write out the logic / pseudo code to compute the factorial of n, customarily denoted as n!

It is important to use correct recursion terminology in your pseudo code.

Next, use your pseudo code as the basis for writing a complete, well documented program. Your program should prompt the user to enter a nonnegative number and then display the factorial for that number. 
Your program must contain a function called factorial. Function factorial calculates the factorial of a number. Sample output is included below.

 */
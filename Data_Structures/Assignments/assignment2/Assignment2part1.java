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
  public static int factorial(int n){
    //if f is 0 or 1 return 1
    if(n == 0 || n == 1){
      return 1;
    }
    //else return f * factorial(f-1), because factorial is n * n-1 * n-2 * n-3 * ... * 1
    else{
      return n * factorial(n-1);
    }
  }
  //main method
  public static void main(String[] args) {
    //e
    System.out.print("Enter a nonnegative integer:  ");
    //input
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    //call the factorial method with the input as a parameter and put it in a variable
    int y = factorial(n);
    sc.close();//intellij is fine without this but vscode gives me errors so its here
    System.out.println("The factorial of " + n + " is " + y);

  }
}

/*
Psuedocode:
  factorial method
  factorial(f)
    if f is 0 or 1 return 1
    else return f * factorial(f-1)

  main
    ask for input
    put input into a variable
    call factorial method with input as parameter and put it in another variable
    print out the factorial as the output

*/
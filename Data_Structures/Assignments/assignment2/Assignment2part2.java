// Name:	Zaid Khan
// Class:	CS 3305/W04
// Term:	Spring 2024
// Instructor:  Carla McManus
// Assignment:  2 – Part 2 Recursion
// IDE:  Visual Studio Code - Insiders

import java.util.Scanner;

//main class
public class Assignment2part2 {
  //recursive function
  public static void recursiveCall(int num, int target){
    //if num is 0 return
    if(num > target){
      return;
    }
    
    //else print out the recursive call
    else{
      //set up for the tabs
      String tabs = "";
      for(int i = 1; i < num; i++){
        tabs += "  ";
      }
      //recursive call
      // recursiveCall(num - 1);
      //print out the recursive call

      System.out.println(tabs +"This was written by call number " + num + ".");
      recursiveCall(num+1, target);
      System.out.println(tabs +"This was ALSO written by call number " + num + ".");
      
      //this needs to start at one and then count to the input
      //then it needs to count back down to one
    }


  }
  //main method
  public static void main(String[] args) {
    //e
    System.out.print("Enter a nonnegative integer:  ");
    //input
    Scanner sc = new Scanner(System.in);
    int target = sc.nextInt();
    sc.close();
    recursiveCall(1, target);

  }
}

/*

Write a complete, well documented program, that prompts the user for input and tests a recursive function. You will write a function that implements recursion and produces the following output:

//	Sample below is for input of 4:
//	Note: indentions are required for credit.

//	Expected Output

This was written by call number 1.
  This was written by call number 2.
    This was written by call number 3.
      This was written by call number 4.
      This was ALSO written by call number 4.
    This was ALSO written by call number 3.
  This was ALSO written by call number 2.
This was ALSO written by call number 1.

In this example, the recursion stopped when it reached four levels deep (because 4 was input), but your program should be capable of continuing to any specified level.


 */
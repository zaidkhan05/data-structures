// Name:	Zaid Khan
// Class:	CS 3305/W04
// Term:	Spring 2024
// Instructor:  Carla McManus
// Assignment:  2 – Part 2 Recursion
// IDE:  Visual Studio Code - Insiders

import java.util.Scanner;


public class Assignment2part2 {

  public static void recursiveCall(int num, int target){
    //checks for the values to make sure the target is not exceeded(standard recursion)
    if(num > target){
      return;
    }

    else{
      //helps for printing out the indents
      String tabs = "";
      for(int i = 1; i < num; i++){
        tabs += "  ";
      }
      //prints out the statements
      System.out.println(tabs +"This was written by call number " + num + ".");
      //calls the method again with num+1 replacing the first parameter, 
      //with the target staying the same so the recursion stops when it reaches the target, 
      //so it can start at 1 normally and print out the other statements to complete the "arrow" shape
      recursiveCall(num+1, target);
      System.out.println(tabs +"This was ALSO written by call number " + num + ".");
  
    }


  }
  //main method
  public static void main(String[] args) {
    //e
    System.out.print("Enter a nonnegative integer:  ");
    Scanner sc = new Scanner(System.in);
    int target = sc.nextInt();
    sc.close();
    recursiveCall(1, target);

  }
}

/*
psuedocode:
  recursiveCall method with 2 parameters, num and target
    if num > target
      return
    else
      print out "This was written by call number " + num + "."
      call recursiveCall(num+1, target)
      print out "This was ALSO written by call number " + num + "."
  main
    ask for input
    put input into a variable
    call recursiveCall method with 1 and the input as parameters
    
    
    1 is the first call number so that it starts, until it reaches the target that we input

 */
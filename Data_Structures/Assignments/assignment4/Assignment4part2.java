// Name:	Zaid Khan
// Class:	CS 3305/W04
// Term:	Spring 2024
// Instructor:  Carla McManus
// Assignment:  04-Part-2-Palindromes
// IDE:  vscode

//Stack class
import java.util.Scanner;

//stack class
//calling it smth else cuz its being used in the other file and breaking it :)
class Stacker {
  //variables
  int top;
  int size;
  char[] arr;

  //constructor
  public Stacker(int size) {
    this.size = size;
    arr = new char[size];
    top = -1;
  }

  //push method
  public void push(char x) {
    if (top < size - 1) {
      arr[++top] = x;
    } else {
      System.out.println("Stack is full");
    }
  }

  //pop method
  public char pop() {
    if (top >= 0) {
      return arr[top--];
    } else {
      System.out.println("Stack is empty");
      return ' ';
    }
  }

  //check if stack is empty
  public boolean isEmpty() {
    return (top < 0);
  }
}




//main class
public class Assignment4part2 {
  //main method
  public static void main(String[] args) {
    //e
    Scanner sc = new Scanner(System.in);
    //prompt user
    System.out.println("Enter a string to check if it is a palindrome: ");
    String input = sc.nextLine();
    //create stack
    Stacker stack1 = new Stacker(input.length());
    Stacker stack2 = new Stacker(input.length());
    Stacker stack3 = new Stacker(input.length());
    //push string onto stack
    for (int i = 0; i < input.length(); i++) {
      System.out.println(input.charAt(i));
      stack1.push(input.charAt(i));
      stack2.push(input.charAt(i));
    }
    //pop stack 1 and push onto stack 3
    while (!stack1.isEmpty()) {
      stack3.push(stack1.pop());
    }
    //compare stack 2 and stack 3
    boolean isPalindrome = true;
    while (!stack2.isEmpty()) {
      if (stack2.pop() != stack3.pop()) {
        isPalindrome = false;
        break;
      }
    }
    //print result
    if (isPalindrome) {
      System.out.println(input + " is a palindrome");
    } else {
      System.out.println(input + " is not a palindrome");
    }
    sc.close();


  }
}


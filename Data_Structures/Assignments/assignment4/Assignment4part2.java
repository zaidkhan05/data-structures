// Name:	Zaid Khan
// Class:	CS 3305/W04
// Term:	Spring 2024
// Instructor:  Carla McManus
// Assignment:  04-Part-2-Palindromes
// IDE:  vscode

//Stack class
import java.util.Scanner;

//normal stack class
class Stack {
  //variables
  int top;
  int size;
  char[] arr;

  //constructor
  public Stack(int size) {
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
    Stack stack1 = new Stack(input.length());
    Stack stack2 = new Stack(input.length());
    Stack stack3 = new Stack(input.length());
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

/*
In this part, you will use stacks to recognize palindromes. 
Palindromes are strings that read the same backward as forward (for example “madam”). 
Write a program to read a line in from the keyboard and print to the display, whether or not it is a palindrome. 
You MUST use three stacks to implement the program. For simplicity use only lower case letters in your test strings. 
You may use the stack class from Java for Part 2.
 
Use the following logic
1.	Push original string onto Stack_1 and also Stack_2
2.	Pop Stack_1 and push onto Stack_3 until Stack_1 is empty
3.	At this point Stack_2 is the original string and Stack_3 is the reverse
4.	Compare Stack_2 and Stack_3 using dot =
5.	If Stack_2 is equal to Stack_3 the string is a palindrome

Test your string by entering data from the keyboard and writing out to the screen whether the string is a palindrome.



 */
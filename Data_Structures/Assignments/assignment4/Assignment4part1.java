// Name:	Zaid Khan
// Class:	CS 3305/W04
// Term:	Spring 2024
// Instructor:  Carla McManus
// Assignment:  04-Part-1-Stacks
// IDE:  vscode

//importing scanner
import java.util.Scanner;

//Stack class
class Stack {
  //variables
  int topA, topB;
  int size;
  int[] arr;

  //constructor
  public Stack(int size) {
    this.size = (size*2);
    size = this.size;
    arr = new int[size];
    topA = -1;
    topB = size;
  }

  //push method for stack A
  public void pushA(int x) {
    if (topA < topB - 1) {
      arr[++topA] = x;
    } else {
      System.out.println("Stack A is full");
    }
  }

  //push method for stack B
  public void pushB(int x) {
    if (topA < topB - 1) {
      arr[--topB] = x;
    } else {
      System.out.println("Stack B is full");
    }
  }

  //pop method for stack A
  public int popA() {
    if (topA >= 0) {
      return arr[topA--];
    } else {
      System.out.println("Stack A is empty");
      return -1;
    }
  }

  //pop method for stack B
  public int popB() {
    if (topB < size) {
      return arr[topB++];
    } else {
      System.out.println("Stack B is empty");
      return -1;
    }
  }

  //is empty method for stack A
  public boolean isEmptyA() {
    return topA == -1;
  }

  //is empty method for stack B
  public boolean isEmptyB() {
    return topB == size;
  }

  //is full method
  public boolean isFull() {
    return topA == topB - 1;
  }
  public static void main(String[] args) {
    //e
    Scanner sc = new Scanner(System.in);
    //get stack size
    System.out.println("Enter the size of the stacks: ");
    int size = sc.nextInt();
    Stack stack = new Stack(size);
    //prompt user for elements for first stack
    System.out.println("Enter the elements for stack A: ");
    for (int i = 0; i < size; i++) {
      stack.pushA(sc.nextInt());
    }
    //prompt user for elements for second stack
    System.out.println("Enter the elements for stack B: ");
    for (int i = 0; i < size; i++) {
      stack.pushB(sc.nextInt());
    }
    //pop elements from stack A and print them
    System.out.println("Popping elements from stack A: ");
    while (!stack.isEmptyA()) {
      System.out.println(stack.popA());
    }
    //pop elements from stack B and print them
    System.out.println("Popping elements from stack B: ");
    while (!stack.isEmptyB()) {
      System.out.println(stack.popB());
    }

    
  }
} 
//pseudocode
//create stack class
//create variables
//create constructor
//create push method for stack A
//create push method for stack B
//create pop method for stack A
//create pop method for stack B
//create is empty method for stack A
//create is empty method for stack B
//create is full method
//create main method
//create scanner object
//prompt user for stack size
//create stack object
//prompt user for elements for first stack
//push elements onto stack A
//prompt user for elements for second stack
//push elements onto stack B
//pop elements from stack A and print them
//pop elements from stack B and print them

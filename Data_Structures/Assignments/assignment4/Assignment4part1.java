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
    System.out.println("Enter the size of the stack: ");
    int size = sc.nextInt();
    Stack stack = new Stack(size);
    System.out.println("Enter the elements for stack A: ");
    for (int i = 0; i < size; i++) {
      stack.pushA(sc.nextInt());
    }
    System.out.println("Enter the elements for stack B: ");
    for (int i = 0; i < size; i++) {
      stack.pushB(sc.nextInt());
    }
    System.out.println("Popping elements from stack A: ");
    while (!stack.isEmptyA()) {
      System.out.println(stack.popA());
    }
    System.out.println("Popping elements from stack B: ");
    while (!stack.isEmptyB()) {
      System.out.println(stack.popB());
    }

    
  }
} 

// //main class
// public class Assignment4part1 {
//   //main method
  
// }


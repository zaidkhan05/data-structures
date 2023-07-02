
import java.util.Scanner;

public class Lab8a{
    static int recursive_multiply(int x, int y){
        if(y == 0){
            return 0;
        }
        else{
            return x + recursive_multiply(x, y-1);
        }
    }
    static int recursive_div(int x, int y){
        if(y == 0){
            return -1;
        }
        else if(x < y){
            return 0;
        }
        else if(x == y){
            return 1;
        }
        else{
            return 1 + recursive_div(x-y, y);
        }
    }
    static int recursive_mod(int x, int y){
        if(y == 0){
            return -1;
        }
        else if(x < y){
            return x;
        }
        // else if(x == y){
        //     return 0;
        // }
        else{
            return recursive_mod(x-y, y);
        }
    }
    public static void main(String[] args){
        //e
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do{
            System.out.println("Choose from the following:");
            System.out.println("0. Quit\n" + 
                    "1. Multiply 2 numbers\n" + 
                    "2. Div 2 numbers\n" + 
                    "3. Mod 2 numbers");
            choice = sc.nextInt();
            switch(choice){
                case 0:
                    break;
                case 1:
                    System.out.println("Enter first number");
                    int x = sc.nextInt();
                    System.out.println("Enter second number");
                    int y = sc.nextInt();
                    System.out.println("Answer: " + recursive_multiply(x, y));
                    break;
                case 2:
                    System.out.println("Enter first number");
                    x = sc.nextInt();
                    System.out.println("Enter second number");
                    y = sc.nextInt();
                    System.out.println("Answer: " + recursive_div(x, y));
                    break;
                case 3:
                    System.out.println("Enter first number");
                    x = sc.nextInt();
                    System.out.println("Enter second number");
                    y = sc.nextInt();
                    System.out.println("Answer: " + recursive_mod(x, y));
                    break;
            }
        }while(choice != 0);

    }
}

/*
Lab 8A Tasks
You’ll need to write 3 methods, all of which must use recursion:
1) Write recursive_multiply. It should take in 2 integers and return an integer.
Another way to say multiply 5*4, is 5+(5*3), or 5+5+(5*2), or 5+5+5+(5*1), or
5+5+5+5+(5*0). You know that any number multiplied by 0 is 0.
2) Write recursive_div. It should take in 2 integers and return an integer. Unlike regular
division, div just returns the integer portion of division. It answers the question “how
many times does the second number go into the first number”. So, 7 div 3 = 2, because 3
goes in 2 times, the leftover is irrelevant to div.
If you are asked to divide anything by 0, you should return -1, as that’s an error.
If you are asked to divide anything by itself, you should return 1. i.e. 7 div 7 = 1
If you are asked to divide a small number by a bigger one, the answer is 0. i.e. 2 div 7 = 0
For all other numbers, you’ll keep subtracting the second number from the first number,
until the first number is less than the second. You’ll count how many times this happens,
and return that count. Remember you must use recursion in all 3 of these methods.
3) Write recursive_mod. It should take in 2 integers and return an integer. Mod only cares
about the remainder of division.
If you are asked to divide anything by 0, it should return -1, as that’s an error.
If you are asked to divide any smaller number by a larger number, you should return the
smaller number. i.e. 2 mod 3 = 2
For all other cases, you’ll keep subtracting the second number from the first.
For example: 7 mod 3:
7-3 = 4
4-3 = 1
Answer is 1.
4) Finally, write the main method, which prompts the user to either multiply, div, or mod.
Then prompt the user for 2 numbers, call the appropriate method, receive a result, and
print it out.
Continue to ask the user (you may use a loop here) until they choose 0 to quit.
Lab 8A Sample Output:
Choose from the following:
0. Quit
1. Multiply 2 numbers
2. Div 2 numbers
3. Mod 2 numbers
1
Enter first number
3
Enter second number
5
Answer: 15
Choose from the following:
0. Quit
1. Multiply 2 numbers
2. Div 2 numbers
3. Mod 2 numbers
1
Enter first number
5
Enter second number
0
Answer: 0
Choose from the following:
0. Quit
1. Multiply 2 numbers
2. Div 2 numbers
3. Mod 2 numbers
2
Enter first number
15
Enter second number
5
Answer: 3
Choose from the following:
0. Quit
1. Multiply 2 numbers
2. Div 2 numbers
3. Mod 2 numbers
2
Enter first number
15
Enter second number
2
Answer: 7
Choose from the following:
0. Quit
1. Multiply 2 numbers
2. Div 2 numbers
3. Mod 2 numbers
2
Enter first number
15
Enter second number
0
Answer: -1
Choose from the following:
0. Quit
1. Multiply 2 numbers
2. Div 2 numbers
3. Mod 2 numbers
2
Enter first number
2
Enter second number
10
Answer: 0
Choose from the following:
0. Quit
1. Multiply 2 numbers
2. Div 2 numbers
3. Mod 2 numbers
3
Enter first number
7
Enter second number
2
Answer: 1
Choose from the following:
0. Quit
1. Multiply 2 numbers
2. Div 2 numbers
3. Mod 2 numbers
3
Enter first number
10
Enter second number
3
Answer: 1
Choose from the following:
0. Quit
1. Multiply 2 numbers
2. Div 2 numbers
3. Mod 2 numbers
3
Enter first number
10
Enter second number
0
Answer: -1
Choose from the following:
0. Quit
1. Multiply 2 numbers
2. Div 2 numbers
3. Mod 2 numbers
0

 */
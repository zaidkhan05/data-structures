
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

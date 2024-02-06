import java.util.Scanner;



public class quiz {

    public static int sumDigits(long n){
        if(n == 0){
        return 0;
        }
        
        else{
            //cast long to int because the return type is int
            //n % 10 gets the last digit of the number
            //n/10 gets rid of the last digit
            //then it adds the last digit to the sum of the rest of the digits
            return (int)(n % 10) + sumDigits(n/10);
        }
    }
    public static void main(String[] args) {
        System.out.print("Enter an integer:  ");
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println("The sum of the digits in " + n + " is " + sumDigits(n));
        sc.close();
    }
    
}

/*
Write a class with a main method  [test program] that prompts the user to enter an integer and displays the sum of all the integers in that number.  You must write a recursive method that computes the sum of the digits in an integer and use the following method header:

        public static int sumDigits(long n)

Example

        sumDigits(234) returns 2 + 3 + 4 = 9. 
 */
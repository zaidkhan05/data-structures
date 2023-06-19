import java.util.Scanner;
interface FindFib{
    public int calculate_fib(int n);
}

class FibIteration implements FindFib{
    public int calculate_fib(int n){
        int result = 1;
        if(n == 1 || n == 2){
            return result;
        }
        int prevnum = 1;
        for(int i = 2; i < n; i++){
            int temp = result;
            result += prevnum;
            prevnum = temp;
        }
        return result;
    }
}

class FilFormula implements FindFib{
    public int calculate_fib(int n){
        double result = (Math.pow((1 + Math.sqrt(5)) / 2, n) - Math.pow((1 - Math.sqrt(5)) / 2, n)) / Math.sqrt(5);
        return (int)result;
    }
}
public class Lab6 {
   
    public static void main(String[] Args){
        System.out.println("Enter the number you want to find the Fibonacci Series for:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        FibIteration fibiteration = new FibIteration();
        FilFormula fibformula = new FilFormula();
        System.out.println("Fib of " + n + " by iteration is: " + fibiteration.calculate_fib(n));
        System.out.println("Fib of " + n + " by formula is: " + fibformula.calculate_fib(n));
    }
}

import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.*;


public class quiz {

    void printStar(int n){
        if(n == 0){
            return;
        }
        System.out.print("*");
        printStar(n-1);
    }

    static int count = 0;

    public static int f(int n){
        count++;
        if(n == 0){
            return 0;
        }
        else{
            return f(n-1) + n*n;
        }
    }
    public static void main(String[] args) {
        f(7);
        System.out.println(count);
        ArrayList<Integer> arr = new ArrayList<>();
        Collections.sort(arr);

        
            
        
    }
    
}

/*
Write a recursive method printStar(int n) that displays n stars on same line.

 */
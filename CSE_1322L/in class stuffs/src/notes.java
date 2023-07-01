// static meaning:
// global shared variable, if its changed its changed for everything

// arraylist: dynamic dimensional arrays, indexed at zero

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class notes{
    public static void dowork(int x){
        System.out.print(x);
        if(x>2){
            dowork(x-1);
            dowork(x-2);
        }
        System.out.print(x);
        
    }
        public static int calculate_fib_recursive(int n){

        if(n == 1 || n == 2){
            return n-1;
        }
        else{
            return calculate_fib_recursive(n-1) + calculate_fib_recursive(n-2);
        }
    }
    public static String reverseStringRecursive(String str){
        if(str.length() <= 0){
            return str.substring(0);
        }
        else{
            return reverseStringRecursive(str.substring(1)) + str.substring(0);
        }
    }

    public static void main(String [] args){
        // dowork(4);
        String s = "hello";
        s.substring(1);
        System.out.println(reverseStringRecursive(s));
        // System.out.println("enter number to be factorialed");
        // Scanner sc = new Scanner(System.in);
        // int x = sc.nextInt();
        // int result = factorialRecursive(x);
        // System.out.println(result);

        // ArrayList<Double> myArrayList = new ArrayList<Double>();
        // for(int i = 0; i < 10; i++){
        //     myArrayList.add(Math.random());
        // }

        // for (Double i : myArrayList) {
        //     System.out.println(myArrayList.indexOf(i));
        // }
        // int[] countedValues = {0,0,1,1,1,0,0,0,0,0,0,0,1,1};
        // int timesLooped = 0;
        // int count = 0;
        // for(int i = 0; i < countedValues.length; i++){
            
        //     if(timesLooped == 2){
        //         System.out.println("breakloop");
        //         break;
        //     }
        //     if(i == 13 && count < 5 && count != 0){
        //         count++;
        //         timesLooped++;
        //         i = 0;
        //     }
        //     else if(countedValues[i] == 1){
        //         count++;
        //     }
            
        //     else{
        //         count = 0;
        //     }
            
        //     if(count == 5){
        //         System.out.println("Straight");
        //     }
        // }
        // System.out.println("out of loop");
        //}
        // float x = 3428593489165384l;
        // String y = toString(x);
        // Iterator iter = x.iterator();
        // while(iter.hasNext()){
        //     System.out.println(iter.next());
        // }

    }
}
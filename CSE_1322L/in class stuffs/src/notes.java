// static meaning:
// global shared variable, if its changed its changed for everything

// arraylist: dynamic dimensional arrays, indexed at zero

import java.util.ArrayList;
import java.util.*;
public class notes{
    public static void main(String [] args){
        // ArrayList<Double> myArrayList = new ArrayList<Double>();
        // for(int i = 0; i < 10; i++){
        //     myArrayList.add(Math.random());
        // }

        // for (Double i : myArrayList) {
        //     System.out.println(myArrayList.indexOf(i));
        // }
        int[] countedValues = {0,0,1,1,1,0,0,0,0,0,0,0,1,1};
        int timesLooped = 0;
        int count = 0;
        for(int i = 0; i < countedValues.length; i++){
            
            if(timesLooped == 2){
                System.out.println("breakloop");
                break;
            }
            if(i == 13 && count < 5 && count != 0){
                count++;
                timesLooped++;
                i = 0;
            }
            else if(countedValues[i] == 1){
                count++;
            }
            
            else{
                count = 0;
            }
            
            if(count == 5){
                System.out.println("Straight");
            }
        }
        System.out.println("out of loop");
        //}
        // Iterator iter = myArrayList.iterator();
        // while(iter.hasNext()){
        //     System.out.println(iter.next());
        // }

    }
}
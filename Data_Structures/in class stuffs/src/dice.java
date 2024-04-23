import java.util.*;

public class dice {
    int sides;
    int[] value;
    ArrayList<dice> die = new ArrayList<dice>();
    dice(int sides){
        this.sides = sides;
        this.value = new int[sides];
        reset();
        die.add(this);
    }
    public int roll(){
        return value[(int)(Math.random()*sides)];
    }
    public int changeValue(int index, int newValue){
        if(index < 0 || index >= sides){
            return -1;
        }
        value[index] = newValue;
        return 0;
    }
    public int switchValue(int currValue, int newValue){
        for(int i = 0; i < sides; i++){
            if(value[i] == currValue){
                value[i] = newValue;
                return 0;
            }
        }
        return -1;
    }
    public int reset(){
        for(int i = 0; i < sides; i++){
            value[i] = i+1;
        }
        return 0;
    }
    public String toString(){
        String str = "";
        for(int i = 0; i < sides; i++){
            str += value[i] + " ";
        }
        System.out.println(str);
        return str;
    }


    public static void main(String[] args) {
        dice d = new dice(6);
        d.toString();
        d.roll();
        d.toString();
        d.changeValue(3, 7);
        d.toString();
        d.switchValue(7, 3);
        d.toString();
        d.reset();
        d.toString();

    }
}

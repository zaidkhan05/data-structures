import java.util.Scanner;
class InvalidTimeException extends Exception{
    InvalidTimeException(){}
    InvalidTimeException(String message){
        super(message);
    }
}
public class Lab9 {
    static int timeToSeconds(String s) throws InvalidTimeException{
        String[] time = s.split(":", 3);
        if(time.length != 3){
            throw new InvalidTimeException("Enter a valid time");
        }
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        int seconds = Integer.parseInt(time[2]);
        if(hours > 23){
            throw new InvalidTimeException("Hour must be below 24");
        }
        else if(hours < 0){
            throw new InvalidTimeException("Hour must be at least 0");
        }
        if(minutes > 59){
            throw new InvalidTimeException("Minutes must be less than 60");
        }
        else if(minutes < 0){
            throw new InvalidTimeException("Minutes must be at least 0");
        }
        if(seconds > 59){
            throw new InvalidTimeException("Seconds must be less than 60");
        }
        else if(seconds < 0){
            throw new InvalidTimeException("Seconds must be at least 0");
        }
        return (hours*60*60) + (minutes*60) + seconds;
    }
   
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        int seconds = 0;
        System.out.println("Enter time 1 in 24hr format as follows (HH:MM:SS)");
        String s1 = sc.nextLine();
        try{
            seconds -= timeToSeconds(s1);
        }
        catch(InvalidTimeException e){
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        System.out.println("Enter time 2 in 24hr format as follows (HH:MM:SS)");
        String s2 = sc.nextLine();
        try{
            seconds += timeToSeconds(s2);
        }
        catch(InvalidTimeException e){
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        // try{
            System.out.println("Difference in seconds: " + seconds);
        // }
        // catch(InvalidTimeException e){
        //     System.out.println(e.getMessage());
        // }



    }
}

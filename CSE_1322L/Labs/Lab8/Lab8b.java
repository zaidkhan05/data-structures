import java.util.Scanner;

public class Lab8b {
    static String repeatNTimes(String s, int n){
        if(n == 0){
            return "";
        }
        else{
            return s + repeatNTimes(s, n-1);
        }
    }
    static boolean isReverse(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        else if(s1.length() == 0 && s2.length() == 0){
            return true;
        }
        else{
            if(s1.charAt(0) == s2.charAt(s2.length()-1)){
                return isReverse(s1.substring(1), s2.substring(0, s2.length()-1));
            }
            else{
                return false;
            }
        }
    }       

   
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println(repeatNTimes("I must study recursion until it makes sense ", 100));
        System.out.println("Enter the first String");
        String s1 = sc.nextLine();
        System.out.println("Enter the second String");
        String s2 = sc.nextLine();
        if(isReverse(s1, s2)){
            System.out.println(s1 + " is the reverse of " + s2);
        }
        else{
            System.out.println(s1 + " is not the reverse of " + s2);
        }

    }
}

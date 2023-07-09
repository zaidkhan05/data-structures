import java.util.Scanner;

public class Assignment5{
    static String reverse(String s){
        if(s.length() == 0){
            return "";
        }
        else{
            return s.charAt(s.length()-1) + reverse(s.substring(0, s.length()-1));
        }
    }
    static String vToCarrot(String s){
        if(s.length() == 0){
            return "";
        }
        else{
            if(s.charAt(0) == 'v'){
                return '^' + vToCarrot(s.substring(1));
            }
            else{
                return 'v' + vToCarrot(s.substring(1));
            }
        }
    }
    static String paperfold(int n){
        if(n == 1){
            return "v";
        }
        else{
            return vToCarrot(reverse(paperfold(n-1))) + "v" + paperfold(n-1);
        }
    }
    public static void main(String[] args){
        //e
        for(int i=1;i<10;i++) {
            String fold_string = paperfold(i);
            System.out.println("For "+i+" folds we get: "+fold_string+"\n");
        }

    }
}
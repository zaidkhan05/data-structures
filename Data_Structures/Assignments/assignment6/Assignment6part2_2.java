// Name:    Zaid Khan
// Class:   CS 3305/W04
// Term:    Spring 2024
// Instructor:  Carla McManus
// Assignment:  06-Part-2.2-Miles
// IDE:  vscode
public class Assignment6part2_2 {
    public static void main(String[] args) {
        //convert distance measurements from miles to kilometers for input of n numbers
        for(int i = 0; i < 10; i++){
            System.out.println(i * 10 + " miles = " + (i * 10 * 1.6) + " kilometers");
        }
        //determine the worst case efficiency
        System.out.println("Worst case efficiency is O(n) because the time it takes to convert distance measurements from miles to kilometers for input of n numbers is linear");
       
    }
}


//pseuocode
//convert distance measurements from miles to kilometers for input of n numbers
//determine the worst case efficiency

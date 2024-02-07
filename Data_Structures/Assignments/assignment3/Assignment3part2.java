// Name:	Zaid Khan
// Class:	CS 3305/W04
// Term:	Spring 2024
// Instructor:  Carla McManus
// Assignment:  3 – Part 2 State Capitals
// IDE:  Visual Studio Code - Insiders

import java.util.Scanner;

public class Assignment3part2 {
    public static void main(String args[]){
        //setup variables
        int correctAnswers = 0;
        int wrongAnswers = 0;
        int desiredRuns;
        Scanner sc = new Scanner(System.in);
        //ask user how many times they want to guess
        System.out.println("How many times would you like to guess the Capital of the States?");
        desiredRuns = sc.nextInt();
        //cuz readint int then string messes it up
        sc.nextLine();
        //the array of states and capitals
        String[][] statesAndCapitals = {
            {"Alabama", "Montgomery"},
            {"Alaska", "Juneau"},
            {"Arizona", "Phoenix"},
            {"Arkansas", "Little Rock"},
            {"California", "Sacramento"},
            {"Colorado", "Denver"},
            {"Connecticut", "Hartford"},
            {"Delaware", "Dover"},
            {"Florida", "Tallahassee"},
            {"Georgia", "Atlanta"},
            {"Hawaii", "Honolulu"},
            {"Idaho", "Boise"},
            {"Illinois", "Springfield"},
            {"Maryland", "Annapolis"},
            {"Minnesota", "Saint Paul"},
            {"Iowa", "Des Moines"},
            {"Maine", "Augusta"},
            {"Kentucky", "Frankfort"},
            {"Indiana", "Indianapolis"},
            {"Kansas", "Topeka"},
            {"Louisiana", "Baton Rouge"},
            {"Oregon", "Salem"},
            {"Oklahoma", "Oklahoma City"},
            {"Ohio", "Columbus"},
            {"North Carolina", "Raleigh"},
            {"North Dakota", "Bismark"},
            {"New York", "Albany"},
            {"New Mexico", "Santa Fe"},
            {"New Jersey", "Trenton"},
            {"New Hampshire", "Concord"},
            {"Nevada", "Carson City"},
            {"Nebraska", "Lincoln"},
            {"Montana", "Helena"},
            {"Missouri", "Jefferson City"},
            {"Mississippi", "Jackson"},
            {"Massachusettes", "Boston"},
            {"Michigan", "Lansing"},
            {"Pennslyvania", "Harrisburg"},
            {"Rhode Island", "Providence"},
            {"South Carolina", "Columbia"},
            {"South Dakota", "Pierre"},
            {"Tennessee", "Nashville"},
            {"Texas", "Austin"},
            {"Utah", "Salt Lake City"},
            {"Vermont", "Montpelier"},
            {"Virginia", "Richmond"},
            {"Washington", "Olympia"},
            {"West Virginia", "Charleston"},
            {"Wisconsin", "Madison"},
            {"Wyoming", "Cheyenne"}
        };
        //loop through the desired runs
        for(int i = 0; i < desiredRuns; i++){
            //get a random index from the array
            int randomIndex = (int)(Math.random() * 50);
            //get the state and capital from the array
            String state = statesAndCapitals[randomIndex][0];
            String capital = statesAndCapitals[randomIndex][1];
            System.out.println("What is the capital of " + state + "?");
            String userAnswer = sc.nextLine();
            //check if the user's answer is correct
            if(userAnswer.equalsIgnoreCase(capital)){
                System.out.println("Correct!");
                correctAnswers++;
            }
            //if not correct then its wrong 
            else{
                System.out.println("Incorrect! The capital of " + state + " is " + capital);
                wrongAnswers++;
            }
            
        }
        //print the results
        System.out.println("You got " + correctAnswers + " correct answers and " + wrongAnswers + " wrong answers out of " + desiredRuns + " tries.");
        sc.close();
            
    }
}

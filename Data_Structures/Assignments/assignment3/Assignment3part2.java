// Name:	Zaid Khan
// Class:	CS 3305/W04
// Term:	Spring 2024
// Instructor:  Carla McManus
// Assignment:  3 – Part 2 State Capitals
// IDE:  Visual Studio Code - Insiders

import java.util.Scanner;

public class Assignment3part2 {
    public static void main(String args[]){
        int correctAnswers = 0;
        int wrongAnswers = 0;
        int desiredRuns;
        Scanner sc = new Scanner(System.in);
        System.out.println("How many times would you like to guess the Capital of the States?");
        desiredRuns = sc.nextInt();
        sc.close();

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
        for(int i = 0; i < desiredRuns; i++){
            int randomIndex = (int)(Math.random() * 50);
            String state = statesAndCapitals[randomIndex][0];
            String capital = statesAndCapitals[randomIndex][1];
            System.out.println("What is the capital of " + state + "?");
            String userAnswer = System.console().readLine();
            if(userAnswer.equalsIgnoreCase(capital)){
                System.out.println("Correct!");
                correctAnswers++;
            }
            else{
                System.out.println("Incorrect! The capital of " + state + " is " + capital);
                wrongAnswers++;
            }
            
        }
        System.out.println("You got " + correctAnswers + " correct answers and " + wrongAnswers + " wrong answers out of " + desiredRuns + " tries.");
            
    }
}


/*
Write a program that repeatedly prompts the user to guess the capital of a randomly displayed state. 
Upon receiving the user input, the program reports whether the answer is correct. 
Your program must run a minimum of 5 times and display the total number of correct answers. The user’s answer is not case-sensitive.

I have provided the list of states and capitals for you

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

 */
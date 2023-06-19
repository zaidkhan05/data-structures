// import java.util.Scanner;
// interface ISpeak {
// String greeting();
// String getInformation();
// String sayGoodbye();
// }

// abstract class Character implements ISpeak{
//     private String description=null;
//     private String whoami=null;
//     public Character(String d, String w) {
//         description=d;
//         whoami=w;
//     }
//     public String getDescription() {
//         return description;
//     }
//     public boolean guessWho(String guess) {
//         return guess.equalsIgnoreCase(whoami);
//     }
//     public String getCharacterName() {
//         return whoami;
//     }
//     public abstract String greeting();
//     public abstract String getInformation();
//     public abstract String sayGoodbye();
// }


// class Room {
//     static int nextRoomNum=1;
//     int roomNum;
//     Character personInRoom;
//     public Room() {
//         roomNum=nextRoomNum++;
//         if(roomNum==1) {
//             personInRoom=new CharacterOne();
//         }
//         else if(roomNum==2) {
//             personInRoom=new CharacterTwo();
//         }
//         else {
//             personInRoom=new CharacterThree();
//         }
//         System.out.println("Welcome to room number "+roomNum);
//         System.out.println("In here we have a fascinating character from popular movies...");
//         System.out.println("Movie character, please tell us a little about yourself...");
//         System.out.println();
//         System.out.println(" "+personInRoom.getDescription());
//         System.out.println(" "+personInRoom.greeting());
//         System.out.println();
//         }
//         void askForSecret() {
//             System.out.println("Okay, movie character, tell me a secret");
//             System.out.println();
//             System.out.println(" "+personInRoom.getInformation());
//             System.out.println();
//         }
//         void sayGoodbye() {
//             System.out.println("Thank you "+personInRoom.getCharacterName());
//             System.out.println();
//             System.out.println(" "+personInRoom.sayGoodbye());
//             System.out.println();
//         }
//         void guessWho(String nameGuess) {
//             if(personInRoom.guessWho(nameGuess)){
//                 System.out.println("Congratulations you guessed "+nameGuess+" correctly.");
//                 System.out.println(" "+personInRoom.getCharacterName()+" says "+personInRoom.sayGoodbye());
//             }
//             else {
//                 System.out.println("I'm sorry it's not "+nameGuess+" it was "+personInRoom.getCharacterName());
//                 System.out.println(" "+personInRoom.getCharacterName()+" says "+personInRoom.sayGoodbye());
//             }
//     }
// }



// class CharacterOne extends Character {
//     public CharacterOne() {
//         super("I am the emporer of the whole galaxy","Emperor Palpatine");
//     }
//     public String greeting() {
//         return "Would you like to join the sith?";
//     }
//     public String getInformation() {
//         return "HEHEHEHE Join the dark side.";
//     }
//     public String sayGoodbye() {
//         return "No... You will die!";
//     }
// }

// class CharacterTwo extends Character{
//     public CharacterTwo() {
//         super("I'm the guy who always deletes Bowser from existance","Mario");
//     }
//     public String greeting() {
//         return "It's a me";
//     }
//     public String getInformation() {
//         return "I am a plumber";
//     }
//     public String sayGoodbye() {
//         return "Whoopee";
//     }
// }

// class CharacterThree extends Character{
//     public CharacterThree() {
//         super("I just like my life in my hobbit hole, without adventures","Bilbo Baggins");
//     }
//     public String greeting() {
//         return "Ahh yes, hello.";
//     }
//     public String getInformation() {
//         return "I am a burglar";
//     }
//     public String sayGoodbye() {
//         return "Goodbye, im being whisked off to new lands.";
//     }
// }

import java.util.Scanner;

public class Assignment4{
    public static void main(String[] args){
        //e
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<3;i++) {
            Room newRoom=new Room();
            System.out.println("If you know who it is guess, if you don't type hint");
            String theGuess=sc.nextLine();
            if(theGuess.equals("hint")) {
                newRoom.askForSecret();
                System.out.println("OK, so who is it?");
                String finalGuess=sc.nextLine();
                newRoom.guessWho(finalGuess);
            }
            else {
                newRoom.guessWho(theGuess);
            }
        }

        
    }
}



/*
CSE1322L Assignment 4 - Spring 2023
Introduction:
This week’s assignment is going to be a little different from the previous ones. In the
past assignments you’ve had to write a significant amount of code and we’ve given you
very specific details of what you needed to write.
This week however, you will be using your creativity and knowledge of interfaces and
abstract classes to figure out what needs to be written. Remember that an interface is
like a set of rules you must follow. We’ll give you most of the code this week, you just
have to figure out what’s missing and write it.
This week we’ll write a “Guess Who” game. The game works like this:
● The player is sent into room 1.
● In that room there is a popular character from a movie/TV show.
● The character introduces themselves and tells the player a little about
themselves
● The player can either guess their name, or ask them for a hint.
○ If they ask for a hint, the character will tell them a secret, then the
player must guess their name.
○ If they guess the character's name, they are told if they are correct
or wrong, and sent to the next room either way.
Play continues for 3 rooms, each has a different character in it.
Tasks:
● Import (or copy/paste) the following interface into your IDE. Note, you cannot change
this file:
Java C#
interface ISpeak {
String greeting();
String getInformation();
String sayGoodbye();
}
interface ISpeak {
string greeting();
string getInformation();
string sayGoodbye();
}
● Next import (or copy/paste) this abstract class called “Character”. Note, you cannot
change this file:
Java C#
abstract class Character implements ISpeak{
private String description=null;
private String whoami=null;
public Character(String d, String w) {
description=d;
whoami=w;
}
public String getDescription() {
return description;
}
public boolean guessWho(String guess) {
return guess.equalsIgnoreCase(whoami);
}
public String getCharacterName() {
return whoami;
}
public abstract String greeting();
public abstract String getInformation();
public abstract String sayGoodbye();
}
abstract class Character : ISpeak{
private string description=null;
private string whoami=null;
public Character(string d, string w) {
description=d;
whoami=w;
}
public string getDescription() {
return description;
}
public bool guessWho(string guess) {
string lowerGuess=guess.ToLower();
string rightAns=whoami.ToLower();
return(lowerGuess.Equals(rightAns));
}
public string getCharacterName() {
return whoami;
}
public abstract string greeting();
public abstract string getInformation();
public abstract string sayGoodbye();
}
● Next import (or copy/paste) the class called “Room”. Note, you cannot change this file:
Java C#
class Room {
static int nextRoomNum=1;
int roomNum;
Character personInRoom;
public Room() {
roomNum=nextRoomNum++;
if(roomNum==1) {
personInRoom=new CharacterOne();
}
else if(roomNum==2) {
personInRoom=new CharacterTwo();
}
else {
personInRoom=new CharacterThree();
}
System.out.println("Welcome to room
number "+roomNum);
System.out.println("In here we have a
fascinating character from popular
movies...");
System.out.println("Movie character,
please tell us a little about yourself...");
System.out.println();
System.out.println("
"+personInRoom.getDescription());
System.out.println("
"+personInRoom.greeting());
System.out.println();
}
void askForSecret() {
System.out.println("Okay, movie character,
tell me a secret");
System.out.println();
System.out.println("
"+personInRoom.getInformation());
System.out.println();
}
void sayGoodbye() {
System.out.println("Thank you
"+personInRoom.getCharacterName());
System.out.println();
System.out.println("
"+personInRoom.sayGoodbye());
using System;
class Room {
static int nextRoomNum=1;
int roomNum;
Character personInRoom;
public Room() {
roomNum=nextRoomNum++;
if(roomNum==1) {
personInRoom=new CharacterOne();
}
else if(roomNum==2) {
personInRoom=new CharacterTwo();
}
else {
personInRoom=new CharacterThree();
}
Console.WriteLine("Welcome to room
number "+roomNum);
Console.WriteLine("In here we have a
fascinating character from popular
movies...");
Console.WriteLine("Movie character,
please tell us a little about yourself...");
Console.WriteLine();
Console.WriteLine("
"+personInRoom.getDescription());
Console.WriteLine("
"+personInRoom.greeting());
Console.WriteLine();
}
public void askForSecret() {
Console.WriteLine("Okay, movie character,
tell me a secret");
Console.WriteLine();
Console.WriteLine("
"+personInRoom.getInformation());
Console.WriteLine();
}
public void sayGoodbye() {
Console.WriteLine("Thank you
"+personInRoom.getCharacterName());
Console.WriteLine();
System.out.println();
}
void guessWho(String nameGuess) {
if(personInRoom.guessWho(nameGuess))
{
System.out.println("Congratulations you
guessed "+nameGuess+" correctly.");
System.out.println("
"+personInRoom.getCharacterName()+" says
"+personInRoom.sayGoodbye());
}
else {
System.out.println("I'm sorry it's not
"+nameGuess+" it was
"+personInRoom.getCharacterName());
System.out.println("
"+personInRoom.getCharacterName()+" says
"+personInRoom.sayGoodbye());
}
}
}
Console.WriteLine("
"+personInRoom.sayGoodbye());
Console.WriteLine();
}
public void guessWho(string nameGuess) {
if(personInRoom.guessWho(nameGuess))
{
Console.WriteLine("Congratulations you
guessed "+nameGuess+" correctly.");
Console.WriteLine("
"+personInRoom.getCharacterName()+" says
"+personInRoom.sayGoodbye());
}
else {
Console.WriteLine("I'm sorry it's not
"+nameGuess+" it was
"+personInRoom.getCharacterName());
Console.WriteLine("
"+personInRoom.getCharacterName()+" says
"+personInRoom.sayGoodbye());
}
}
}
● Finally in your driver class, add the following code to your main method (note you cannot
change this code):
Java C#
public static void main(String[] args) {
Scanner myScan=new
Scanner(System.in);
for(int i=0;i<3;i++) {
Room newRoom=new Room();
System.out.println("If you know who it is
guess, if you don't type hint");
String theGuess=myScan.nextLine();
if(theGuess.equals("hint")) {
newRoom.askForSecret();
System.out.println("OK, so who is it?");
String finalGuess=myScan.nextLine();
newRoom.guessWho(finalGuess);
}
else {
newRoom.guessWho(theGuess);
}
}
public static void Main (string[] args) {
for(int i=0;i<3;i++) {
Room newRoom=new Room();
Console.WriteLine("If you know who it is
guess, if you don't type hint");
String theGuess=Console.ReadLine();
if(theGuess.Equals("hint")) {
newRoom.askForSecret();
Console.WriteLine("OK, so who is it?");
String finalGuess=Console.ReadLine();
newRoom.guessWho(finalGuess);
}
else {
newRoom.guessWho(theGuess);
}
}
}
}
Based on the above code, you can see that there are 3 classes missing:
● CharacterOne
● CharacterTwo
● CharacterThree
From the code you have above, you can tell what methods they should each have.
Your job is to come up with three (3) famous characters, and implement CharacterOne as one of
them, CharacterTwo as another, and CharacterThree as the third. They can be any character
from movies/TV.
Note you should NOT use the same characters shown in the sample output below, those are
just examples of the code running.
Example Runs: [User input in red]
Welcome to room number 1
In here we have a fascinating character from popular movies...
Movie character, please tell us a little about yourself...
I'm a small, green creature with big ears
Hello young one, hummm?
If you know who it is guess, if you don't type hint
hint
Okay, movie character, tell me a secret
A secret, hmmm? Well, let me think... Ah, here's one for you, young Padawan: the path to
mastery, it is. Not just knowledge, hmmm? Not just power, no. But also, inner peace, balance
and humility, it must include. So, remember this always, hmmm?
OK, so who is it?
Yoda
Congratulations you guessed Yoda correctly.
Yoda says Farewell, young one, hmmm? May the Force be with you, always.
Welcome to room number 2
In here we have a fascinating character from popular movies...
Movie character, please tell us a little about yourself...
I'm a slow-witted but athletically-talented individual, who is loyal and trustworthy to those I
care about.
Hello there! Nice to meet ya!
If you know who it is guess, if you don't type hint
Forrest Gump
Congratulations you guessed Forrest Gump correctly.
Forrest Gump says Goodbye! It was nice talking to you, I hope we can chat again soon. Bye
now!
Welcome to room number 3
In here we have a fascinating character from popular movies...
Movie character, please tell us a little about yourself...
I'm known for my distinctive appearance, including my bald head and prominent scar, as well
as his frequent use of catchphrases, such as "Throw me a frickin' bone here"
Hello there, it's good to see you. Muahahahaha!
If you know who it is guess, if you don't type hint
hint
Okay, movie character, tell me a secret
Just between us, okay? Promise not to tell anyone... Here's a little something I learned from
all my world domination attempts: always have a backup plan. You never know when the first
one might fail, so always have a Plan B ready. That's my secret, and now it's yours.
Muahahahaha!
OK, so who is it?
Harry Potter
I'm sorry it's not Harry Potter it was Dr. Evil
Dr. Evil says Goodbye, my friend. It's been a pleasure, as always. But now, I must go and
continue my plans for world domination. Muahahahaha! Until we meet again...

 */
import java.util.Scanner;

abstract class item{
    private String title;
    public item(){
        title = "";
    }
    public item(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String toString(){
        return title;
    }
    public abstract String getListing();
}
//create book class
class book extends item{
    private String isbn_number;
    private String author;
    public book(){
        setTitle("");
        isbn_number = "";
        author = "";
    }
    public book(String title, String isbn_number, String author){
        setTitle(title);
        this.isbn_number = isbn_number;
        this.author = author;
    }
    public String getIsbn_number(){
        return isbn_number;
    }
    public void setIsbn_number(String isbn_number){
        this.isbn_number = isbn_number;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    public String getListing(){
        return "Book Name- " + toString() + "\nAuthor- " + author + "\nISBN#- " + isbn_number;
    }
}
class Periodical extends item{
    private String issueNum;
    public Periodical(){
        setTitle("");
        issueNum = "";
    }
    public Periodical(String title, String issueNum){
        setTitle(title);
        this.issueNum = issueNum;
    }
    public String getIssueNum(){
        return issueNum;
    }
    public void setIssueNum(String issueNum){
        this.issueNum = issueNum;
    }

    public String getListing(){
        return "Periodical Title- " + toString() + "\nIssue#- " + issueNum;
    }
}
public class Lab5 {
   
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        item[] items = new item[5];
        String title, author, isbn_number, issueNum, choice;
        for(int i = 0; i < 5; i++){
            System.out.println("Please enter B for Book or P for Periodical");
            choice = sc.nextLine();
            if(choice.equalsIgnoreCase("b")){
                System.out.println("Please enter the title of the book");
                title = sc.nextLine();
                System.out.println("Please enter the author of the book");
                author = sc.nextLine();
                System.out.println("Please enter the ISBN number of the book");
                isbn_number = sc.nextLine();
                items[i] = new book(title, isbn_number, author);
            }
            else if(choice.equalsIgnoreCase("p")){
                System.out.println("Please enter the title of the periodical");
                title = sc.nextLine();
                System.out.println("Please enter the issue number of the periodical");
                issueNum = sc.nextLine();
                items[i] = new Periodical(title, issueNum);
            }
            else{
                System.out.println("Invalid choice");
                i--;
            }
        }
        System.out.println("Your items:");
        for(int i = 0; i < 5; i++){
            System.out.println(items[i].getListing());
            System.out.println();
        }
    }
}

/*
CSE1322L - Lab 5
Concept Summary:
1. Object Oriented programming concepts
2. Abstract classes
3. Polymorphism
Objective:
In this Lab you will need to create three classes and a driver program. The first class, the
parent, should be an abstract class called Item. The other two classes, the children, should
inherit from the parent class and be called Book and Periodicals. Finally, create a test class
called myCollection.
Using IntelliJ/Visual Studio create a UML diagram for this Lab.
Item abstract class
Create an abstract class called Item. It must have:
● title - A private attribute of type string.
● A getter/setter for title
● A constructor that takes no arguments and sets title to empty string
● A constructor which takes a title and sets the title attribute.
● getListing() is an abstract method that returns a string and is implemented in classes Book
and Periodicals.
● An override of toString/ToString which returns the title.
Book child class
Create a Book class which inherits from Item. It must have:
● isbn_number - A private attribute which holds an ISBN number (13 digits) to identify
the book
● author - A private attribute which holds the authors name (string)
● getters/setters for the attributes in this class.
● A constructor which takes no arguments
● An overloaded constructor which sets all the attributes in the Book class as well as the
Item class.
● A concrete version of the getListing() method which should return a string that contains
the following:
Book Name - Title
Author - Author
ISBN # - ISBN number
Periodical child class
Create a Periodical class which inherits from Item. It must have:
● issueNum - A private attribute which holds the issue number (e.g. 103)
● getter/setter for issueNum
● A constructor which takes no arguments
● An overloaded constructor which sets all the attributes in the Periodical class as well as
the Item class.
● A concrete version of the getListing() method which should return a string that contains
the following:
Periodical Title - Title
Issue # - Issue number
myCollection Driver Program
Write the driver program which will prompt the user exactly 5 times to add Books and
Periodicals to an array.
The array should be of type Item since it can hold either Books or Periodicals. This is
polymorphism!
Ask the user to “Please enter B for Book or P for Periodical”
If they choose Book, prompt for Title, Author and ISBN number. Store the results in the
next cell of the array.
If they choose Periodical, prompt for Title and IssueNumber. Store the result in the next
cell of the array.
Once the user has entered 5 items which could be any combination of Books and
Periodicals, show the user their collection.
See sample output below.
Sample Output:
Please enter B for Book or P for Periodical
B
Please enter the name of the Book
Lord of the Rings
Please enter the author of the Book
Tolkien
Please enter the ISBN of the Book
34
Please enter B for Book or P for Periodical
P
Please enter the name of Periodical
Times
Please enter the issue number
1234
Please enter B for Book or P for Periodical
B
Please enter the name of the Book
War and Peace
Please enter the author of the Book
Tolstoy
Please enter the ISBN of the Book
4567
Please enter B for Book or P for Periodical
B
Please enter the name of the Book
Alice in Wonderland
Please enter the author of the Book
Lewis Carroll
Please enter the ISBN of the Book
7890
Please enter B for Book or P for Periodical
P
Please enter the name of Periodical
New Yorker
Please enter the issue number
45
Your Items:
Book Name - Lord of the Rings
Author - Tolkien
ISBN# - 34
Periodical Title - Times
Issue # - 1234
Book Name - War and Peace
Author - Tolstoy
ISBN# - 4567
Book Name - Alice in Wonderland
Author - Lewis Carroll
ISBN# - 7890
Periodical Title - New Yorker
Issue # - 45
 */
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

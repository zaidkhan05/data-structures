import java.util.Scanner;
class BlueRayDisk{
    public String title;
    public String director;
    public int yearOfRelease;
    public double cost;
    BlueRayDisk(String title, String director, int yearOfRelease, double cost){
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.cost = cost;
    }
    public String toString(){
        return "$" + cost + " " + yearOfRelease + " " + title + ", " + director;
    }
}

class Node{
    public BlueRayDisk data;
    public Node next;
}

class BlueRayCollection{
    private Node head = null;
    public void add(String title, String director, int yearOfRelease, double cost){
        Node temp = new Node();
        temp.data = new BlueRayDisk(title, director, yearOfRelease, cost);
        temp.next = null;
        if (head == null) {
            head = temp;
        } 
        else {
            Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = temp;
    }
    }
    public void show_all(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
public class Lab12{

    public static void main(String[] args){
        //e
        Scanner sc = new Scanner(System.in);
        BlueRayCollection brc = new BlueRayCollection();
        int choice = 0;
        do{
            System.out.println("0. Quit");
            System.out.println("1. Add BlueRay to collection");
            System.out.println("2. See collection");
            choice = sc.nextInt();
            switch(choice){
                case 0:
                    break;
                case 1:
                    System.out.println("What is the title?");
                    sc.nextLine();
                    String title = sc.nextLine();
                    System.out.println("What is the director?");
                    String director = sc.nextLine();
                    System.out.println("What is the year of release?");
                    int yearOfRelease = sc.nextInt();
                    System.out.println("What is the cost?");
                    double cost = sc.nextDouble();
                    brc.add(title, director, yearOfRelease, cost);
                    break;
                case 2:
                    brc.show_all();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while(choice != 0);

    }
}

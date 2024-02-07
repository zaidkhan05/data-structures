// Name:	Zaid Khan
// Class:	CS 3305/W04
// Term:	Spring 2024
// Instructor:  Carla McManus
// Assignment:  3 – Part 1 Iterator
// IDE:  Visual Studio Code - Insiders


//node
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

//linked list class
class LinkedList{
    Node head;
    //add method to add data to the list
    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    //printrange method
    public void printRange(int x, int y){
        this.removeRepetitions();
        Node temp = head;
        boolean xFound = false;
        boolean yFound = false;
        //check if x and y are in the list
        while(temp != null){
            if(temp.data == x){
                xFound = true;
            }
            if(temp.data == y){
                yFound = true;
            }
            temp = temp.next;
        }
        //no x then no print :)
        if(!xFound){
            System.out.println();
        }
        //makes sure x is before y if y is even in the list
        else if(xFound && yFound && x<y){
            temp = head;
            while(temp != null){
                if(temp.data == x){
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                    while(temp.data != y){
                        System.out.print(temp.data + " ");
                        temp = temp.next;
                    }
                    break;
                }
                temp = temp.next;
            }
            System.out.println();
        }
        //if y is not in the list then still print x to the end
        else if(xFound){
            temp = head;
            while(temp != null){
                if(temp.data == x){
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                    while(temp != null){
                        System.out.print(temp.data + " ");
                        temp = temp.next;
                    }
                    break;
                }
                temp = temp.next;
            }
            System.out.println();
        }
    }
    //remove repetitions method
    public void removeRepetitions(){
        Node p = head;
        while(p != null){
            Node q = p;
            while(q.next != null){
                if(p.data == q.next.data){
                    q.next = q.next.next;
                }
                else{
                    q = q.next;
                }
            }
            p = p.next;
        }
    }

}


public class Assignment3part1 {


    public static void main(String[] args) {
        //create a linked list
        LinkedList sampleData = new LinkedList();
        //add values to the list
        sampleData.add(1);
        sampleData.add(1);
        sampleData.add(2);
        sampleData.add(3);
        sampleData.add(3);
        sampleData.add(4);
        sampleData.add(4);
        sampleData.add(5);
        sampleData.add(6);
        sampleData.add(7);

        //print the range of values
        sampleData.printRange(2, 5);

       sampleData.printRange(2, 78);

        sampleData.printRange(2, 1);

        sampleData.printRange(8, 5);
    }
}

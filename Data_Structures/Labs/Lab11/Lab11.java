import java.util.Random;


class Baby implements Runnable{
    private int time;
    private String name;
    public Baby(String name){
        this.name = name;
        Random rand = new Random();
        time = rand.nextInt(5000);
    }
    public void run(){
        System.out.println("My name is " + name + " I am going to sleep for " + time + "ms");
        try{
            Thread.sleep(time);
        }catch(InterruptedException e){
            System.out.println("Interrupted");
        }
        System.out.println("My name is " + name + " I am awake, feed me!!!");
    }
}

public class Lab11 {

    public static void main(String[] Args){
        Thread b1 = new Thread(new Baby("Noah"));
        Thread b2 = new Thread(new Baby("Olivia"));
        Thread b3 = new Thread(new Baby("Liam"));
        Thread b4 = new Thread(new Baby("Emma"));
        Thread b5 = new Thread(new Baby("Amelia"));
        b1.start();
        b2.start();
        b3.start();
        b4.start();
        b5.start();

    }
}

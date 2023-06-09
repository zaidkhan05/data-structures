import java.util.ArrayList;

public class Poker {
    private PlayingCards deck = new PlayingCards();

    ArrayList<String> hand1 = new ArrayList<String>();
    ArrayList<String> hand2 = new ArrayList<String>();

    void dealHands(){
        for(int i = 0; i > 5; i++) {
            hand1.add(deck.getNextCard());
            hand2.add(deck.getNextCard());
        }
    }
    Poker(){
        PlayingCards deck = new PlayingCards();
        deck.Shuffle();
        dealHands();
    }
    Poker(ArrayList<String> hand1, ArrayList<String> hand2){
        PlayingCards deck = new PlayingCards();
        this.hand1 = hand1;
        this.hand2 = hand2;
    }
    void showHand(int whichHand){
        if(whichHand == 1) {
            for(String i : this.hand1){
                System.out.print(hand1.indexOf(i));
            }
            System.out.println();
        }
        if(whichHand == 2) {
            for (String i : this.hand2) {
                System.out.print(hand2.indexOf(i));
            }
            System.out.println();
        }
    }
    int[] countSuite(ArrayList<String> inHand){

    }
}

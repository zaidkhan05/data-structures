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
                //System.out.print(hand1.indexOf(i));
                System.out.print(i+" ");
            }
            System.out.println();
        }
        if(whichHand == 2) {
            for (String i : this.hand2) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    int[] countSuite(ArrayList<String> inHand){
        int[] suiteCount = new int[4];
        for(String i : inHand){
            if(i.contains("Clubs")){
                suiteCount[0]++;
            }
            if(i.contains("Diamonds")){
                suiteCount[1]++;
            }
            if(i.contains("Hearts")){
                suiteCount[2]++;
            }
            if(i.contains("Spades")){
                suiteCount[3]++;
            }
        }
        return suiteCount;
    }

    
    int[] countValue(ArrayList<String> inHand){
        int[] cardValue = new int[14];
        for(String i : inHand){
            if(i.contains("A")){
                cardValue[1]++;
            }
            if(i.contains("2")){
                cardValue[2]++;
            }
            if(i.contains("3")){
                cardValue[3]++;
            }
            if(i.contains("4")){
                cardValue[4]++;
            }
            if(i.contains("5")){
                cardValue[5]++;
            }
            if(i.contains("6")){
                cardValue[6]++;

            }
            if(i.contains("7")){
                cardValue[7]++;
            }
            if(i.contains("8")){
                cardValue[8]++;
            }
            if(i.contains("9")){
                cardValue[9]++;
            }
            if(i.contains("10")){
                cardValue[10]++;
            }
            if(i.contains("Jack")){
                cardValue[11]++;
            }
            if(i.contains("Queen")){
                cardValue[12]++;
            }
            if(i.contains("King")){
                cardValue[13]++;
            }
        }
        return cardValue;
    }
    int numPairs(int[] countedValues){
        int pairs = 0;
        for(int i = 0; i < countedValues.length; i++){
            if(countedValues[i] == 2){
                pairs++;
            }
        }
        return pairs;
    }
    int threeOfAKind(int[] countedValues){
        for(int i = 0; i < countedValues.length; i++){
            if(countedValues[i] == 3){
                return i;
            }
        }
        return 0;
    }
    int fourOfAKind(int[] countedValues){
        for(int i = 0; i < countedValues.length; i++){
            if(countedValues[i] == 4){
                return i;
            }
        }
        return 0;
    }
    boolean fullHouse(int[] countedValues){
        if(numPairs(countedValues) == 1 && threeOfAKind(countedValues) != 0){
            return true;
        }
        return false;
    }
    boolean straight(int[] countedValues){
        int timesLooped = 0;
        int count = 0;
        for(int i = 0; i < countedValues.length; i++){
            if(timesLooped == 2){
                return false;
            }
            if(i == 13 && count < 5 && count != 0){
                count++;
                timesLooped++;
                i = 0;
            }
            else if(countedValues[i] == 1){
                count++;
            }
            
            else{
                count = 0;
            }
            if(count == 5){
                return true;
            }
        }
        return false;
    }
    boolean flush(int[] countedSuites){
        for(int i = 0; i < countedSuites.length; i++){
            if(countedSuites[i] == 5){
                return true;
            }
        }
        return false;
    }
    boolean straightFlush(int[] countedValues, int[] countedSuites){
        if(straight(countedValues) && flush(countedSuites)){
            return true;
        }
        return false;
        
    }
    boolean royalFlush(int[] countedValues, int[] countedSuites){
        if(flush(countedSuites) && countedValues[10] == 1 && countedValues[11] == 1 && countedValues[12] == 1 && countedValues[13] == 1 && countedValues[1] == 1){
            return true;
        }
        return false;
    }
    String scoreHand(int whichHand){
        if(whichHand == 1){
            int[] countedValues = countValue(hand1);
            int[] countedSuites = countSuite(hand1);
            if(royalFlush(countedValues, countedSuites)){
                return "Royal Flush";
            }
            if(straightFlush(countedValues, countedSuites)){
                return "Straight Flush";
            }
            if(fourOfAKind(countedValues) != 0){
                return "Four of a Kind";
            }
            if(fullHouse(countedValues)){
                return "Full House";
            }
            if(flush(countedSuites)){
                return "Flush";
            }
            if(straight(countedValues)){
                return "Straight";
            }
            if(threeOfAKind(countedValues) != 0){
                return "Three of a Kind";
            }
            if(numPairs(countedValues) == 2){
                return "Two Pair";
            }
            if(numPairs(countedValues) == 1){
                return "Pair";
            }
            return "High Card";
        }
        if(whichHand == 2){
            int[] countedValues = countValue(hand2);
            int[] countedSuites = countSuite(hand2);
            if(royalFlush(countedValues, countedSuites)){
                return "Royal Flush";
            }
            if(straightFlush(countedValues, countedSuites)){
                return "Straight Flush";
            }
            if(fourOfAKind(countedValues) != 0){
                return "Four of a Kind";
            }
            if(fullHouse(countedValues)){
                return "Full House";
            }
            if(flush(countedSuites)){
                return "Flush";
            }
            if(straight(countedValues)){
                return "Straight";
            }
            if(threeOfAKind(countedValues) != 0){
                return "Three of a Kind";
            }
            if(numPairs(countedValues) == 2){
                return "Two Pair";
            }
            if(numPairs(countedValues) == 1){
                return "Pair";
            }
            return "High Card";
        }
        return "Error";
    }
}

package Game;
import Cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private  String name ;
    private final ArrayList<Card> hand = new ArrayList<>();
    private int score ;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }

    public void emptyHand(){
        hand.clear();
    }

    public void addScore(int score){
        this.score += score;
    }

    public void addCardToHand(Card card){
        hand.add(card);
    }

    public void addCardsToHand(ArrayList<Card> cards) {
        hand.addAll(cards);
    }

    public void removeCardFromHand(int index){
        hand.remove(index) ;
    }

    public int numberOfHandCards(){
        return hand.size();
    }

    public Card getCardAtIndex(int index ){
        return hand.get(index);
    }



    public void displayHand(){
        System.out.println(hand);
    }



}

package Deck;

import Cards.*;

import java.util.ArrayList;
import java.util.Collections;


public class Deck {

    private final ArrayList<Card> deck = new ArrayList<>() ;

    public Deck() {
        initailizeDeck();
    }

    public void addCard(Card card ){
        deck.add(card) ;
    }

    public Card getTop(){
        return deck.get(getCardsNumberInDeck()-1);
    }

    public int getCardsNumberInDeck(){
        return deck.size();
    }

    public Card drawCard(){

        if (isEmpty())
           initailizeDeck();

        return deck.removeLast();
    }

    public ArrayList<Card> drawCard(int numberOfCards){

        ArrayList<Card> cardsTemp = new ArrayList<>(numberOfCards) ;
        for (int i = 0; i < numberOfCards; i++) {
            cardsTemp.add(drawCard());
        }
        return cardsTemp;
    }

    public void shuffleTheDeck(){
        Collections.shuffle(deck);
    }

    public void clearDeck(){
        deck.clear();
    }
    public boolean isEmpty(){
        return getCardsNumberInDeck() == 0 ;
    }
    public void initailizeDeck(){

        for (CardColor cardColor : CardColor.values()){
            for (CardValue cardValue : CardValue.values() ){
                this.addCard(CardFactory.generateCard(CardType.NUMBERED , cardColor , cardValue , CardAction.NO_ACTION)) ;
                if (cardValue.ordinal() != 0 ){
                    this.addCard(CardFactory.generateCard(CardType.NUMBERED , cardColor , cardValue , CardAction.NO_ACTION)) ;
                }

        }
            for (int i = 0 ; i < 2 ; i++){

                this.addCard(CardFactory.generateCard(CardType.ACTION ,  cardColor , null , CardAction.REVERSE));
                this.addCard(CardFactory.generateCard(CardType.ACTION ,  cardColor , null , CardAction.SKIP)) ;
                this.addCard(CardFactory.generateCard(CardType.ACTION ,  cardColor , null , CardAction.DRAW_TWO)) ;

            }

        }
        for (int i = 0 ; i < 4 ; i++){
            this.addCard(CardFactory.generateCard(CardType.WILD ,  null , null , CardAction.WILD_DRAW_FOUR)) ;
            this.addCard(CardFactory.generateCard(CardType.WILD , null , null , CardAction.WILD)) ;
        }
        shuffleTheDeck();
    }


}

package Game;

import Cards.CardColor;
import Deck.Deck;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {
    protected ArrayList<Player> players = new ArrayList<Player>() ;
    protected CardColor currentCardColor  ;
    protected int currentPlayer;
    protected Deck deck = new Deck();
    protected boolean isClockWise ;
    public Game(){}

    public boolean getIsClockWise() {
        return isClockWise;
    }
    public void setIsClockWise() {
        isClockWise ^= isClockWise;
    }
    public int getNumberOfPlayers(){
        return players.size();
    }
    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public CardColor getCurrentColor() {
        return currentCardColor;
    }
    public void setCurrentColor(CardColor currentCardColor) {
        this.currentCardColor = currentCardColor;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }
    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Deck getDeck() {
        return deck;
    }
    public void setDeck(Deck deck) {
        this.deck = deck;
    }
    public abstract void play();
    public abstract void initialize();
    public abstract void drawHands(int nuberOfCard );

}
